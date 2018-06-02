package org.project.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
@Table(name = "menu", schema = "business_contact")
public class Menu extends Base<Long> {

    @Column(name = "title", nullable = false)
    private String title;

    public Menu(String title) {
        this.title = title;
    }

    @OneToMany(mappedBy = "menu", cascade = {CascadeType.ALL})
    private Set<Pages> page;
}
