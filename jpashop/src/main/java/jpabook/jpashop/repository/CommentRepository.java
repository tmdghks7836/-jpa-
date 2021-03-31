package jpabook.jpashop.repository;

import jpabook.jpashop.entity.Comment;
import jpabook.jpashop.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
