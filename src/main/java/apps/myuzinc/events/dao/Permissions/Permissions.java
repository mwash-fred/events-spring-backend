package apps.myuzinc.events.dao.Permissions;

import apps.myuzinc.events.dao.Roles.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "privileges")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Permissions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sn;
    @Column(length = 36, nullable = false, updatable = false, unique = true)
    private String uid;

    @Column(length = 40, nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private apps.myuzinc.events.utils.enums.Permissions name;
    @ManyToMany(mappedBy = "privileges")
    private List<Role> roles;

    @PrePersist
    private void prePersist() {
        this.uid = UUID.randomUUID().toString();
    }
}
