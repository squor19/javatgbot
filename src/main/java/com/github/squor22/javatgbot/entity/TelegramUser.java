package com.github.squor22.javatgbot.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Telegram User entity.
 */
@Data
@Entity
@Table(name = "tg_user")
public class TelegramUser {

    @Id
    @Column(name = "chat_id")
    private Long chatId;

    @Column(name = "active")
    private boolean active;

    @ManyToMany(mappedBy = "users", fetch = FetchType.EAGER)
    private List<GroupSub> groupSubs;
}