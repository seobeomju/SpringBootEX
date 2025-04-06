package org.zerock.sb2.product.entities;


import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.ToString;

@Embeddable
@Getter
@ToString
public class ProductImage {

    private String imgname;

    private int ord;
}
