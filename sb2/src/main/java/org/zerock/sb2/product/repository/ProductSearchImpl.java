package org.zerock.sb2.product.repository;


import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.JPQLQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.zerock.sb2.board.dto.PageRequestDTO;
import org.zerock.sb2.board.dto.PageResponseDTO;
import org.zerock.sb2.product.dto.ProductListDTO;
import org.zerock.sb2.product.entities.ProductEntity;
import org.zerock.sb2.product.entities.QProductEntity;
import org.zerock.sb2.product.entities.QProductImage;

@Log4j2
@RequiredArgsConstructor
public class ProductSearchImpl implements ProductSearch {

    private final JPQLQueryFactory queryFactory;

    @Override
    public PageResponseDTO<ProductListDTO> listQuerydsl(PageRequestDTO pageRequestDTO) {

        QProductEntity qProductEntity = QProductEntity.productEntity;
        QProductImage qProductImage = QProductImage.productImage;

        JPQLQuery<ProductEntity> query = queryFactory.selectFrom(qProductEntity);

        //join 하는 방법이 엔티티와 다르므로 주의
        query.leftJoin(qProductEntity.images, qProductImage);

        query.where(qProductImage.ord.eq(0));

        //검색 조건
        query.limit(pageRequestDTO.getSize());
        query.offset(pageRequestDTO.getOffset());
        query.orderBy(new OrderSpecifier<>(Order.DESC, qProductEntity.pno));

        query.select(Projections.bean(
                ProductListDTO.class,
                qProductEntity.pno,
                qProductEntity.pname,
                qProductEntity.price,
                qProductImage.imgName.as("imgName")
        ));
        return null;
    }
}
