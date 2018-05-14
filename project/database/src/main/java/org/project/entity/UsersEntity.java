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
@Table(name = "users", schema = "business_contact")
public class UsersEntity extends BaseEntity<Long> {
    @Column(name = "name")
    private String name;

    @Column(name = "address")
    @Enumerated(EnumType.STRING)
    private UserAddress userAdress;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role", schema = "business_contact",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Set<RoleEntity> RoleEntitySet = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_license", schema = "business_contact",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "license_id")})
    private Set<LicenseEntity> licenseEntities = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_trademark", schema = "business_contact",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "trademark_id")})
    private Set<TrademarkEntity> trademarkEntities = new HashSet<>();

}
