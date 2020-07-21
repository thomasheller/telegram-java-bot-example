package com.github.thomasheller.telegramjavabotexample;

import com.pengrad.telegrambot.TelegramBot;

public class Main {
	public static void main(String[] args) {
		System.out.println("Starting Telegram bot");

		TelegramBot bot = new TelegramBot(Config.BOT_TOKEN);
		bot.setUpdatesListener(new BotListener(bot));
	}
}
