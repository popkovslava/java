package org.project.dao;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.project.dao.Interface.LnagPagesDao;
import org.project.entity.LnagPages;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LangPagesDaoImpl extends BaseDao<Long, LnagPages> implements LnagPagesDao {

    private static final LangPagesDaoImpl INSTANCE = new LangPagesDaoImpl();

    public static LangPagesDaoImpl getInstance() {
        return INSTANCE;
    }
}
