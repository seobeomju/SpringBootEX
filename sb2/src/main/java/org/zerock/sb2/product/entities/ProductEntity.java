package org.zerock.sb2.product.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.ArrayList;

@Entity
@Table(name = "tbl_product")
@EntityListeners(value = AuditingEntityListener.class)
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pno;

    private String pname;

    private int price;

    @ElementCollection(fetch =  FetchType.LAZY)
    @CollectionTable(
            name = "tbl_product_img",
            joinColumns = @JoinColumn(name="product_pno") )
    private java.util.List<ProductImage> images = new ArrayList<>();

}