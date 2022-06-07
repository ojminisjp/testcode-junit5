package service.order;

import java.time.LocalDateTime;

import exception.OrderException;
import model.ItemDto;
import model.OrderDto;
import model.OrderStatus;

public class OrderService {

    //注文生成
    public OrderDto orderCreate(Long userId, ItemDto itemDto, Integer amount) {
        OrderDto orderDto = new OrderDto();
        orderDto.setAmount(amount);
        orderDto.setStatus(OrderStatus.REQUEST);
        orderDto.setUserId(userId);
        orderDto.setItem(itemDto);
        orderDto.setOrderDate(LocalDateTime.now());
        return orderDto;
    }

    //注文キャンセル
    public OrderDto orderCancel(OrderDto orderDto) {
        orderDto.setStatus(OrderStatus.CANCEL);
        orderDto.setOrderCancelDate(LocalDateTime.now());
        return orderDto;
    }

    //注文内容変更
    public OrderDto orderUpdateAmount(OrderDto orderDto, Integer amount) {
        if (orderDto.getStatus() != OrderStatus.REQUEST) {
            throw new OrderException("注文内容変更に失敗しました。", orderDto);
        }

        orderDto.setAmount(amount);
        return orderDto;
    }
}
