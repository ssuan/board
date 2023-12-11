package com.susu.board.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "file")
@Getter
public class File {

    @Id
    @Column(name = "file_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;


    @Column(nullable = false)
    private String originalFileName;

    @Column(nullable = false)
    private String storedFileName;

}
