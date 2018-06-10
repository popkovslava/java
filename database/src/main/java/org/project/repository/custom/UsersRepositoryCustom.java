package org.project.repository.custom;
import java.util.List;
import org.project.entity.Users;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepositoryCustom {
    List<Users> findByName(String username);
}
