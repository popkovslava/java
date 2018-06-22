package org.project.entity;

//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Table;
//
//
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//@Table(name = "role", schema="business_contact")
//public class Role extends Base<Long> {
//    @Column(name = "name")
//    private String name;
//}


public enum  Role {

    ADMIN,
    USER
}