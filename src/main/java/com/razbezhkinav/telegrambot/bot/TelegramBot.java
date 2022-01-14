package com.razbezhkinav.telegrambot.bot;

import com.razbezhkinav.telegrambot.command.CommandContainer;
import com.razbezhkinav.telegrambot.service.SendBotMessageServiceImpl;
import com.razbezhkinav.telegrambot.service.TelegramUserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.razbezhkinav.telegrambot.command.CommandName.NO;

@Component
public class TelegramBot extends TelegramLongPollingBot {

    private static final String COMMAND_PREFIX = "/";
    private final CommandContainer commandContainer;

    @Value("${bot.name}")
    private String name;

    @Value("${bot.token}")
    private String token;


    public TelegramBot(TelegramUserService telegramUserService){
        this.commandContainer = new CommandContainer(new SendBotMessageServiceImpl(this),telegramUserService);
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();

            if (message.startsWith(COMMAND_PREFIX)) {
                String commandIdentifier = message.split(" ")[0].toLowerCase();
                commandContainer.retrieveCommand(commandIdentifier).execute(update);
            } else {
                commandContainer.retrieveCommand(NO.getName()).execute(update);
            }

        }
    }

    @Override
    public String getBotUsername() {
        return name;
    }

    @Override
    public String getBotToken() {
        return token;
    }
}
