package com.project.comment;

import com.project.comment.Entity.CommentEntity;
import com.project.comment.Entity.User;
import com.project.comment.repository.CommentRepository;
import com.project.comment.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ContentTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Test
    public void test1() {
        User user = new User();
        user.setUserId("hello");

        userRepository.save(user);

        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setMovieCD(15342);
        commentEntity.setContent("안녕하세요 반갑습니다?");
        commentEntity.setUser(user);

        commentRepository.save(commentEntity);

        System.out.println("commentEntity.getId() = " + commentEntity.getId());
        System.out.println("commentEntity.getUser() = " + commentEntity.getUser());
        System.out.println("commentEntity.getContent() = " + commentEntity.getContent());
        System.out.println("commentEntity.getMovieCD() = " + commentEntity.getMovieCD());


    }
}
