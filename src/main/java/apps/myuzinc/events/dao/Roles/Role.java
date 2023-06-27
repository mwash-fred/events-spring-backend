package apps.myuzinc.events.dao.Roles;

import apps.myuzinc.events.dao.Permissions.Permissions;
import apps.myuzinc.events.dao.Users.Users;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "roles")
@Getter @Setter @Builder
@AllArgsConstructor @NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sn;
    @Column(length = 36, updatable = false, unique = true)
    private String uid;
    @Column(length = 10, nullable = false, unique = true)
    private String name;
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date postedTime;
    @Column(length = 20, nullable = false, updatable = false)
    private String postedBy;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date  modifiedTime;
    @Column(length = 20, nullable = false)
    private String modifiedBy;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Users> users;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "role_privileges",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "privilege_id")
    )
    private List<Permissions> privileges;

    @PrePersist
    private void prePersist() {
        this.uid = UUID.randomUUID().toString();
        this.postedTime = new Date();
        this.postedBy = SecurityContextHolder.getContext().getAuthentication().getName();
        this.modifiedBy = SecurityContextHolder.getContext().getAuthentication().getName();
        this.modifiedTime = new Date();
    }

    @PreUpdate
    private void preUpdate(){
        this.modifiedBy = SecurityContextHolder.getContext().getAuthentication().getName();
        this.modifiedTime = new Date();
    }
}