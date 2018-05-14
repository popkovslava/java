package org.project.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@AllArgsConstructor
@Setter
@Getter
@ToString
@NoArgsConstructor
@Entity

@Table(name = "license", schema = "business_contact")
public class LicenseEntity extends BaseEntity<Long> {
    @Column(name = "title")
    private String title;

    @Column(name = "article", unique = true, length = 50)
    private String article;

    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "licenseEntities")
    private Set<UsersEntity> usersEntities = new HashSet<>();

}
