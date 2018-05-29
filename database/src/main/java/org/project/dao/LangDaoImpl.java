package org.project.dao;

import org.project.dao.Interface.LangDao;
import org.project.entity.Lang;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LangDaoImpl extends BaseDao<Long, Lang> implements LangDao {

       private static final LangDaoImpl INSTANCE = new LangDaoImpl();

       public static LangDaoImpl getInstance() {
           return INSTANCE;
       }
}
