package org.zerock.sb2.product.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.zerock.sb2.product.dto.ProductReadDTO;
import org.zerock.sb2.product.entities.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    @EntityGraph(attributePaths = "images", type = EntityGraph.EntityGraphType.FETCH)
    @Query("select p from ProductEntity p where p.pno = :pno ")
    ProductEntity selectOne(@Param("pno") Long pno);

    //이거는 못함
//    @EntityGraph(attributePaths = "images", type = EntityGraph.EntityGraphType.FETCH)
//    @Query("select new org.zerock.sb2.product.dto.ProductReadDTO(p)  from ProductEntity p where p.pno = :pno ")
//    ProductReadDTO selectOneDTO(@Param("pno") Long pno);

}
