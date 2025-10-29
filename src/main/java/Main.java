import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main (String[] args) throws ProductNotFoundException {

        ShopService shopService = new ShopService();
        //System.out.println(shopService);
        //System.out.println("Hallo");
        List<Product> myOrder = new ArrayList<>();

        //myOrder.add(new Product("2", "Banane"));

        Order ordertwo = new Order("453",myOrder,OrderStatus.PROCESSING);
        shopService.addOrder(List.of("2","1"));
        //System.out.println(shopService.getOrderRepo().getOrders());
        System.out.println(shopService.getOrdersByOrderStatus(OrderStatus.PROCESSING));


    }
}
