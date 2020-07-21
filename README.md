# telegram-java-bot-example

Example Telegram echo bot based on pengrad's java-telegram-bot-api library:
https://github.com/pengrad/java-telegram-bot-api

Copy `Config.java.sample` to `Config.java`
and edit it to include your bot token
(obtained from [@BotFather](https://core.telegram.org/bots#6-botfather))
and your chat ID(s).

Build and run:

```bash
./gradlew build
java -jar build/libs/telegram-java-bot-example-1.0.0.jar
```

