package com.susu.board.controller;

import com.susu.board.dto.PostRequestDto;
import com.susu.board.dto.PostResponseDto;
import com.susu.board.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/{post_id}")
    public ResponseEntity<PostResponseDto> getPost(@PathVariable("post_id") Long postId) {
        PostResponseDto responseDto = postService.get(postId);
        return ResponseEntity.ok(responseDto);
    }

    @PostMapping
    public ResponseEntity<PostResponseDto> writePost(@RequestBody PostRequestDto requestDto) {
        PostResponseDto responseDto = postService.write(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @PutMapping("/{post_id}")
    public ResponseEntity<PostResponseDto> updatePost(@PathVariable("post_id") Long postId, @RequestBody PostRequestDto postRequestDto) {
        PostResponseDto responseDto = postService.edit(postId, postRequestDto);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/{post_id}")
    public ResponseEntity<Long> deletePost(@PathVariable("post_id") Long postId) {
        postService.delete(postId);
        return ResponseEntity.ok(postId);
    }

}
