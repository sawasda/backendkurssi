package hh.soft.bookstore.repository;

import org.springframework.data.repository.CrudRepository;
import hh.soft.bookstore.domain.AppUser;

public interface UserRepository extends CrudRepository<AppUser, Long> {
    AppUser findByUsername(String username);
}
