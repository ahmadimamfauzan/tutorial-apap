package apap.tutorial.cineplux.repository;

import apap.tutorial.cineplux.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface RoleDB extends JpaRepository<RoleModel, Long> {
    Optional<RoleModel> findById(Long id);
}
