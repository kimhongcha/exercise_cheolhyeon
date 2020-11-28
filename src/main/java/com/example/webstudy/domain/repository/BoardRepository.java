package com.example.webstudy.domain.repository;

import com.example.webstudy.domain.entity.BoardEntity;
import com.example.webstudy.domain.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
    List<BoardEntity> findByTitleContaining(String keyword);
}
