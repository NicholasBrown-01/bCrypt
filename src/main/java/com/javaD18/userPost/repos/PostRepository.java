package com.javaD18.userPost.repos;

import com.javaD18.userPost.models.PostClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostClass, Long> {
        public PostClass getPostByPostID(String postID);
}
