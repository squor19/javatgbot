package com.github.squor22.javatgbot.command;

import com.github.squor22.javatgbot.command.commands.StatCommand;
import com.github.squor22.javatgbot.service.SendBotMessageService;
import com.github.squor22.javatgbot.dto.GroupStatDTO;
import com.github.squor22.javatgbot.dto.StatisticDTO;
import com.github.squor22.javatgbot.service.StatisticsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;

import static com.github.squor22.javatgbot.command.commands.StatCommand.STAT_MESSAGE;
import static com.github.squor22.javatgbot.command.AbstractCommandTest.prepareUpdate;

@DisplayName("Unit-level testing for CommandContainer")
public class CommandContainerTest {


    private SendBotMessageService sendBotMessageService;
    private StatisticsService statisticsService;
    private Command statCommand;

    @BeforeEach
    public void init() {
        sendBotMessageService = Mockito.mock(SendBotMessageService.class);
        statisticsService = Mockito.mock(StatisticsService.class);
        statCommand = new StatCommand(sendBotMessageService, statisticsService);
    }

    @Test
    public void shouldProperlySendMessage() {
        //given
        Long chatId = 1234567L;
        GroupStatDTO groupDto = new GroupStatDTO(1, "group", 1);
        StatisticDTO statisticDTO = new StatisticDTO(1, 1, Collections.singletonList(groupDto), 2.5);
        Mockito.when(statisticsService.countBotStatistic())
                .thenReturn(statisticDTO);

        //when
        statCommand.execute(prepareUpdate(chatId, CommandName.STAT.getCommandName()));

        //then
        Mockito.verify(sendBotMessageService).sendMessage(chatId, String.format(STAT_MESSAGE,
                statisticDTO.getActiveUserCount(),
                statisticDTO.getInactiveUserCount(),
                statisticDTO.getAverageGroupCountByUser(),
                String.format("%s (id = %s) - %s подписчиков", groupDto.getTitle(), groupDto.getId(), groupDto.getActiveUserCount())));
    }

}
