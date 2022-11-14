package com.mink.javaspringnb1.Repositories;

import com.mink.javaspringnb1.Models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Integer> {
}
