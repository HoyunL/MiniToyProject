package com.board.controller;

import com.board.dto.BoardDto;
import com.board.entity.Board;
import com.board.service.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BoardController {

    private final BoardService boardService;


    /**
     * 게시물 조회
     */
    @GetMapping("/board")
    public String getBoard() {
        log.info("getMapping test");
        List<Board> findAll = boardService.getFindAll();
        log.info(findAll.toString());
        return "ok";

    }

    /**
     * 게시물 1건 조회
     */
    @GetMapping("/board/{id}")
    public String findByBoardId(@PathVariable(name = "id") Long id) {

        if (id.equals("") || id == null) {
            return "게시물 번호가 존재하지 않습니다.";
        }

        Optional<Board> boardById = boardService.getBoardById(id);
        log.info(boardById.toString());
        return "게시물 1건 조회 성공";
    }

    /**
     * 게시물 1건 조회
     */
    @PostMapping("/board/{id}")
    public String postFindByBoardId(@PathVariable(name = "id") Long id) {

        if (id.equals("") || id == null) {
            return "게시물 번호가 존재하지 않습니다.(post)";
        }

        boardService.getBoardById(id);
        return "게시물 1건 조회 성공 (post)";
    }

    /**
     * 게시물 저장
     */
    @PostMapping("/board")
    public ResponseEntity<?> postBoard(@RequestBody @Valid BoardDto boardDto, BindingResult bindingResult) {

        log.info("postMapping test");
        log.info(String.valueOf(boardDto));

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>("fail1", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (boardService.saveBoard(boardDto)) {
            return new ResponseEntity<>("success", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("fail2", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 게시물 수정
     */
    @PutMapping("/board/update/{id}")
    public ResponseEntity<?> updateBoard(@PathVariable(name = "id") Long id,
                                         @RequestBody @Valid BoardDto boardDto, BindingResult bindingResult) {

        if (boardDto.getBoard_no() == null) {
            return new ResponseEntity<>("null board no errors", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>("fail1", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (boardService.saveBoard(boardDto)) {
            return new ResponseEntity<>("success", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("fail2", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/board/delete/{id}")
    public String deleteBoard(@PathVariable(name = "id") Long id) {

        boardService.delete(id);
        return "delete ok";
    }


}
