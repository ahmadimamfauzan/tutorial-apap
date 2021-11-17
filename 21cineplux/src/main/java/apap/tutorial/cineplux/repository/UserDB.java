package apap.tutorial.cineplux.repository;

import apap.tutorial.cineplux.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDB extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findByUsername(String username);
}