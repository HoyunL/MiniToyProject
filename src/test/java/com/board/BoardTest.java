package com.board;

import com.board.entity.Board;
import com.board.repository.BoardRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class BoardTest {

    @Autowired
    BoardRepository boardRepository;

//    @Test
//    @DisplayName("게시물 저장 여부 확인")
//    void save(){
//
//        Board board = Board.builder()
//                .board_no(3L)
//                .title("테스트2")
//                .writer("writer2")
//                .content("테스트 내용2")
//                .build();
//
//        Board boardSave = boardRepository.save(board);
//
//        Assertions.assertThat(boardSave).isEqualTo(board);
//
//
//    }
//
//    @Test
//    @DisplayName("게시물 전체 조회")
//    void findAll(){
//        List<Board> all = boardRepository.findAll();
//        System.out.println("all = " + all);
//    }

    @Test
    @DisplayName("게시물 조건 조회")
    void deleteById(Long id) throws Exception{
        if(id == null){
            throw new Exception("게시글 번호가 존재 하지 않습니다.");
        }

    }


}
