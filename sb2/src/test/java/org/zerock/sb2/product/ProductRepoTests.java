package org.zerock.sb2.product;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.sb2.product.entities.ProductEntity;
import org.zerock.sb2.product.repository.ProductRepository;

import java.util.Optional;

@SpringBootTest
@Log4j2
public class ProductRepoTests {

    @Autowired(required = false)
    ProductRepository repo;


    @Test
    public void insertProduct() {
        for (int i = 0; i < 32; i++) {
            ProductEntity product = ProductEntity.builder()
                    .pname("Product " + i)
                    .price(5000)
                    .build();
            //상품 하나당 이미지 2개
            product.addImage(i+"_img0.jpg");
            product.addImage(i+"_img1.jpg");

            repo.save(product);
        }//end for
    }

    @Test
    public void testRead1(){
        Optional<ProductEntity> result = repo.findById(1L);

        ProductEntity product = result.get();

        //tbl_product_img 테이블은 처리되지 않는다.
        log.info(product);

    }

    @Test
    public void testRead2(){
        ProductEntity product = repo.selectOne(1L);

        log.info(product);
        log.info(product.getImages());
    }
}
