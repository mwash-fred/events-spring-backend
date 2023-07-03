package apps.myuzinc.events.dto;

public record PaymentsApiPaymentRequest(
        String phoneNo,
        int amount,
        int paybill,
        String paymentReference,
        String callbackUrl
) {
}
