package apps.myuzinc.events.dao.Roles;

import apps.myuzinc.events.utils.sql.CrudOperations;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService implements CrudOperations<Role> {
    private final RoleRepository roleRepository;

    @Override
    public Role save(Role record) {
        return null;
    }

    @Override
    public Role read(String uid) {
        return null;
    }

    @Override
    public Role update(Role record) {
        return null;
    }

    @Override
    public Role delete(Role uid) {
        return null;
    }

    @Override
    public List<Role> getAll() {
        return null;
    }
}
