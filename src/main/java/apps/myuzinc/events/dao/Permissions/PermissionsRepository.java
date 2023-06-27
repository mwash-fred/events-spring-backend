package apps.myuzinc.events.dao.Permissions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PermissionsRepository extends JpaRepository<Permissions, Long> {
    Optional<Permissions> findByName(String name);
    Permissions findBySn(Long sn);
    boolean existsByName(apps.myuzinc.events.utils.enums.Permissions name);
}
