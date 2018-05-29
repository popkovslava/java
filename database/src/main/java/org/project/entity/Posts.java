package org.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "posts", schema = "business_contact")
public class Posts extends Base<Long> {

    @Column(name = "title")
    private String title;

    @Column(name = "text")
    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_category_id")
    private PostsCategory postCtegory;
}
