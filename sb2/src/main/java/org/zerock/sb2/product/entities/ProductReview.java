package org.zerock.sb2.product.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Entity
@Table(name = "tbl_product_review")
@Getter
@ToString
@Builder
@AllArgsConstructor
public class ProductReview {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long rno;
    private String reivewer;
    private  int score;
    private  String comment;
    @ManyToOne(fetch = FetchType.LAZY)
    private ProductEntity product;
}
