package org.zerock.sb2.order.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_order")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "details")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ono;

    private String customer;

    @OneToMany(mappedBy = "order")
    private List<OrderDetailEntity> details = new ArrayList<>();

}
