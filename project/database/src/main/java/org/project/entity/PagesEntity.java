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

@Table(name = "pages", schema = "business_contact")
public class PagesEntity extends BaseEntity<Long> {

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id")
    private MenuEntity menu;

    @OneToMany(mappedBy = "pagesEntity", cascade = {CascadeType.ALL})
    private Set<PostCtegoryEntity> postCtegoryEntities;

    @ManyToMany(mappedBy = "langEntitySet")
    private Set<LangEntity> langEntities = new HashSet<>();

}
