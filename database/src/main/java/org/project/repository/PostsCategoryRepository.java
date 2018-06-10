package org.project.repository;

import org.project.entity.PostsCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsCategoryRepository extends CrudRepository<PostsCategory, Long> {
}