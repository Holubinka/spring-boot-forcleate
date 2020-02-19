package com.holubinka.dao;

import com.holubinka.model.Color;
import com.holubinka.model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserDao extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    List<User> findAllByAgeGreaterThanEqual(Integer age);

    List<User> findAllByArticle_Color(Color color);

    @EntityGraph(attributePaths = {"article"})
    List<User> getAllDistinctFirstNameBy();
}
