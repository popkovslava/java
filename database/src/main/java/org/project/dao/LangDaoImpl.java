package org.project.dao;

import org.project.dao.Interface.LangDao;
import org.project.entity.Lang;
import org.springframework.stereotype.Repository;

@Repository
public class LangDaoImpl extends BaseDaoImpl<Long, Lang> implements LangDao {
}
