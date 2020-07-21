package com.github.thomasheller.telegramjavabotexample;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.request.SendSticker;
import com.pengrad.telegrambot.response.BaseResponse;
import java.util.List;

public class BotListener implements UpdatesListener {

	/*
	 * You can obtain a sticker file ID by sending a
	 * sticker to the bot and checking the file ID
	 * in the update.
	 */
	protected static final String STICKER_FILE_ID = "CAACAgEAAxkBAAILxV8QFqe_J-jRoWeJc_VVQrlZZh3qAALpAAM4DoIRsb2LbanQ7PIaBA";

	protected final TelegramBot bot;

	public BotListener(TelegramBot bot) {
		this.bot = bot;
	}

	@Override
	public int process(List<Update> updates) {
		for (Update update : updates) {
			this.processUpdate(update);
		}

		return UpdatesListener.CONFIRMED_UPDATES_ALL;
	}

	protected void processUpdate(Update update) {
		System.out.printf("New update polled: %s\n", update);

		long fromId = update.message().from().id();

		System.out.printf("Update contains message from chat ID %d\n", fromId);

		if(!Config.allowedChatIds.contains(fromId)) {
			// Discard updates from unknown chat IDs
			return;
		}

		// Send a sticker:

		this.sendSticker(fromId, BotListener.STICKER_FILE_ID);

		// Send a reply:

		this.sendReply(fromId, "☝🏻", update.message().messageId());

		// Send a simple text message:

		String answer;

		if(update.message().text() == null) {
			// Is not a text message, but a photo, sticker etc.
			answer = "You just said something I couldn't understand";
		} else {
			answer = String.format("You just said: %s", update.message().text());
		}

		this.sendTextMessage(fromId, answer);
	}

	protected void sendSticker(long chatId, String fileId) {
		SendSticker request = new SendSticker(chatId, fileId);

		this.executeRequest(request);
	}

	protected void sendReply(long chatId, String text, int messageId) {
		SendMessage request = new SendMessage(chatId, text)
			.replyToMessageId(messageId);

		this.executeRequest(request);
	}

	protected void sendTextMessage(long chatId, String text) {
		SendMessage request = new SendMessage(chatId, text);

		this.executeRequest(request);
	}

	protected void executeRequest(BaseRequest request) {
		BaseResponse response = this.bot.execute(request);

		// TODO: error handling
	}
}

