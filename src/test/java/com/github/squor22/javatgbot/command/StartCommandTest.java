package com.github.squor22.javatgbot.command;

import com.github.squor22.javatgbot.bot.command.Command;
import com.github.squor22.javatgbot.bot.command.StartCommand;
import org.junit.jupiter.api.DisplayName;

import static com.github.squor22.javatgbot.bot.command.CommandName.START;
import static com.github.squor22.javatgbot.bot.command.StartCommand.START_MESSAGE;

@DisplayName("Unit-level testing for StartCommand")
public class StartCommandTest extends AbstractCommandTest {

    @Override
    String getCommandName() {
        return START.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return START_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new StartCommand(sendBotMessageService);
    }
}
