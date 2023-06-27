package apps.myuzinc.events.dao.Roles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(String name);
    Optional<Role> findByUid(String uid);
    boolean existsByName(String name);
}
