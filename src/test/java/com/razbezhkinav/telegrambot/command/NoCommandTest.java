package com.razbezhkinav.telegrambot.command;

import org.junit.jupiter.api.DisplayName;

import static com.razbezhkinav.telegrambot.command.CommandName.NO;
import static com.razbezhkinav.telegrambot.command.NoCommand.NO_MESSAGE;

@DisplayName("Unit-level testing for NoCommand")
class NoCommandTest extends AbstractCommandTest{

    @Override
    String getCommandName() {
        return NO.getName();
    }

    @Override
    String getCommandMessage() {
        return NO_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new NoCommand(sendBotMessageService);
    }
}