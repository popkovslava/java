package org.project.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "pages", schema = "business_contact")
public class Pages extends Base<Long> {

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "slug")
    private String slug;

    public Pages(String title) {
        this.title = title;
    }

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;

    @OneToMany(mappedBy = "pages", cascade = {CascadeType.ALL})
    private Set<PostsCategory> postCtegory;

    @ManyToMany(mappedBy = "langSet", cascade = {CascadeType.ALL})
    private Set<Lang> lang = new HashSet<>();

}
