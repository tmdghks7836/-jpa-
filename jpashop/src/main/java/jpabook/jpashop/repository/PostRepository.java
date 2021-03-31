package jpabook.jpashop.repository;

import jpabook.jpashop.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
