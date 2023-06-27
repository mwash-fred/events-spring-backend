package apps.myuzinc.events.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;

public record RoleDto(
        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        String uid,
        @NotNull(message = "Role Name cannot be null")
        @NotBlank(message = "Role Name cannot be blank")
        @NotEmpty(message = "Role Name cannot be empty")
        String name,
        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        Date postedTime,
        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        Date modifiedTime,
        @Valid
        List<PermissionDto> privileges
) {
}
