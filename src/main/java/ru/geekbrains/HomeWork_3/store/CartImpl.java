package ru.geekbrains.HomeWork_3.store;

import org.springframework.stereotype.Component;
import ru.geekbrains.HomeWork_3.showcase.Product;

import java.util.ArrayList;
import java.util.List;

@Component
public class CartImpl implements Cart{

    private final ProductStore productRepository;
    private List<Product> products;

    public CartImpl(ProductStore productRepository) {
        this.productRepository = productRepository;
        this.products = new ArrayList<>();
    }

    @Override
    public void addProduct(int id) {
        products.add(productRepository.getProductById(id));
    }

    @Override
    public void deleteProduct(int id) {
        Product product = productRepository.getProductById(id);
        if (product != null) {
            products.remove(product);
        }
    }

    @Override
    public void clear() {
        products.clear();
    }

    @Override
    public List<Product> getProducts() {
        return products;
    }

}
