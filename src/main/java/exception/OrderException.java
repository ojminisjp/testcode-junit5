package exception;

import model.OrderDto;

public class OrderException extends RuntimeException {
    public OrderException(String message, OrderDto orderDto) {
        super(String.format("%s,\norderDto = {%s}", message, orderDto.toString()));
    }
}
