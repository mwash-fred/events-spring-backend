package apps.myuzinc.events.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record LoginDto(
        @NotNull(message = "Email Cannot be null")
        @NotEmpty(message = "Email Cannot be empty")
        @NotBlank(message = "Email Cannot be blank")
        String email,
        @NotNull(message = "Password Cannot be null")
        @NotEmpty(message = "Password Cannot be empty")
        @NotBlank(message = "Password Cannot be blank")
        String password
) {
}
