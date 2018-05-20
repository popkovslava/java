package org.project.dao.Interface;

import java.util.List;
import org.project.entity.Menu;

public interface MenuDaoInterface extends BaseDaoInterface<Long, Menu> {

    Long save(Menu object);

    List<Menu> findAll();

    void update(Menu object);

    void delete(Menu object);

    Menu findById(Long s);
}


