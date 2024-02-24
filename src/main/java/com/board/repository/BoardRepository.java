package com.board.repository;

import com.board.dto.BoardDto;
import com.board.entity.Board;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<Board,Long> {

    void save(BoardDto boardDto);

    List<Board> findAll();

     Optional<Board> findById(Long id);

     void deleteById(Long id);

}
