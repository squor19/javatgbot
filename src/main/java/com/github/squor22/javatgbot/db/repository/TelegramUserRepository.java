package com.github.squor22.javatgbot.db.repository;

import com.github.squor22.javatgbot.db.entity.TelegramUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TelegramUserRepository extends JpaRepository<TelegramUser, String> {
    List<TelegramUser> findAllByActiveTrue();

    List<TelegramUser> findAllByActiveFalse();


}