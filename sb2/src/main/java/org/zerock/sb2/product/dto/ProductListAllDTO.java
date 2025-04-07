package org.zerock.sb2.product.dto;

import java.util.List;

public class ProductListAllDTO {
    private Long pno;
    private String pname;
    private int price;
    private List<String> imgName;

    private double avgRating;
    private long reviewCnt;
}
