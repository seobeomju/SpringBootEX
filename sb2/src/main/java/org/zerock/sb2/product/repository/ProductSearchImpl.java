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
import org.zerock.sb2.product.dto.ProductListAllDTO;
import org.zerock.sb2.product.dto.ProductListDTO;
import org.zerock.sb2.product.entities.ProductEntity;
import org.zerock.sb2.product.entities.QProductEntity;
import org.zerock.sb2.product.entities.QProductImage;
import org.zerock.sb2.product.entities.QProductReview;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
public class ProductSearchImpl implements ProductSearch {

    private final JPQLQueryFactory queryFactory;

    @Override
    public PageResponseDTO<ProductListDTO> listQuerydsl(PageRequestDTO pageRequestDTO) {

        QProductEntity qProductEntity = QProductEntity.productEntity;
        QProductImage qProductImage = QProductImage.productImage;
        QProductReview qProductReview = QProductReview.productReview;

        JPQLQuery<ProductEntity> query = queryFactory.selectFrom(qProductEntity);

        //join 하는 방법이 엔티티와 다르므로 주의
        query.leftJoin(qProductEntity.images, qProductImage);
        query.leftJoin(qProductReview).on(qProductReview.product.eq(qProductEntity));

        query.where(qProductImage.ord.eq(0));

        //검색 조건

        //상품 단위로 처리
        query.groupBy(qProductEntity);

        query.limit(pageRequestDTO.getSize());
        query.offset(pageRequestDTO.getOffset());
        query.orderBy(new OrderSpecifier<>(Order.DESC, qProductEntity.pno));

        JPQLQuery<ProductListDTO> dtoQuery = query.select(Projections.bean(
                ProductListDTO.class,
                qProductEntity.pno,
                qProductEntity.pname,
                qProductEntity.price,
                qProductImage.imgName.as("imgName"),
                qProductReview.score.coalesce(0).avg().as("avgRating"),
                qProductReview.count().as("reviewCnt")
        ));

        List<ProductListDTO> dtoList = dtoQuery.fetch();
        long total = dtoQuery.fetchCount();

        return PageResponseDTO.<ProductListDTO>withAll()
                .dtoList(dtoList)
                .total((int) total)
                .pageRequestDTO(pageRequestDTO)
                .build();
    }

    @Override
    public PageResponseDTO<ProductListAllDTO> listAllQuerydsl(PageRequestDTO pageRequestDTO) {

        QProductEntity qProductEntity = QProductEntity.productEntity;
        QProductImage qProductImage = QProductImage.productImage;
        QProductReview qProductReview = QProductReview.productReview;

        JPQLQuery<ProductEntity> query = queryFactory.selectFrom(qProductEntity);
        query.leftJoin(qProductReview).on(qProductReview.product.eq(qProductEntity));
        //query.leftJoin(qProductEntity.images, qProductImage);

        query.groupBy(qProductEntity);
        query.limit(pageRequestDTO.getLimit());
        query.offset(pageRequestDTO.getOffset());
        query.orderBy(new OrderSpecifier<>(Order.DESC, qProductEntity.pno));

        return null;
    }
}