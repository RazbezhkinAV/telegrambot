package com.razbezhkinav.telegrambot.command;

import com.razbezhkinav.telegrambot.service.SendBotMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StopCommand implements Command{

    private final SendBotMessageService service;

    public final static String STOP_MESSAGE = "Счастливо оставаться кожанный";

    @Autowired
    public StopCommand(SendBotMessageService service) {
        this.service = service;
    }

    @Override
    public void execute(Update update) {
        service.sendMessage(update.getMessage().getChatId().toString(),STOP_MESSAGE);
    }
}
