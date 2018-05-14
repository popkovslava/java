package org.project.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "posts", schema = "business_contact")
public class PostsEntity extends BaseEntity<Long> {

    @Column(name = "title")
    private String title;

    @Column(name = "text")
    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_category_id")
    private PostCtegoryEntity postCtegoryEntity;
}
