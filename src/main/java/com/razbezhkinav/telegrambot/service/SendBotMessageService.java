package com.razbezhkinav.telegrambot.service;

/**
 * Сервис для отправки сообщений черег бота
 */

public interface SendBotMessageService {

    /**
     * @param chatId - идентификатор чата
     * @param message - сообщение для отправки
     */
    void sendMessage(String chatId, String message);
}
