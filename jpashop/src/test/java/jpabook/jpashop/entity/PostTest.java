package jpabook.jpashop.entity;

import jpabook.jpashop.repository.CommentRepository;
import jpabook.jpashop.repository.PostRepository;
import org.hibernate.collection.internal.PersistentBag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class PostTest {

    @Autowired
    PostRepository postRepository;

    @Autowired
    CommentRepository commentRepository;

    @Test
    @Transactional
    @Rollback(value = false)
    void save() {

        Post post = Post.builder()
                .username("gd")
                .build();

        postRepository.save(post);
         for (int i = 0; i < 10; i++) {
            commentRepository.save(Comment.builder().post(post).build());
        }



//        Assertions.assertThat().isEqualTo(member.getId());
//        Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
//        Assertions.assertThat(findMember).isEqualTo(member);
    }
}