package apps.myuzinc.events.dao.EventTickets;

import apps.myuzinc.events.utils.sql.CrudOperations;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventTicketService implements CrudOperations<EventTicket> {
    private final EventTicketRepository eventTypeRepository;

    @Override
    public EventTicket save(EventTicket record) {
        return null;
    }

    @Override
    public EventTicket read(String uid) {
        return null;
    }

    @Override
    public EventTicket update(EventTicket record) {
        return null;
    }

    @Override
    public EventTicket delete(EventTicket uid) {
        return null;
    }

    @Override
    public List<EventTicket> getAll() {
        return null;
    }
}
