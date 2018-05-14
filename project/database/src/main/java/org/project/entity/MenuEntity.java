package org.project.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@Setter
@Getter
@ToString
@NoArgsConstructor
@Entity

@Table(name = "menu", schema = "business_contact")
public class MenuEntity extends BaseEntity<Long> {
    @Column(name = "title", nullable = false)
    private String title;

    @OneToMany(mappedBy = "menu", cascade = {CascadeType.ALL})
    private Set<PagesEntity> page;

}
