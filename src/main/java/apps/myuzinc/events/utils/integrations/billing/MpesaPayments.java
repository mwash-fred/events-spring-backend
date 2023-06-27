package apps.myuzinc.events.utils.integrations.billing;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class MpesaPayments {
    private final RestTemplate restTemplate;


}
