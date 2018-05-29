package org.project.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
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
