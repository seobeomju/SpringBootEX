package org.zerock.sb2.order.entities;

import jakarta.persistence.*;
import lombok.*;
import org.zerock.sb2.product.entities.ProductEntity;

@Entity
@Table(name = "tbl_order_detail")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"product, order"})
public class OrderDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long odno;

    @ManyToOne
    private ProductEntity product;

    @ManyToOne
    private OrderEntity order;

}