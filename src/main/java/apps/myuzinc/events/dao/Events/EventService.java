package apps.myuzinc.events.dao.Events;

import apps.myuzinc.events.utils.sql.CrudOperations;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService implements CrudOperations<Event> {
    private final EventRepository eventRepository;

    @Override
    public Event save(Event record) {
        return null;
    }

    @Override
    public Event read(String uid) {
        return null;
    }

    @Override
    public Event update(Event record) {
        return null;
    }

    @Override
    public Event delete(Event uid) {
        return null;
    }

    @Override
    public List<Event> getAll() {
        return null;
    }
}
