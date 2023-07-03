package apps.myuzinc.events.utils.integrations.billing;

import apps.myuzinc.events.dto.MpesaPaymentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class MpesaPayments {
    private final RestTemplate restTemplate;

    public void requestMpesaPayment(MpesaPaymentRequest paymentRequest){

    }

}
