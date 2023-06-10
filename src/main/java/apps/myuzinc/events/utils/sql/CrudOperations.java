package apps.myuzinc.events.utils.sql;

import java.util.List;

public interface CrudOperations<T> {
    T save(T record);
    T read(String uid);
    T update(T record);
    T delete(T uid);
    List<T> getAll();

}
