package org.project.dao.Interface;
import java.util.List;
import org.project.entity.Users;

public interface UsersDaoInterface extends BaseDaoInterface<Long, Users> {

    Long save(Users object);

    List<Users> findAll();

    void update(Users object);

    void delete(Users object);

    Users findById(Long s);
}
