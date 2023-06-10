package apps.myuzinc.events.dao.Events;

import apps.myuzinc.events.dao.EventTickets.EventTicket;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Getter @Setter @Builder
@AllArgsConstructor @NoArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 36, nullable = false, updatable = false, unique = true)
    private String uid;
    @Column(length = 100, nullable = false)
    private String eventName;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Column(length = 200, nullable = false)
    private String venue;
    @Column(nullable = false)
    private Integer noOfAttendees;
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date postedTime;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedTime;
    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<EventTicket> eventTicketList;

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
