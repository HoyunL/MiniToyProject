package com.board.service;


import com.board.dto.BoardDto;
import com.board.entity.Board;
import com.board.repository.BoardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public List<Board> getFindAll() {
        return boardRepository.findAll();

    }

    public Optional<Board> getBoardById(Long id) {
        return boardRepository.findById(id);

    }

    public Long saveBoard(BoardDto boardDto) {
        Board entity = boardRepository.save(boardDto.toBoardEntity());
        return entity.getBoard_no();
    }

    public void delete(Long id) {
        boardRepository.deleteById(id);
    }
}

