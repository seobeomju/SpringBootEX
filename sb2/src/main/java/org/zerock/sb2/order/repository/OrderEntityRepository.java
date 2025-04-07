package org.zerock.sb2.order.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.zerock.sb2.order.entities.OrderEntity;

public interface OrderEntityRepository extends JpaRepository<OrderEntity, Long> {

    @EntityGraph(attributePaths = {"details", "details.product"}, type = EntityGraph.EntityGraphType.FETCH)
    @Query("SELECT oe FROM OrderEntity oe WHERE oe.ono = :ono")
    OrderEntity selectOne( @Param("ono") Long ono);
}