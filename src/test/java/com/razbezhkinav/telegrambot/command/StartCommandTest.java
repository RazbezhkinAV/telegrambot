package com.razbezhkinav.telegrambot.command;

import org.junit.jupiter.api.DisplayName;

import static com.razbezhkinav.telegrambot.command.CommandName.START;
import static com.razbezhkinav.telegrambot.command.StartCommand.START_MESSAGE;

@DisplayName("Unit-level testing for StartCommand")
class StartCommandTest extends AbstractCommandTest{

    @Override
    String getCommandName() {
        return START.getName();
    }

    @Override
    String getCommandMessage() {
        return START_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new StartCommand(sendBotMessageService, telegramUserService);
    }
}