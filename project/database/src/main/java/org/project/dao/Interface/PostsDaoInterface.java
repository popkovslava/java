package org.project.dao.Interface;

import java.util.List;
import org.project.entity.Posts;

interface PostsDaoInterface extends BaseDaoInterface<Long, Posts> {

    Long save(Posts object);

    List<Posts> findAll();

    void update(Posts object);

    void delete(Posts object);

    Posts findById(Long s);
}