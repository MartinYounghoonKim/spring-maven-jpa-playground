package com.whiteship.springmavenjpaplayground;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    // https://docs.spring.io/spring-data/jpa/docs/2.2.4.RELEASE/reference/html/#reference
    Page<Post> findByTitleContains (String title, Pageable pageable);

    long countByTitleContains(String title);
}