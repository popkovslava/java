package org.project.repository;

import org.project.entity.Menu;
import org.project.repository.custom.MenuRepositoryCustom;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface MenuRepository extends CrudRepository<Menu, Long>, MenuRepositoryCustom {
}


