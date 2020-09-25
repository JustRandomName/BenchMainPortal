package main.main.repository;

import model.entity.Form;
import model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * @author n.zhuchkevich
 * @since 09/22/2020
 * */
@Repository
public interface FormRepository extends JpaRepository<Form, UUID> {
    List<Form> findAllByUser(User user);
}
