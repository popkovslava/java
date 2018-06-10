package org.project.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "users", schema = "business_contact")
public class Users extends Base<Long> {

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @OneToOne(mappedBy = "user", cascade = {CascadeType.ALL})
    private UserData userData;

    public Users(String username, String password)
    {
        this.username = username;
        this.password=password;
    }

    @ManyToMany
    @JoinTable(name = "user_role", schema = "business_contact",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Set<Role> RoleSet = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "user_license", schema = "business_contact",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "license_id")})
    private Set<License> license = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "user_trademark", schema = "business_contact",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "trademark_id")})
    private Set<Trademark> trademark = new HashSet<>();
}
