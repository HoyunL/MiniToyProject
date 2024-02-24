package com.board.controller;

import com.board.dto.BoardDto;
import com.board.service.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;


    /**
     * 게시물 조회
     */
    @GetMapping("/board")
    public String getBoard() {
        return "OK";

    }

    /**
     * 게시물 1건 조회
     */
    @GetMapping("/board/{id}")
    public String findByBoardId(@PathVariable Long id) {

        if (id.equals("") || id == null) {
            return "게시물 번호가 존재하지 않습니다.";
        }

        boardService.getBoardById(id);
        return "게시물 1건 조회 성공";
    }

    /**
     * 게시물 1건 조회
     */
    @PostMapping("/board/{id}")
    public String postFindByBoardId(@PathVariable Long id) {

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
    public String postBoard(@Valid BoardDto boardDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "유효성 검증에 통과하지 못했습니다.";
        }

        boardService.saveBoard(boardDto);
        return "글작성 완료입니다. db에서 한번더 확인해 보세요";
    }

    /**
     * 게시물 수정
     */

//    @PutMapping("/board/update")




}
