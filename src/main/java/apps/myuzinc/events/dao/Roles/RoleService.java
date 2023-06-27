package apps.myuzinc.events.dao.Roles;

import apps.myuzinc.events.dto.RoleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service @Transactional
@RequiredArgsConstructor
public class RoleService {
    public static final String ROLE_NOT_FOUND = "Role could not be retrieved.";
    private final RoleRepository roleRepository;

    @PreAuthorize("hasAuthority('role:inquire')")
    public List<RoleDto> allRoles(){
        return null;
    }

    @PreAuthorize("hasAuthority('role:inquire')")
    public RoleDto read(String uid){
        return null;
    }

    @PreAuthorize("hasAuthority('role:update')")
    public RoleDto updateRole(String uid, RoleDto roleDto){
        return null;
    }

    @PreAuthorize("hasAuthority('role:add')")
    public RoleDto create(RoleDto roleDto){
        return  null;
    }
}
