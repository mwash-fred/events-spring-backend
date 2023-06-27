package apps.myuzinc.events.dao.Users;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Getter
public class UserDetailsImpl implements UserDetails {

	private final String email;
	private final String password;
	private final Boolean isEnabled;
	private final Boolean isCredentialsExpired;
	private final Boolean isAccountLocked;
	private final Boolean isAccountExpired;
	private final Collection<? extends GrantedAuthority> authorities;

	public static UserDetailsImpl build(Users user) {
		List<GrantedAuthority> authorities = user.getRoles().stream()
				.flatMap(role -> role.getPrivileges().stream())
				.map(permission -> new SimpleGrantedAuthority(permission.getName().getPermission().toLowerCase()))
				.collect(Collectors.toList());

		return new UserDetailsImpl(
				user.getEmail(),
				user.getPassword(),
				user.getIsEnabled(),
				user.getIsCredentialsExpired(),
				user.getIsAccountLocked(),
				user.getIsAccountExpired(),
				authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return !isAccountExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return !isAccountLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return !isCredentialsExpired;
	}

	@Override
	public boolean isEnabled() {
		return isEnabled;
	}
}
