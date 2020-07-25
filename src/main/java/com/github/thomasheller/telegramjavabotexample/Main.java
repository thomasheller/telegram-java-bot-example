package com.github.thomasheller.telegramjavabotexample;

import com.pengrad.telegrambot.TelegramBot;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		ConfigParser config = new ConfigParser();
		String apiToken = config.getTelegramApiToken();
		List<Long> allowedChatIds = config.getAllowedChatIds();

		System.out.printf("Starting Telegram bot for chat ID(s): %s\n", allowedChatIds);

		TelegramBot bot = new TelegramBot(apiToken);
		BotListener listener = new BotListener(bot, allowedChatIds);
		bot.setUpdatesListener(listener);
	}
}
