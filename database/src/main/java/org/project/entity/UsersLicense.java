package org.project.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@AllArgsConstructor
@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@Entity

@Table(name = "user_license", schema = "business_contact")
public class UsersLicense extends Base<Long> {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;


    @ManyToOne
    @JoinColumn(name = "license_id")
    private License license;
}
