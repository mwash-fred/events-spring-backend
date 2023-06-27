package apps.myuzinc.events.dto;

import lombok.Builder;

@Builder
public record ResponseTemplate<T>(
        String message,
        int httpStatus,
        T data,
        String errors
) {
}
