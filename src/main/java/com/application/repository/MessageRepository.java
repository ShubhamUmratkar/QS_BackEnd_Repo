package com.application.repository;

import com.application.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    @Query("SELECT e FROM Message e WHERE e.sender = ?1 ORDER BY e.timestamp DESC")
    List<Message> findByEmailOrderByTimestampDesc(String email);

}