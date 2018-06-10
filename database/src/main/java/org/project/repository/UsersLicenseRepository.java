package org.project.repository;

import org.project.entity.UsersLicense;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersLicenseRepository extends CrudRepository<UsersLicense, Long> {
}