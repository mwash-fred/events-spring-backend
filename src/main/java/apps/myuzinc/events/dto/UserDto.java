package apps.myuzinc.events.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.util.Date;
import java.util.List;

public record UserDto(
        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        String uid,
        @NotNull(message = "Name cannot be null")
        @NotEmpty(message = "Name cannot be empty")
        @NotBlank(message = "Name cannot be blank")
        String name,
        @Email(message = "Provide a valid email address")
        String email,
        @NotNull(message = "Mobile No cannot be null")
        @NotEmpty(message = "Mobile No cannot be empty")
        @NotBlank(message = "Mobile No cannot be blank")
        @Size(min = 12, max = 12, message = "Provide a valid phone no")
        String mobileNo,
        @NotNull(message = "Password cannot be null")
        @NotEmpty(message = "Password cannot be empty")
        @NotBlank(message = "Password cannot be blank")
        String password,
        Boolean isEnabled,
        Boolean isCredentialsExpired,
        Boolean isAccountLocked,
        Boolean isAccountExpired,
        @Valid
        List<RoleDto> roles,
        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        Date postedTime,
        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        Date modifiedTime
) {
}
