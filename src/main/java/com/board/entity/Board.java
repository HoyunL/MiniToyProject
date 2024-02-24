package com.board.entity;


import com.board.dto.BoardDto;
import com.common.BaseTime;
import jakarta.persistence.*;
import lombok.*;

@ToString
@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity
@Table(name = "board")
public class Board extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long board_no;

    @Column(nullable = false)
    private String writer;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    public BoardDto toBoardDto() {
        return BoardDto.builder()
                .board_no(board_no)
                .writer(writer)
                .title(title)
                .content(content)
                .build();
    }


}
