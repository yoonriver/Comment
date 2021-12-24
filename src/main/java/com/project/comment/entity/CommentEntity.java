package com.project.comment.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentEntity {

    @Id
    @Column(name = "COMMENT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @ManyToOne
//    @JoinColumn(name = "USER_ID")
//    private UserEntity userEntity;

    @Column(nullable = false)
    private int movieCD;

    @Column(nullable = false)
    private String content;

    private int likes_count;

    private LocalDateTime createdDate = LocalDateTime.now(); // 생성일

    private LocalDateTime modifiedDate; // 수정일



}
