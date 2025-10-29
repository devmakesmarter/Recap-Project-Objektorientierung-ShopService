import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductRepo {
    private List<Product> products;

    public ProductRepo() {
        products = new ArrayList<>();
        products.add(new Product("1", "Apfel"));
        products.add(new Product("2", "Banane"));
    }

    public List<Product> getProducts() {
        return products;
    }

    public Optional<Product> getProductById(String id) {
        Optional<Product> toReturn;

        for (Product product : products) {
            if (product.id().equals(id)) {
                toReturn = Optional.of(product);
                return toReturn;
            }
        }
        return Optional.empty();
    }

    public Product addProduct(Product newProduct) {
        products.add(newProduct);
        return newProduct;
    }

    public void removeProduct(String id) {
        for (Product product : products) {
           if (product.id().equals(id)) {
               products.remove(product);
               return;
           }
        }
    }
}
