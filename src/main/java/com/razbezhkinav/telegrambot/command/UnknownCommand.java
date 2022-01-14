package com.razbezhkinav.telegrambot.command;

import com.razbezhkinav.telegrambot.service.SendBotMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.objects.Update;

public class UnknownCommand implements Command{
    private final SendBotMessageService service;

    public static final String UNKNOWN_MESSAGE = "Неизвестная команда. \n"
            + "список доступных команд - /help ";

    @Autowired
    public UnknownCommand(SendBotMessageService service) {
        this.service = service;
    }

    @Override
    public void execute(Update update) {
        service.sendMessage(update.getMessage().getChatId().toString(), UNKNOWN_MESSAGE);
    }

}
