package com.greenfox.tomdreidel.chatapp.repository;

import java.util.List;
import com.greenfox.tomdreidel.chatapp.model.ChatMessage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<ChatMessage, Long> {

  @Query(value = "SELECT * FROM chat_message ORDER BY timestamp ASC LIMIT 10 OFFSET ((SELECT count(*) from chat_message) - 10)", nativeQuery = true)
  public List<ChatMessage> messagePaginated();

}
