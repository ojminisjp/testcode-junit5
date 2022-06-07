package model;

import lombok.Data;

@Data
public class ItemDto {
    // 商品ID
    private Long id;

    // 商品名
    private String name;

    // 価額
    private Integer price;

}
