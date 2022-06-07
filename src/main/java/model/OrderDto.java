package model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class OrderDto {
    //注文ID
    private Long id;

    //注文量
    private Integer amount;

    //注文状況
    private OrderStatus status;

    //お客様ID
    private Long userId;

    //注文商品リスト
    private ItemDto item;

    //注文日
    private LocalDateTime orderDate;

    //キャンセル日
    private LocalDateTime orderCancelDate;
}
