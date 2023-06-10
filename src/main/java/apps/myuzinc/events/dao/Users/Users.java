package apps.myuzinc.events.dao.Users;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Getter @Setter @Builder
@AllArgsConstructor @NoArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 36, nullable = false, unique = true, updatable = false)
    private String uid;
    @Column(length = 100, nullable = false)
    private String name;
    @Column(length = 150, nullable = false)
    private String email;
    @Column(length = 12)
    private String mobileNo;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
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
