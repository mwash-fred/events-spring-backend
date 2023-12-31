package apps.myuzinc.events.dao.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    boolean existsByEmail(String email);
    boolean existsByMobileNo(String mobileNo);
    Optional<Users> findByEmail(String email);
}
