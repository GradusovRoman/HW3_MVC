package ru.geekbrains.HomeWork_3.controller;

import org.springframework.ui.Model;
import ru.geekbrains.HomeWork_3.showcase.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;


@Controller

public class WController {
    private final List<Product> productList;

    public WController(List<Product> productList) {
        this.productList = productList;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("products", productList);
        return "index";
    }
}