package apps.myuzinc.events.dao.TicketType;

import apps.myuzinc.events.dao.EventTickets.EventTicket;
import apps.myuzinc.events.dao.Tickets.Tickets;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Getter @Setter @Builder
@AllArgsConstructor @NoArgsConstructor
public class TicketType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, updatable = false, unique = true)
    private String uid;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private apps.myuzinc.events.utils.enums.TicketType ticketType;
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date postedTime;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedTime;
    @OneToMany(mappedBy = "ticketType", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Tickets> ticketsList;
    @OneToMany(mappedBy = "ticketType", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<EventTicket> ticketTypeList;

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
