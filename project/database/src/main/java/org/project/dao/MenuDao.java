package org.project.dao;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.project.dao.Interface.MenuDaoInterface;

import org.project.entity.Menu;
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public  class MenuDao extends BaseDao<Long,Menu> implements MenuDaoInterface {
    private static final MenuDao INSTANCE = new MenuDao();
    public static MenuDao getInstance() {
        return INSTANCE;
    }
}
