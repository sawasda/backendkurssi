package hh.soft.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import hh.soft.bookstore.repository.CategoryRepository;
import hh.soft.bookstore.domain.Category;

@DataJpaTest

public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository repository;

    @Test
    public void findByNameShouldReturnId() {
        List<Category> categories = repository.findByName("Fantasy");

        assertThat(categories).hasSize(1);
        assertThat(categories.get(0).getName()).isEqualTo("Fantasy");
    }

    @Test
    public void createNewCategory() {
        Category category4 = new Category("Horror");
        repository.save(category4);
        assertThat(category4.getCategoryId()).isNotNull();
    }

    @Test
    public void deleteCategory() {
        Category category4 = new Category("Horror");
        repository.save(category4);
        assertThat(category4.getCategoryId()).isNotNull();

        repository.delete(category4);
        assertThat(repository.findById(category4.getCategoryId()).isEmpty());
    }

}
