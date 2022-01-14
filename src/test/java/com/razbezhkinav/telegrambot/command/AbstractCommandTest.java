package com.razbezhkinav.telegrambot.command;

import com.razbezhkinav.telegrambot.bot.TelegramBot;
import com.razbezhkinav.telegrambot.service.SendBotMessageService;
import com.razbezhkinav.telegrambot.service.SendBotMessageServiceImpl;
import com.razbezhkinav.telegrambot.service.TelegramUserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 * Абстрактный класс для тестирования команд: START,STOP,NO,HELP
 */
abstract class AbstractCommandTest {

    protected TelegramBot telegramBot = Mockito.mock(TelegramBot.class);

    protected SendBotMessageService sendBotMessageService = new SendBotMessageServiceImpl(telegramBot);

    protected TelegramUserService telegramUserService = Mockito.mock(TelegramUserService.class);

    abstract String getCommandName();

    abstract String getCommandMessage();

    abstract Command getCommand();

    @Test
    public void shouldProperlyExecuteCommand() throws TelegramApiException {
        Long chatId = 12345L;
        Update update = new Update();
        Message message = Mockito.mock(Message.class);
        Mockito.when(message.getChatId()).thenReturn(chatId);
        Mockito.when(message.getText()).thenReturn(getCommandName());
        update.setMessage(message);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId.toString());
        sendMessage.setText(getCommandMessage());
        sendMessage.enableHtml(true);

        getCommand().execute(update);

        Mockito.verify(telegramBot).execute(sendMessage);
    }
}
