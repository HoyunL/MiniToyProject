package com.board.dto;

import com.board.entity.Board;
import com.common.BaseTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardDto extends BaseTime {

    private Long board_no;

    private String writer;

    private String title;

    private String content;


    public Board toBoardEntity() {
        return Board.builder()
                .board_no(board_no)
                .writer(writer)
                .title(title)
                .content(content)
                .build();
    }
}
