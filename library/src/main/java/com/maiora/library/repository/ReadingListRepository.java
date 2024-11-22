package com.maiora.library.repository;

import com.maiora.library.entity.ReadingList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReadingListRepository extends JpaRepository<ReadingList, Long> {
    List<ReadingList> findByUser_Id(Long id);
}
