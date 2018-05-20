package org.project.entity;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@DiscriminatorValue("CART_TRADEMARK")
public class CartTrademark extends Cart {
    @Column(name = "testOne")
    private String testOne;

    public CartTrademark(String name,String testOne) {
        super(name);
        this.testOne=testOne;
    }

}
