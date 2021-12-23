package com.project.comment.controller;

import com.project.comment.entity.CommentEntity;
import com.project.comment.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class CommentController {

    private final CommentRepository commentRepository;

    @GetMapping("/paging")
    public ResponseEntity<?> comment(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id"));
        Page<CommentEntity> commentRepositoryAll = commentRepository.findAll(pageable);
        return new ResponseEntity<>(commentRepositoryAll, HttpStatus.OK);
    }
}
