package org.project.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@AllArgsConstructor
@Setter
@Getter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "user_trademark", schema = "business_contact")
public class UserTrademarkEntity extends BaseEntity<Long> {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UsersEntity usersEntity;

    @ManyToOne
    @JoinColumn(name = "trademark_id")
    private TrademarkEntity trademarkEntity;
}
