package com.project.comment;

import com.project.comment.entity.CommentEntity;
import com.project.comment.entity.UserEntity;
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

        for(int i = 0 ; i<20 ; i++) {
            CommentEntity commentEntity = new CommentEntity();
            commentEntity.setContent("Content"+i);
            commentEntity.setMovieCD(i);

            commentRepository.save(commentEntity);
        }

    }


}
