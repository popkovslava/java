package org.project.dao.Interface;
import java.util.List;
import org.project.entity.Posts;
import org.project.entity.Role;

public interface RoleDaoInterface extends BaseDaoInterface<Long, Role> {

    Long save(Role object);

    List<Role> findAll();

    void update(Role object);

    void delete(Role object);

     Role findById(Long s);
}



