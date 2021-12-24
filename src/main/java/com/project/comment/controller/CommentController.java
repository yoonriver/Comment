package com.project.comment.controller;

import com.project.comment.entity.CommentEntity;
import com.project.comment.repository.CommentRepository;
import com.project.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
public class CommentController {

    private final CommentRepository commentRepository;

    private final CommentService commentService;

    // 게시글 목록
    @GetMapping("/list")
    public String list(Pageable pageable, Model model) {
        model.addAttribute("boardList", commentService.findCommentList(pageable));
        return "/comment/list";
    }

    // 게시글 상세 및 등록 폼 호출
    @GetMapping({"","/"})
    public String comment(@RequestParam(value="id", defaultValue = "0") Long id, Model model) {
        model.addAttribute("comment", commentService.findCommentById(id));
        return "/comment/form";
    }

    // 게시글 생성
    @PostMapping
    public ResponseEntity<?> postComment(@RequestBody CommentEntity commentEntity) {
        commentEntity.setCreatedDate(LocalDateTime.now());
        commentEntity.setModifiedDate(LocalDateTime.now());
        commentRepository.save(commentEntity);

        return new ResponseEntity<>("{}", HttpStatus.CREATED);
    }

    // 게시글 수정
    @PutMapping("/{id}")
    public ResponseEntity<?> putComment(@PathVariable("id") Long id, @RequestBody CommentEntity commentEntity) {
        CommentEntity findCommentEntity = commentRepository.findById(id).get();
        findCommentEntity.setModifiedDate(LocalDateTime.now());
        findCommentEntity.setContent(commentEntity.getContent());
        commentRepository.save(findCommentEntity);

        return new ResponseEntity<>("{}", HttpStatus.OK);

    }

    // 게시글 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable("id") Long id) {
        CommentEntity findCommentEntity = commentRepository.findById(id).get();
        commentRepository.delete(findCommentEntity);

        return new ResponseEntity<>("{}", HttpStatus.OK);
    }


}
