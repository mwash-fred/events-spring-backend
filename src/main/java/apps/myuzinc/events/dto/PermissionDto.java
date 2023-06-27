package apps.myuzinc.events.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PermissionDto(
        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        String uid,
        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        String name
) {
}
