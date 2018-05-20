package org.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Setter
@Getter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "role", schema = "business_contact")
public class Role extends Base<Long> {
    @Column(name = "role")
    private String role;

    @ManyToMany(mappedBy = "RoleSet")
    private Set<Users> users = new HashSet<>();
}
