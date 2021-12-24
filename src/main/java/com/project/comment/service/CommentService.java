package com.project.comment.service;

import com.project.comment.entity.CommentEntity;
import com.project.comment.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public Page<CommentEntity> findCommentList(Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber(), pageable.getPageSize(), Sort.by("id"));
        Page<CommentEntity> paging = commentRepository.findAll(pageable);
        return paging;
    }

    public CommentEntity findCommentById(Long id) {
        CommentEntity commentEntity = commentRepository.findById(id).get();
        return commentEntity;
    }






}
