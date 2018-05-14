package org.project.entity;

import lombok.*;

import javax.persistence.*;


@AllArgsConstructor
@Setter
@Getter
@ToString
@NoArgsConstructor
@Entity

@Table(name = "lnag_page", schema = "business_contact")
public class LnagPagesEntity extends BaseEntity<Long> {

    @ManyToOne
    @JoinColumn(name = "lang_id")
    private LangEntity langEntity;

    @ManyToOne
    @JoinColumn(name = "page_id")
    private PagesEntity pagesEntity;

}
