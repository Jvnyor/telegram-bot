package com.Jvnyor.telegrambot;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
public class TelegrambotApplication {

	public static void main(String[] args) {
		SpringApplication.run(TelegrambotApplication.class, args);
	}
	
	@Component
    class Bot implements ApplicationRunner {
		
        @Override
        public void run(ApplicationArguments args) throws Exception {
        	
        	try {
                TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
                botsApi.registerBot(new JvnyorBot());
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

}
