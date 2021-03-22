package ru.geekbrains.HomeWork_3.store;

import ru.geekbrains.HomeWork_3.showcase.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductStoreImpl implements ProductStore {
    private final List<Product> productList;

    public ProductStoreImpl(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public List<Product> getProductList() {
        return productList;
    }

    @Override
    public Product getProductById(int id) {
        Optional<Product> product = productList.stream().filter(p -> p.getId() == id).findFirst();
        return product.orElse(null);
    }
}
