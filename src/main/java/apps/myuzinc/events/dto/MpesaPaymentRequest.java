package apps.myuzinc.events.dto;

import jakarta.validation.constraints.NotNull;

public record MpesaPaymentRequest(
        @NotNull(message = "Mobile No cannot be null")
        String mobileNo,
        @NotNull(message = "Amount cannot be null")
        Double amount
) {
}
