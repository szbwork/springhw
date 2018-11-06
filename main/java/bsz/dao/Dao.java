package bsz.dao;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * Created by szb on 10/23/18.
 */
public interface Dao<T> {

    public T getById(@Nonnull Long id);

    List<T> getAll();

    void save(T t);

    void update(T t, String[] params);

    void delete(T t);
}