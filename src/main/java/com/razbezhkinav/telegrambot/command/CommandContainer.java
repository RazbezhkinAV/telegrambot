package com.razbezhkinav.telegrambot.command;

import com.google.common.collect.ImmutableMap;
import com.razbezhkinav.telegrambot.service.SendBotMessageService;
import com.razbezhkinav.telegrambot.service.TelegramUserService;

import static com.razbezhkinav.telegrambot.command.CommandName.*;

public class CommandContainer {
    private final Command unknownCommand;
    private final ImmutableMap<String,Command> commandMap;

    public CommandContainer(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService) {
        commandMap = ImmutableMap.<String,Command>builder()
                .put(START.getName(),new StartCommand(sendBotMessageService, telegramUserService))
                .put(STOP.getName(),new StopCommand(sendBotMessageService, telegramUserService))
                .put(HELP.getName(), new HelpCommand(sendBotMessageService))
                .put(NO.getName(), new NoCommand(sendBotMessageService))
                .put(STAT.getName(), new StatCommand(sendBotMessageService, telegramUserService))
                .build();
        this.unknownCommand = new UnknownCommand(sendBotMessageService);
    }

    public Command retrieveCommand(String commandIdentifier) {
        return commandMap.getOrDefault(commandIdentifier, unknownCommand);
    }
}
