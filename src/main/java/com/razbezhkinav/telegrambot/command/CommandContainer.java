package com.razbezhkinav.telegrambot.command;

import com.google.common.collect.ImmutableMap;
import com.razbezhkinav.telegrambot.service.SendBotMessageService;

import static com.razbezhkinav.telegrambot.command.CommandName.*;

public class CommandContainer {
    private final Command unknownCommand;
    private final ImmutableMap<String,Command> commandMap;

    public CommandContainer(SendBotMessageService sendBotMessageService) {
        commandMap = ImmutableMap.<String,Command>builder()
                .put(START.getCommandName(),new StartCommand(sendBotMessageService))
                .put(STOP.getCommandName(),new StopCommand(sendBotMessageService))
                .put(HELP.getCommandName(), new HelpCommand(sendBotMessageService))
                .put(NO.getCommandName(), new NoCommand(sendBotMessageService))
                .build();
        this.unknownCommand = new UnknownCommand(sendBotMessageService);
    }

    public Command retrieveCommand(String commandIdentifier) {
        return commandMap.getOrDefault(commandIdentifier, unknownCommand);
    }
}
