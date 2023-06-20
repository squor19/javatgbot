package com.github.squor22.javatgbot.bot.service;

import com.github.squor22.javatgbot.bot.JavaTgBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class SendBotMessageServiceImpl implements SendBotMessageService {
    private final JavaTgBot javaTgBot;

    @Autowired
    public SendBotMessageServiceImpl(JavaTgBot javaTgBot) {
        this.javaTgBot = javaTgBot;
    }

    public void sendMessage(String chatId, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);
        sendMessage.setText(message);

        try {
            javaTgBot.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}