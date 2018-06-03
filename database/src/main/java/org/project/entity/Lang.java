package org.project.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
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
@Table(name = "lang", schema = "business_contact")
public class Lang extends Base<Long> {

    @Column(name = "ln_title")
    private String lnTitle;

    @Column(name = "ln", unique = true)
    private String Ln;


    @ManyToMany
    @JoinTable(name = "lnag_page", schema = "business_contact",
            joinColumns = {@JoinColumn(name = "lang_id")},
            inverseJoinColumns = {@JoinColumn(name = "page_id")})
    private Set<Lang> langSet = new HashSet<>();


}
