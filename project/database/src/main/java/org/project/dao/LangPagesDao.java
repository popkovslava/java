package org.project.dao;

import org.project.dao.Interface.LnagPagesInterface;
import org.project.entity.LnagPages;

public class LangPagesDao extends BaseDao<Long,LnagPages> implements LnagPagesInterface {
    private static final LangPagesDao INSTANCE = new  LangPagesDao();
    public static LangPagesDao getInstance() {
        return INSTANCE;
    }
}
