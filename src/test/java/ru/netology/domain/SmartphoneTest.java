package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {

    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    Smartphone smartphone_1 = new Smartphone(3, "iPhone 5S", 15000, "Apple");

    @Test
    void shouldSearchBySmartphone() {
        manager.add(smartphone_1);

        Product[] expected1 = new Product[]{smartphone_1};

        assertArrayEquals(expected1, manager.searchBy("Apple"));

    }

}