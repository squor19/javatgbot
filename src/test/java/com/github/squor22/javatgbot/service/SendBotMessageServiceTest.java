package com.github.squor22.javatgbot.service;

import com.github.squor22.javatgbot.bot.JavaTgBot;
import com.github.squor22.javatgbot.bot.service.SendBotMessageService;
import com.github.squor22.javatgbot.bot.service.SendBotMessageServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@DisplayName("Unit-level testing for SendBotMessageService")
public class SendBotMessageServiceTest {
    private SendBotMessageService sendBotMessageService;
    private JavaTgBot javaTgBot;

    @BeforeEach
    public void init() {
        javaTgBot = Mockito.mock(JavaTgBot.class);
        sendBotMessageService = new SendBotMessageServiceImpl(javaTgBot);
    }

    @Test
    public void shouldProperlySendMessage() throws TelegramApiException {
        String chatId = "test_chat_id";
        String message = "test_message";

        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(message);
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);

        sendBotMessageService.sendMessage(chatId, message);

        Mockito.verify(javaTgBot).execute(sendMessage);
    }
}
