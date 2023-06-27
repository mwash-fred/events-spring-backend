package apps.myuzinc.events.resources;

import apps.myuzinc.events.dto.ResponseTemplate;
import apps.myuzinc.events.utils.integrations.billing.MpesaPayments;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("api/v1/billing")
@RequiredArgsConstructor
public class PaymentsResource {
    private final MpesaPayments mpesaPayments;

    @PostMapping(value = "mpesa", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE, params = {"action"})
    public ResponseEntity<ResponseTemplate<?>> mpesaPayment(){
        return ResponseEntity.status(HttpStatus.OK).body(
                ResponseTemplate.builder()
                        .message("Payment Processed Successfully")
                        .data(mpesaPayments)
                        .httpStatus(HttpStatus.OK.value())
                        .build()
        );
    }

}
