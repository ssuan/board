package com.susu.board.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class PostResponseDto {

    @JsonProperty("board_id")
    private Long id;
    private String title;
    private String content;

}
