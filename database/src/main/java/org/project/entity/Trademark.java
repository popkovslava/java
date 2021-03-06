package org.project.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@ToString(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "trademark", schema = "business_contact")
public class Trademark extends Base<Long> {

    @Column(name = "title")
    private String title;

    @Column(name = "article", unique = true, length = 50)
    private String article;

    @Column(name = "description")
    private String description;

    public Trademark(String title) {
        this.title = title;
    }

    @ManyToMany(mappedBy = "trademark", cascade = {CascadeType.ALL})
    private Set<Users> users = new HashSet<>();

}



