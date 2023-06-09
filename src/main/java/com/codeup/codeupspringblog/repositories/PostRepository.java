package com.codeup.codeupspringblog.repositories;

import com.codeup.codeupspringblog.model.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Posts, Long> {
Posts findPostsById(long id);
}
