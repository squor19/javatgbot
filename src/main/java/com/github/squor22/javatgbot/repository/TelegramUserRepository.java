package com.github.squor22.javatgbot.repository;

import com.github.squor22.javatgbot.entity.TelegramUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TelegramUserRepository extends JpaRepository<TelegramUser, Long> {
    List<TelegramUser> findAllByActiveTrue();

    List<TelegramUser> findAllByActiveFalse();




}