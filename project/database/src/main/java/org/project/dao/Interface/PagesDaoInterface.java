package org.project.dao.Interface;
import java.util.List;
import org.project.entity.Pages;



public interface PagesDaoInterface  extends BaseDaoInterface<Long, Pages>  {

    Long save(Pages object);

    List<Pages> findAll();

    void update(Pages object);

    void delete(Pages object);

    Pages findById(Long s);
}
