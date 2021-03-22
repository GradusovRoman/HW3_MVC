package ru.geekbrains.HomeWork_3.store;
import ru.geekbrains.HomeWork_3.showcase.Product;
import java.util.List;


public interface Cart {
    void addProduct(int id);
    void deleteProduct(int id);
    void clear();
    List<Product> getProducts();
}
