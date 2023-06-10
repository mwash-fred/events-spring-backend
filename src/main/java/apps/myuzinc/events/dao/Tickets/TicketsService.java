package apps.myuzinc.events.dao.Tickets;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketsService {
    private final TicketsRepository ticketsRepository;
}
