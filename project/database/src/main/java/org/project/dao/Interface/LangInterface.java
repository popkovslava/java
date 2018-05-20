package org.project.dao.Interface;
import java.util.List;
import org.project.entity.Lang;

public interface LangInterface extends BaseDaoInterface<Long, Lang>  {

    Long save(Lang object);

    List<Lang> findAll();

    void update(Lang object);

    void delete(Lang object);

    Lang findById(Long s);
}
