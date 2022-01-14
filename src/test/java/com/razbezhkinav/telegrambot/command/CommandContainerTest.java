package com.razbezhkinav.telegrambot.command;

import com.razbezhkinav.telegrambot.service.SendBotMessageService;
import com.razbezhkinav.telegrambot.service.TelegramUserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

@DisplayName("Unit-level testing for CommandContainer")
class CommandContainerTest {

    private CommandContainer commandContainer;

    @BeforeEach
    void setUp() {
        SendBotMessageService sendBotMessageService = Mockito.mock(SendBotMessageService.class);
        TelegramUserService telegramUserService = Mockito.mock(TelegramUserService.class);
        commandContainer = new CommandContainer(sendBotMessageService,telegramUserService);
    }

    /**
     * Проверка что все команды находящиеся в CommandName находятся в CommandContainer
     * Если команда в CommandName отсутствует, будет выдаваться команда UnknownCommand
     */
    @Test
    void shouldAllTheExistingCommand(){
        Arrays.stream(CommandName.values())
                .forEach(commandName -> {
                    Command command = commandContainer.retrieveCommand(commandName.getName());
                    Assertions.assertNotEquals(UnknownCommand.class,command.getClass());
                });
    }

    @Test
    void shouldReturnUnknownCommand(){
        String unknownCommand = "/unknown";

        Command command = commandContainer.retrieveCommand(unknownCommand);

        Assertions.assertEquals(UnknownCommand.class,command.getClass());
    }
}