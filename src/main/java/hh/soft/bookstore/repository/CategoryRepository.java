package hh.soft.bookstore.repository;

import org.springframework.data.repository.CrudRepository;
import java.util.List;
import hh.soft.bookstore.domain.Category;


public interface CategoryRepository extends CrudRepository<Category, Long> {

    List<Category> findByName(String name);

}
