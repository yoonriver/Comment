package com.project.comment;

import com.project.comment.entity.CommentEntity;
import com.project.comment.repository.CommentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.xml.stream.events.Comment;
import java.time.LocalDateTime;
import java.util.stream.IntStream;

@SpringBootApplication
public class CommentApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommentApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(CommentRepository commentRepository) throws Exception {
		return (args) -> {
			IntStream.rangeClosed(1, 100).forEach(index ->
					commentRepository.save(CommentEntity.builder()
							.content("내용" + index)
							.createdDate(LocalDateTime.now())
							.modifiedDate(LocalDateTime.now()).build()));
		};
	}
}
