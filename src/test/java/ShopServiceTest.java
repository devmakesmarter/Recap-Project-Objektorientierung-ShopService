import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShopServiceTest {

    @Test
    void addOrderTest() throws ProductNotFoundException {
        //GIVEN
        ShopService shopService = new ShopService();
        List<String> productsIds = List.of("1");

        //WHEN
        Order actual = shopService.addOrder(productsIds);

        //THEN
        Order expected = new Order("-1", List.of(new Product("1", "Apfel")),OrderStatus.PROCESSING);
        assertEquals(expected.products(), actual.products());
        assertNotNull(expected.id());
    }

    @Test
    void addOrderTest_whenInvalidProductId_expectNull() throws ProductNotFoundException {
        //GIVEN
        ShopService shopService = new ShopService();
        List<String> productsIds = List.of("1", "2","3");

        //WHEN


        //THEN
        assertThrows(ProductNotFoundException.class,()-> shopService.addOrder(productsIds));
    }
    @Test
    void getOrdersByOrderStatusTest_whenWrongOrderStatus() throws ProductNotFoundException {
        //GIVEN
        ShopService shopService = new ShopService();
        List<String> productsIds = List.of("1", "2");
        shopService.addOrder(productsIds);


        //WHEN
        List<Order> actual = shopService.getOrdersByOrderStatus(OrderStatus.COMPLETED);

        //THEN
        assertEquals(Collections.emptyList(),actual);
    }

    @Test
    void getOrdersByOrderStatusTest_whenRightOrderStatus() throws ProductNotFoundException {
        //GIVEN
        ShopService shopService = new ShopService();
        List<String> productsIds = List.of("1", "2");
        shopService.addOrder(productsIds);
        List<Order> expected = shopService.getOrderRepo().getOrders();

        //WHEN
        List<Order> actual = shopService.getOrdersByOrderStatus(OrderStatus.PROCESSING);

        //THEN
        assertEquals(expected,actual);
    }


}
