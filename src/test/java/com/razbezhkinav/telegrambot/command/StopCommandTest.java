package com.razbezhkinav.telegrambot.command;

import org.junit.jupiter.api.DisplayName;

import static com.razbezhkinav.telegrambot.command.CommandName.STOP;
import static com.razbezhkinav.telegrambot.command.StopCommand.STOP_MESSAGE;

@DisplayName("Unit-level testing for StartCommand")
class StopCommandTest extends AbstractCommandTest{

    @Override
    String getCommandName() {
        return STOP.getName();
    }

    @Override
    String getCommandMessage() {
        return STOP_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new StopCommand(sendBotMessageService, telegramUserService);
    }
}