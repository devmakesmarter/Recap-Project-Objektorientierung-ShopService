import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

public class ShopService {
    private ProductRepo productRepo = new ProductRepo();
    private OrderRepo orderRepo = new OrderMapRepo();

    public Order addOrder(List<String> productIds) throws ProductNotFoundException {
        List<Product> products = new ArrayList<>();

            for (String productId : productIds) {
                Optional<Product> productToOrder = productRepo.getProductById(productId);
                Product productToAdd = productToOrder.orElseThrow(()-> new ProductNotFoundException("Product not found with " + productId));
                products.add(productToAdd);
            }

            Order newOrder = new Order(UUID.randomUUID().toString(), products, OrderStatus.PROCESSING);

            return orderRepo.addOrder(newOrder);





    }


    public OrderRepo getOrderRepo() {
        return orderRepo;
    }

    public List<Order> getOrdersByOrderStatus(OrderStatus orderStatus){
        List<Order> orderToFilter = orderRepo.getOrders();
        List<Order> toReturn = orderRepo.getOrders().stream().filter(x -> x.orderStatus().equals(orderStatus)).toList();
        return toReturn;
    }



}
