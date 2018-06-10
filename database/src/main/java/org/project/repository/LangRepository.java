package org.project.repository;

import org.project.entity.Lang;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LangRepository extends CrudRepository<Lang, Long> {
}
