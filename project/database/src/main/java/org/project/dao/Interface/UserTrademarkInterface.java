package org.project.dao.Interface;

import java.util.List;
import org.project.entity.UserTrademark;
import org.project.entity.Users;
import org.project.entity.UsersLicense;

public interface UserTrademarkInterface extends BaseDaoInterface<Long, UserTrademark> {

    Long save(UserTrademark object);

    List<UserTrademark> findAll();

    void update(UserTrademark object);

    void delete(UserTrademark object);

    UserTrademark findById(Long s);
}
