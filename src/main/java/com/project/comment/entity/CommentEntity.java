package com.project.comment.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class CommentEntity {

    @Id
    @Column(name = "COMMENT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @Column(nullable = false)
    private int movieCD;

    @Column(nullable = false)
    private String content;


}
