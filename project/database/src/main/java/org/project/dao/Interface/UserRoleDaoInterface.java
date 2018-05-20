package org.project.dao.Interface;

import java.util.List;
import org.project.entity.UserRole;

public interface UserRoleDaoInterface extends BaseDaoInterface<Long, UserRole> {

    Long save(UserRole object);

    List<UserRole> findAll();

    void update(UserRole object);

    void delete(UserRole object);

    UserRole findById(Long s);

}
