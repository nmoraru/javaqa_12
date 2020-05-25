package java.ru.netology.manager;

import java.ru.netology.domain.Product;
import java.ru.netology.repository.ProductRepository;


public class ProductManager {
    private ProductRepository repository = new ProductRepository();

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }


    public void add(Product product) {
        repository.save(product);
    }

    public Product[] getFilms() {
        return repository.findAll();
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (product.matches(text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

}
