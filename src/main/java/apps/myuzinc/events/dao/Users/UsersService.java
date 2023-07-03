package apps.myuzinc.events.dao.Users;

import apps.myuzinc.events.dto.CredentialsDto;
import apps.myuzinc.events.dto.LoginDto;
import apps.myuzinc.events.dto.UserDto;
import apps.myuzinc.events.exceptions.EmailAlreadyTakenException;
import apps.myuzinc.events.exceptions.PhoneNumberAlreadyInUse;
import apps.myuzinc.events.security.jwt.JwtUtils;
import apps.myuzinc.events.utils.ModelDtoMapper;
import apps.myuzinc.events.utils.sql.CrudOperations;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor @Transactional
public class UsersService implements CrudOperations<UserDto> {
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final ModelDtoMapper modelDtoMapper;


    @Override
    public UserDto save(UserDto record) {
        Users users = modelDtoMapper.userDTOToModel(record);
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        if(usersRepository.existsByEmail(users.getEmail())){
            throw new EmailAlreadyTakenException("Email Already Taken");
        }
        if(usersRepository.existsByMobileNo(users.getMobileNo())){
            throw  new PhoneNumberAlreadyInUse("Phone Number Already Taken");
        }
        return modelDtoMapper.userModelTODTO(usersRepository.save(users));
    }

    @Override
    public UserDto read(String uid) {
        return null;
    }

    @Override
    public UserDto update(UserDto record) {
        return null;
    }

    @Override
    public UserDto delete(UserDto uid) {
        return null;
    }

    @Override
    public List<UserDto> getAll() {
        return null;
    }

    public CredentialsDto signIn(LoginDto dto){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.email(), dto.password())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        return CredentialsDto.builder()
                .jwt(jwtUtils.generateJwtToken(authentication))
                .authorities(userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .email(userDetails.getUsername())
                .build();

    }
}
