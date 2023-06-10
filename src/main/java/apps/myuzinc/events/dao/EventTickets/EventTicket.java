package apps.myuzinc.events.dao.EventTickets;

import apps.myuzinc.events.dao.Events.Event;
import apps.myuzinc.events.dao.TicketType.TicketType;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Getter @Setter @Builder
@AllArgsConstructor @NoArgsConstructor
public class EventTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, updatable = false, unique = false, length = 36)
    private String uid;
    @Column(nullable = false)
    private Integer availableTickets;
    private Integer soldTickets;
    private Integer remainingTickets;
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date postedTime;
    @Column(nullable = false)
    private Date modifiedTime;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Event event;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private TicketType ticketType;

    @PrePersist()
    private void prePersist(){
        this.uid = UUID.randomUUID().toString();
        this.postedTime = new Date();
        this.modifiedTime = new Date();
    }

    @PreUpdate
    private void preUpdate(){
        this.modifiedTime = new Date();
    }
}
