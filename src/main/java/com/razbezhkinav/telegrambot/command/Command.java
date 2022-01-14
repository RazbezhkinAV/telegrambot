package com.razbezhkinav.telegrambot.command;

import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * Интерфейс для обработки поступающих команд
 */

public interface Command {

    void execute(Update update);
}
