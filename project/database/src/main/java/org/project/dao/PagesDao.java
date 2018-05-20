package org.project.dao;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.project.dao.Interface.PagesDaoInterface;
import org.project.entity.Pages;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PagesDao extends BaseDao<Long, Pages> implements PagesDaoInterface {
    private static final PagesDao INSTANCE = new PagesDao();
    public static PagesDao getInstance() {
        return INSTANCE;
    }
}
