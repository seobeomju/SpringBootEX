package org.zerock.sb2.order;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.sb2.order.entities.OrderDetailEntity;
import org.zerock.sb2.order.entities.OrderEntity;
import org.zerock.sb2.order.repository.OrderEntityRepository;
import org.zerock.sb2.product.entities.ProductEntity;

@SpringBootTest
@Log4j2
public class OrderRepoTests {

    @Autowired(required = false)
    private OrderEntityRepository repo;

    @Test
    public void testInsert(){

        ProductEntity p1 = ProductEntity.builder().pno(1L).build();
        ProductEntity p2 = ProductEntity.builder().pno(2L).build();
        ProductEntity p3 = ProductEntity.builder().pno(3L).build();

        OrderEntity order = OrderEntity.builder()
                .customer("user00")
                .build();

        OrderDetailEntity od1 = OrderDetailEntity.builder()
                .product(p1).quantity(1).build();

        OrderDetailEntity od2 = OrderDetailEntity.builder()
                .product(p2).quantity(2).build();

        OrderDetailEntity od3 = OrderDetailEntity.builder()
                .product(p3).quantity(3).build();

        order.addDetail(od1);
        order.addDetail(od2);
        order.addDetail(od3);

        repo.save(order);

    }

    @Transactional
    @Test
    public void testSelectOne(){

        OrderEntity order = repo.selectOne(1L);

        log.info(order);
        log.info(order.getDetails());

    }



}