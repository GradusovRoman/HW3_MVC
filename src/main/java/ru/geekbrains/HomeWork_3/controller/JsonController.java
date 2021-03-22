package ru.geekbrains.HomeWork_3.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.HomeWork_3.showcase.Product;
import java.io.IOException;

@RestController
@RequestMapping("/json")
public class JsonController {

    @GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public Product getJson() throws IOException {
        return new Product(6,"popcorn", 55);
    }

}
