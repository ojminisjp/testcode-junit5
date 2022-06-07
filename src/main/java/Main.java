import model.OrderDto;
import service.order.OrderService;

public class Main {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        orderService.orderCancel(new OrderDto());
    }
}
