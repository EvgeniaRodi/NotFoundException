package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book first = new Book(1, "Uwe's second life", 350, "Fredrik Backman", 330, 2016);
    private Book second = new Book( 2, "Radical Forgiveness", 400, "Colin Tipping", 270, 2019 );
    private TShirt third = new TShirt(3, "Puma", 1300, "White", "XS");
    private TShirt fourth = new TShirt(4, "Nike", 1500, "Red", "S");
    private TShirt fifth = new TShirt(5, "Adidas", 1600, "Black", "M");

    @Test
    public void shouldRemoveById() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);

        repository.removeById(3);

        Product[] expected = new Product[]{first, third, fourth, fifth};
        Product[] actual = repository.findAll();
    }

    @Test
    public void shouldThrowException() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);

        assertThrows(NotFoundException.class, () -> repository.removeById(6));
    }
}