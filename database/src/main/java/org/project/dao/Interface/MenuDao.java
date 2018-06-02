package org.project.dao.Interface;

import java.util.List;
import org.project.entity.Menu;

public interface MenuDao extends BaseDao<Long, Menu> {

    List<Menu> getMenu();

}


