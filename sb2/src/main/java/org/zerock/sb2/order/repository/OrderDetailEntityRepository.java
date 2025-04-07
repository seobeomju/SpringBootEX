package org.zerock.sb2.order.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.zerock.sb2.order.entities.OrderDetailEntity;

import java.util.List;

public interface OrderDetailEntityRepository extends JpaRepository<OrderDetailEntity, Long> {

    @EntityGraph(attributePaths = "product", type = EntityGraph.EntityGraphType.FETCH)
    @Query("SELECT od FROM OrderDetailEntity od WHERE od.order.ono IN (:onos) order by od.order.ono desc")
    List<OrderDetailEntity> listOfOnos(@Param("onos") List<Long> onos);
}