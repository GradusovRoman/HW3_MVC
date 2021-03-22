package ru.geekbrains.HomeWork_3.store;

import ru.geekbrains.HomeWork_3.showcase.Product;
import java.util.List;

public interface ProductStore {
    List<Product> getProductList();
    Product getProductById(int id);
}
