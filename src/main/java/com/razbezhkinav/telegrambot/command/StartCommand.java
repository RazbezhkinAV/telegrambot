package com.razbezhkinav.telegrambot.command;

import com.razbezhkinav.telegrambot.entity.TelegramUser;
import com.razbezhkinav.telegrambot.service.SendBotMessageService;
import com.razbezhkinav.telegrambot.service.TelegramUserService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StartCommand implements Command {

    private final SendBotMessageService sendBotMessageService;
    private final TelegramUserService telegramUserService;

    public static final String START_MESSAGE = "Добро пожаловать в тестовый бот";

    public StartCommand(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService) {
        this.sendBotMessageService = sendBotMessageService;
        this.telegramUserService = telegramUserService;
    }

    @Override
    public void execute(Update update) {
        String chatId = update.getMessage().getChatId().toString();

        telegramUserService.findByChatId(chatId).ifPresentOrElse(
                user -> {
                    user.setActive(true);
                    telegramUserService.save(user);
                },
                () -> {
                    TelegramUser user = new TelegramUser();
                    user.setActive(true);
                    user.setChatId(chatId);
                    telegramUserService.save(user);
                }
        );


        sendBotMessageService.sendMessage(chatId,START_MESSAGE);
    }
}
