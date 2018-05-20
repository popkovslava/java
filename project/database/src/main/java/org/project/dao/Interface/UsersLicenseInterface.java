package org.project.dao.Interface;

import java.util.List;
import org.project.entity.Users;
import org.project.entity.UsersLicense;

public interface UsersLicenseInterface extends BaseDaoInterface<Long, UsersLicense> {

    Long save(Users object);

    List<UsersLicense> findAll();

    void update(UsersLicense object);

    void delete(UsersLicense object);

    UsersLicense findById(Long s);
}
