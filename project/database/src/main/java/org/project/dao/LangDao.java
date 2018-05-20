package org.project.dao;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.project.dao.Interface.LangInterface;
import org.project.entity.Lang;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LangDao extends BaseDao<Long,Lang> implements LangInterface {
       private static final LangDao INSTANCE = new LangDao();

       public static LangDao getInstance() {
            return INSTANCE;
        }
}
