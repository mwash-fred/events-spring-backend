package apps.myuzinc.events.utils;

import apps.myuzinc.events.dao.Permissions.Permissions;
import apps.myuzinc.events.dao.Roles.Role;
import apps.myuzinc.events.dao.Users.Users;
import apps.myuzinc.events.dto.PermissionDto;
import apps.myuzinc.events.dto.RoleDto;
import apps.myuzinc.events.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class ModelDtoMapper {
    public Users userDTOToModel(UserDto userDto){
        Function<UserDto, Users> usersFunction = dto -> Users.builder()
                .name(dto.name())
                .mobileNo(dto.mobileNo())
                .email(dto.email())
                .isAccountExpired(dto.isAccountExpired())
                .isAccountLocked(dto.isAccountLocked())
                .isEnabled(dto.isEnabled())
                .isCredentialsExpired(dto.isCredentialsExpired())
                .password(dto.password())
                .roles(dto.roles().stream().map(this::roleDTOTOModel).collect(Collectors.toList()))
                .build();
        return usersFunction.apply(userDto);
    }

    public UserDto userModelTODTO(Users users){
        Function<Users, UserDto> userDtoFunction = model -> new UserDto(model.getUid(), model.getName(), model.getEmail(),
                model.getMobileNo(), model.getPassword(), model.getIsEnabled(), model.getIsCredentialsExpired(),
                model.getIsAccountLocked(), model.getIsAccountExpired(),
                model.getRoles().stream().map(this::roleModelToDTO).collect(Collectors.toList()), model.getPostedTime(),
                model.getModifiedTime());
        return userDtoFunction.apply(users);
    }

    public Role roleDTOTOModel(RoleDto roleDto){
        Function<RoleDto, Role> roleFunction = dto -> Role.builder()
                .uid(dto.uid())
                .privileges(dto.privileges().stream().map(this::permissionsDTOTOModel).collect(Collectors.toList()))
                .name(dto.name())
                .build();
        return roleFunction.apply(roleDto);
    }

    public RoleDto roleModelToDTO(Role role){
        Function<Role, RoleDto> roleDtoFunction = model -> new RoleDto(model.getUid(), model.getName(),
                model.getPostedTime(), model.getModifiedTime(),
                model.getPrivileges().stream().map(this::permissionModelTODTO).collect(Collectors.toList()));
        return roleDtoFunction.apply(role);
    }

    public Permissions permissionsDTOTOModel(PermissionDto permissionDto){
        Function<PermissionDto, Permissions> permissionsFunction = dto -> Permissions.builder()
                .name(apps.myuzinc.events.utils.enums.Permissions.valueOf(dto.name()))
                .uid(dto.uid())
                .build();
        return permissionsFunction.apply(permissionDto);
    }

    public PermissionDto permissionModelTODTO(Permissions permissions){
        Function<Permissions, PermissionDto> permissionDtoFunction = model -> new PermissionDto(model.getUid(),
                model.getName().permission);
        return permissionDtoFunction.apply(permissions);
    }
}
