package org.project.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Setter
@Getter
@ToString
@NoArgsConstructor
@Entity

@Table(name = "role", schema = "business_contact")
public class RoleEntity extends BaseEntity<Long> {
    @Column(name = "role")
    private String role;

    @ManyToMany(mappedBy = "RoleEntitySet")
    private Set<UsersEntity> usersEntities = new HashSet<>();
}
