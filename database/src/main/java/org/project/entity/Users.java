package org.project.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
//import javax.validation.constraints.Max;
//import javax.validation.constraints.Min;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users", schema = "business_contact")
public class Users extends Base<Long>  {

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;


    @OneToOne(mappedBy = "users", cascade = {CascadeType.ALL})
    private UserData userData;


    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

//    @ManyToMany
//    @JoinTable(name = "user_role", schema = "business_contact",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id"))
//    private Set<Role> roles = new HashSet<>();

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
