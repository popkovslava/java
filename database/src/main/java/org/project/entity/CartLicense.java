package org.project.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@Entity
@DiscriminatorValue("CART_LICENCE")
public class CartLicense extends Cart {

    @Column(name = "testToo")
    private String testToo;

    public CartLicense(String name, String testToo) {
        super(name);
        this.testToo = testToo;
    }
}
