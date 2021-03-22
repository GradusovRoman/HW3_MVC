package ru.geekbrains.HomeWork_3.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import ru.geekbrains.HomeWork_3.showcase.Product;
import ru.geekbrains.HomeWork_3.store.Cart;
import ru.geekbrains.HomeWork_3.store.CartImpl;
import ru.geekbrains.HomeWork_3.store.ProductStore;
import ru.geekbrains.HomeWork_3.store.ProductStoreImpl;
import java.util.List;


@EnableWebMvc
@Configuration
@ComponentScan("ru.geekbrains.HomeWork_3")
public class AppConfig  implements WebMvcConfigurer {
    @Bean
public List<Product> productList() {
    return List.of(

            new Product(1, "milk", 50),
            new Product(2, "bread", 40),
            new Product(3, "orange", 90),
            new Product(4, "banana", 95),
            new Product(5, "rice", 41)
    );
}

    @Bean
    @Scope
    public Cart cart(ProductStore productRepository) {
        return new CartImpl(productRepository);
    }

    @Bean
    public ProductStore productRepository(List<Product> productList) {
        return new ProductStoreImpl(productList);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        return templateEngine;

    }
    @Bean
    public ThymeleafViewResolver thymeleafViewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setCharacterEncoding("UTF-8");
        viewResolver.setTemplateEngine(templateEngine());
        return viewResolver;
    }
}
