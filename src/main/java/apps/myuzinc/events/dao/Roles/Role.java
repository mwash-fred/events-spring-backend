package apps.myuzinc.events.dao.Roles;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Getter @Setter @Builder
@AllArgsConstructor @NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 36, nullable = false, updatable = false, unique = false)
    private String uid;
    @Column(length = 20)
    private String roleName;
    @Column(nullable = false,updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date postedTime;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedTime;

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
