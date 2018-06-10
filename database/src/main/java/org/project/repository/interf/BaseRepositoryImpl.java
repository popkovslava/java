package org.project.repository.interf;

import java.io.Serializable;
import java.util.Optional;
import org.project.entity.Base;
import org.springframework.stereotype.Repository;

@Repository
public class BaseRepositoryImpl<PK extends Serializable, T extends Base<PK>> implements BaseRepository<PK, T> {
    @Override
    public <S extends PK> S save(S s) {
        return save(s);
    }

    @Override
    public <S extends PK> Iterable<S> saveAll(Iterable<S> iterable) {
        return saveAll(iterable);
    }

    @Override
    public Optional<PK> findById(T t) {
        return findById(t);
    }

    @Override
    public boolean existsById(T t) {
        return false;
    }

    @Override
    public Iterable<PK> findAll() {
        return findAll();
    }

    @Override
    public Iterable<PK> findAllById(Iterable<T> iterable) {
        return findAllById(iterable);
    }

    @Override
    public long count() {
        return count();
    }

    @Override
    public void deleteById(T t) {
        deleteById(t);
    }

    @Override
    public void delete(PK pk) {
        delete(pk);
    }

    @Override
    public void deleteAll(Iterable<? extends PK> iterable) {
        deleteAll(iterable);
    }

    @Override
    public void deleteAll() {
        deleteAll();
    }
}
