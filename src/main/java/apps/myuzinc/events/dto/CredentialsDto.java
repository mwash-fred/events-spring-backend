package apps.myuzinc.events.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record CredentialsDto(
        String jwt,
        String email,
        List<String> authorities
) {
}
