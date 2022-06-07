package service.order;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import exception.OrderException;
import model.ItemDto;
import model.OrderDto;
import model.OrderStatus;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("注文機能テスト")
class OrderServiceTest {

    private OrderDto orderDto;
    private ItemDto itemDto;
    private OrderService orderService;

    //@AfterAll
    @BeforeAll
    static void init() {
        System.out.println("全テスト実行する前に一回のみ実行");
    }

    //各テストの前に実行.
    //@AfterEach
    @BeforeEach
    void setUp() {
        System.out.println("setUp");

        itemDto = new ItemDto();
        itemDto.setId(1L);
        itemDto.setName("テスト商品");
        itemDto.setPrice(5000);

        orderDto = new OrderDto();
        orderService = new OrderService();
    }

    @Test
    @DisplayName("注文生成テスト")
    void orderCreate() {
        Long userId = 1000L;
        Integer amount = 2;
        OrderDto orderDto = orderService.orderCreate(userId, itemDto, amount);

        assertAll("注文内容を確認",
                () -> assertEquals(userId, orderDto.getUserId()),
                () -> assertEquals(amount, orderDto.getAmount()),
                () -> {
                    assertAll("注文状況、注文日を確認",
                            () -> assertEquals(OrderStatus.REQUEST, orderDto.getStatus()),
                            () -> assertNotNull(orderDto.getOrderDate())
                    );
                });
    }

    @Test
    @DisplayName("注文キャンセルテスト")
    void orderCancel() {
        orderDto.setStatus(OrderStatus.COMPLETE);
        OrderDto cancelOrderDto = orderService.orderCancel(orderDto);

        assertEquals(OrderStatus.CANCEL, cancelOrderDto.getStatus());
    }

    @Test
    @DisplayName("注文内容変更時Throwテスト")
    void orderUpdateAmount() {
        orderDto.setStatus(OrderStatus.COMPLETE);
        Exception exception = assertThrows(OrderException.class, () -> orderService.orderUpdateAmount(orderDto, 3));

        String expectedMessage = String.format("%s,\norderDto = {%s}", "注文内容変更に失敗しました。", orderDto.toString());
        assertEquals(expectedMessage, exception.getMessage());
    }
}