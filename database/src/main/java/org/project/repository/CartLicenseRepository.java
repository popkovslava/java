package org.project.repository;

import org.project.entity.CartLicense;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartLicenseRepository extends CrudRepository<CartLicense, Long> {
}
