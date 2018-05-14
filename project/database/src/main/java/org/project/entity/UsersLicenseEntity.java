package org.project.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@AllArgsConstructor
@Setter
@Getter
@ToString
@NoArgsConstructor
@Entity

@Table(name = "user_license", schema = "business_contact")
public class UsersLicenseEntity extends BaseEntity<Long> {
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UsersEntity usersEntity;

    @ManyToOne
    @JoinColumn(name = "license_id")
    private LicenseEntity licenseEntity;
}
