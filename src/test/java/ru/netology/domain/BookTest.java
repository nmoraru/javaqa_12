package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    Book book_1 = new Book(1, "Чистый код", 550, "Роберт Мартин");

    @Test
    void shouldSearchToBook() {
        manager.add(book_1);

        Product[] expected1 = new Product[]{book_1};

        assertArrayEquals(expected1, manager.searchBy("Чистый код"));
    }


}