package hh.soft.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import hh.soft.bookstore.repository.UserRepository;
import hh.soft.bookstore.domain.AppUser;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    @Test
    public void findByUsernameShouldReturnUser() {
        AppUser user = new AppUser("test", "password", "USER");
        repository.save(user);

        AppUser found = repository.findByUsername("test");

        assertThat(found).isNotNull();
        assertThat(found.getUsername()).isEqualTo("test");
    }

    @Test
    public void createNewUser() {
        AppUser user = new AppUser("test", "password", "USER");
        repository.save(user);
        assertThat(user.getId()).isNotNull();
    }

    @Test
    public void deleteUser() {
        AppUser user = new AppUser("test", "password", "USER");
        repository.save(user);
        
        Long id = user.getId();
        assertThat(repository.findById(id)).isPresent();

        repository.delete(user);
        assertThat(repository.findById(id)).isNotPresent();
    }

}