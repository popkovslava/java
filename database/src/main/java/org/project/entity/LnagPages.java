package org.project.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "lnag_page", schema = "business_contact")
public class LnagPages extends Base<Long> {

    @ManyToOne
    @JoinColumn(name = "lang_id")
    private Lang lang;

    @ManyToOne
    @JoinColumn(name = "page_id")
    private Pages pages;
}
