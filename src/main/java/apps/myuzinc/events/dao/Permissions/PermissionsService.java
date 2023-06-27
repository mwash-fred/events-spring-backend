package apps.myuzinc.events.dao.Permissions;

import apps.myuzinc.events.dto.PermissionDto;
import apps.myuzinc.events.utils.ModelDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service @Transactional
@RequiredArgsConstructor
public class PermissionsService {
    private final PermissionsRepository permissionsRepository;
    private final ModelDtoMapper modelDtoMapper;

    @PreAuthorize("hasAuthority('permissions:inquire')")
    public List<PermissionDto> allPermissions(){
        return permissionsRepository.findAll().stream().map(modelDtoMapper::permissionModelTODTO)
                .collect(Collectors.toList());
    }
}
