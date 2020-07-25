package com.github.thomasheller.telegramjavabotexample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConfigParser {
	public String getTelegramApiToken() {
		return this.mustEnv("TELEGRAM_API_TOKEN");
	}

	public List<Long> getAllowedChatIds() {
		return this.parseLongList(this.mustEnv("TELEGRAM_CHATIDS"));
	}

	private String mustEnv(String key) {
		String value = System.getenv(key);

		if (value == null || value.trim().isEmpty()) {
			System.err.printf("Environment variable %s must be set\n", key);
			System.exit(1);
		}

		return value;
	}

	private List<Long> parseLongList(String value) {
		List ids = new ArrayList<Long>();

		for(String part : value.split(",")) {
			try {
				ids.add(Long.parseLong(part));
			} catch(NumberFormatException e) {
				System.err.printf("The chat ID \"%s\" must be a number", part);
				System.exit(1);
			}
		}

		return ids;
	}
}
