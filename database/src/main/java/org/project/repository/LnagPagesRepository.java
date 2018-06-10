package org.project.repository;

import org.project.entity.LnagPages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LnagPagesRepository extends CrudRepository<LnagPages, Long> {
}