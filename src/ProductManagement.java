import java.util.ArrayList;
import java.util.List;

public class ProductManagement {
    public List<Product> productList = new ArrayList<>();

    public void displayAll() {
        for (Product product: productList) {
            System.out.println(product);
        }
    }

    public void addNew(Product product) {
        productList.add(product);
    }

    public void deleteProduct(int index) {
        productList.remove(index);
    }

    public void updateProduct(int index, Product product) {
        productList.set(index, product);
    }

    public int findIndex(String id) {
        int index = -1;
        for (int i = 0; i < productList.size(); i++) {
            if (id.equals(productList.get(i).getId())) {
                index = i;
            }
        }
        return index;
    }
}
