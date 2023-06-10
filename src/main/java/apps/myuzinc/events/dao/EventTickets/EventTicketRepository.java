package apps.myuzinc.events.dao.EventTickets;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventTicketRepository extends JpaRepository<EventTicket, Long> {
}
