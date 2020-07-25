# telegram-java-bot-example

Example Telegram echo bot based on pengrad's java-telegram-bot-api library:
https://github.com/pengrad/java-telegram-bot-api

Note: You need a valid Telegram ot token
(obtained from [@BotFather](https://core.telegram.org/bots#6-botfather))
and your Telegram chat ID(s).

Build and run:

```bash
./gradlew build

export TELEGRAM_API_TOKEN=1234567890:XXXX-XXXX-XXXXXXXXXXXXXXXXXXXXXXXX
export TELEGRAM_CHATIDS=123456789,987654321
java -jar build/libs/telegram-java-bot-example-1.0.0.jar
```

