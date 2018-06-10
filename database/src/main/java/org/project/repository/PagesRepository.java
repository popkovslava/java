package org.project.repository;

import org.project.entity.Pages;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagesRepository extends CrudRepository<Pages, Long> {
}

