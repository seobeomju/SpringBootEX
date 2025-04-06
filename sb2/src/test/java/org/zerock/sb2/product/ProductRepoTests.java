package org.zerock.sb2.product;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.zerock.sb2.product.dto.ProductListDTO;
import org.zerock.sb2.product.dto.ProductReadDTO;
import org.zerock.sb2.product.entities.ProductEntity;
import org.zerock.sb2.product.repository.ProductRepository;

import java.util.Arrays;
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

    @Test
    public void testRead3(){
        //ElementCollection이 여러 개인 경우 한 개의 객체로 변환하는데 어려움이 있다.
        //Java 코드를 이용해서 변환해야 한다
        ProductEntity product = repo.selectOne(1L);
        ProductReadDTO dto = new ProductReadDTO(product);
        log.info(dto);

    }

    @Test
    public void testList1(){
        Pageable pageable = PageRequest.of(0, 10, Sort.by("pno").descending());
        Page<Object[]> result = repo.list1(pageable);

        result.forEach(arr -> log.info(Arrays.toString(arr)));
    }
    @Test
    public void testList2(){
        Pageable pageable = PageRequest.of(0, 10, Sort.by("pno").descending());
        Page<ProductListDTO> result = repo.list1DTO(pageable);

        result.forEach(dto -> log.info(dto));
    }


}
