package com.razbezhkinav.telegrambot.command;

import com.razbezhkinav.telegrambot.service.SendBotMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.razbezhkinav.telegrambot.command.CommandName.*;

public class HelpCommand implements Command {

    private final SendBotMessageService service;

    public static final String HELP_MESSAGE = String.format("✨<b>Дотупные команды</b>✨\n\n"
                    + "<b>Начать\\закончить работу с ботом</b>\n"
                    + "%s - начать работу \n"
                    + "%s - приостановить работу \n\n"
                    + "%s - получить помощь в работе \n",
            START.getCommandName(), STOP.getCommandName(), HELP.getCommandName());

    @Autowired
    public HelpCommand(SendBotMessageService service) {
        this.service = service;
    }

    @Override
    public void execute(Update update) {
        service.sendMessage(update.getMessage().getChatId().toString(), HELP_MESSAGE);
    }
}
