package apps.myuzinc.events.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

@Builder @JsonInclude(JsonInclude.Include.NON_NULL)
public record ResponseTemplate<T>(
        String message,
        int httpStatus,
        T data,
        String errors
) {
}
