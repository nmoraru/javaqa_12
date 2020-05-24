package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    Book book_1 = new Book(1, "Чистый код", 550, "Роберт Мартин");
    Book book_2 = new Book(2, "Философия Java", 1500, "Эккель Брюс");
    Smartphone smartphone_1 = new Smartphone(3, "iPhone 5S", 15000, "Apple");
    Smartphone smartphone_2 = new Smartphone(4, "Galaxy S10E", 35000, "Samsung");

    @Test
    void shouldSearchByBook() {
        manager.add(book_1);
        manager.add(book_2);
        manager.add(smartphone_1);
        manager.add(smartphone_2);

        Product[] expected1 = new Product[]{book_1};
        Product[] expected2 = new Product[]{book_2};

        assertArrayEquals(expected1, manager.searchBy("Чистый код"));
        assertArrayEquals(expected2, manager.searchBy("Эккель Брюс"));

    }

    @Test
    void shouldSearchBySmartphone() {
        manager.add(book_1);
        manager.add(book_2);
        manager.add(smartphone_1);
        manager.add(smartphone_2);

        Product[] expected1 = new Product[]{smartphone_1};
        Product[] expected2 = new Product[]{smartphone_2};

        assertArrayEquals(expected1, manager.searchBy("Apple"));
        assertArrayEquals(expected2, manager.searchBy("Galaxy S10E"));

    }

}