package com.maiora.library.repository;

import com.maiora.library.entity.ReadingHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReadingHistoryRepository extends JpaRepository<ReadingHistory, Long> {

    List<ReadingHistory> findByUser_Id(Long id);


    List<ReadingHistory> findByUserIdOrderByReadDateDesc(Long userId);

    List<ReadingHistory> findByUser_IdAndReadDateBetween(Long id, LocalDateTime readDateStart, LocalDateTime readDateEnd);

    List<ReadingHistory> findByReadDateBetween(LocalDateTime readDateStart, LocalDateTime readDateEnd);

}
