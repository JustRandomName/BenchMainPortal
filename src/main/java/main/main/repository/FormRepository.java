package main.main.repository;

import model.entity.Form;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author n.zhuchkevich
 * @since 09/22/2020
 * */
@Repository
public interface FormRepository extends JpaRepository<Form, UUID> {
}
