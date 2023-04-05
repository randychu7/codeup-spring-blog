package com.codeup.codeupspringblog.repositories;

import com.codeup.codeupspringblog.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag,Long> {
    Tag findTagByName(String name);
}
