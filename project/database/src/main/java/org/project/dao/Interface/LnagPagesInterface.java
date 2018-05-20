package org.project.dao.Interface;
import java.util.List;
import org.project.entity.LnagPages;

public interface LnagPagesInterface extends BaseDaoInterface<Long, LnagPages>  {

    Long save(LnagPages object);

    List<LnagPages> findAll();

    void update(LnagPages object);

    void delete( LnagPages object);

    LnagPages findById(Long s);
}
