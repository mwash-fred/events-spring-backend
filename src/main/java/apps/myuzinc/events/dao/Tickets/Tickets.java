package apps.myuzinc.events.dao.Tickets;

import apps.myuzinc.events.dao.TicketType.TicketType;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Getter @Setter @Builder
@AllArgsConstructor @NoArgsConstructor
public class Tickets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 36, nullable = false, updatable = false, unique = true)
    private String uid;
    @Column(length = 10)
    private String ticketNo;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date validDate;
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date postedTime;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedTime;
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
