package org.progect.service;

import java.util.List;
import org.project.dao.MenuDaoImpl;
import org.project.entity.Menu;

public class MenuService {
    private static final MenuService INSTANCE = new MenuService();

    public List<Menu> getMenu() {
        return MenuDaoImpl.getInstance().getMenu();
    }

    public static MenuService getInstance() {
        return INSTANCE;
    }
}