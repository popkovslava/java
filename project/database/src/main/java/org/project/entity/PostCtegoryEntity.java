package org.project.entity;

import lombok.AllArgsConstructor;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"posts"})
@Setter
@Getter
@Entity

@Table(name = "post_category", schema = "business_contact")
public class PostCtegoryEntity extends BaseEntity<Long> {

    @Column(name = "title")
    private String title;

    @Column(name = "text")
    private String text;

    @OneToMany(mappedBy = "postCtegoryEntity", cascade = {CascadeType.ALL})
    private Set<PostsEntity> posts;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "page_id")
    private PagesEntity pagesEntity;

}
