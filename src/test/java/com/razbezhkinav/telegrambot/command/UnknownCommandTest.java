package com.razbezhkinav.telegrambot.command;

import org.junit.jupiter.api.DisplayName;

import static com.razbezhkinav.telegrambot.command.UnknownCommand.UNKNOWN_MESSAGE;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Unit-level testing for UnknownCommand")
class UnknownCommandTest extends AbstractCommandTest{

    @Override
    String getCommandName() {
        return "/unknownCommand";
    }

    @Override
    String getCommandMessage() {
        return UNKNOWN_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new UnknownCommand(sendBotMessageService);
    }
}