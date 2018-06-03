package org.project.dao.Interface;

import java.util.List;
import org.project.entity.Pages;

public interface PagesDao extends BaseDao<Long, Pages> {

    List<Pages> getPageBySlug(String slug);

    List<Pages> getPage();
}
