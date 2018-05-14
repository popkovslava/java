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

@Table(name = "lang", schema = "business_contact")
public class LangEntity extends BaseEntity<Long> {

    @Column(name = "ln_title")
    private String ln_title;

    @Column(name = "ln", unique = true, nullable = false)
    private String ln;

    @ManyToMany
    @JoinTable(name = "lnag_page", schema = "business_contact",
            joinColumns = {@JoinColumn(name = "lang_id")},
            inverseJoinColumns = {@JoinColumn(name = "page_id")})
    private Set<LangEntity> langEntitySet = new HashSet<>();

}
