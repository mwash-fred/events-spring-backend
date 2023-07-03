package apps.myuzinc.events.dao.Users;

import apps.myuzinc.events.dao.Roles.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
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
    private Boolean isEnabled;
    @Column(nullable = false)
    private Boolean isCredentialsExpired;
    @Column(nullable = false)
    private Boolean isAccountLocked;
    @Column(nullable = false)
    private Boolean isAccountExpired;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date postedTime;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedTime;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

    @PrePersist()
    private void prePersist(){
        this.uid = UUID.randomUUID().toString();
        this.postedTime = new Date();
        this.modifiedTime = new Date();
        this.isAccountExpired =false;
        this.isAccountLocked = false;
        this.isCredentialsExpired = false;
        this.isEnabled = true;

    }

    @PreUpdate
    private void preUpdate(){
        this.modifiedTime = new Date();
    }

}
