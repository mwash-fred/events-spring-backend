package apps.myuzinc.events.dao.TicketType;

import apps.myuzinc.events.utils.sql.CrudOperations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketTypeService implements CrudOperations<TicketType> {
    @Override
    public TicketType save(TicketType record) {
        return null;
    }

    @Override
    public TicketType read(String uid) {
        return null;
    }

    @Override
    public TicketType update(TicketType record) {
        return null;
    }

    @Override
    public TicketType delete(TicketType uid) {
        return null;
    }

    @Override
    public List<TicketType> getAll() {
        return null;
    }
}
