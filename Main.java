package pruebasbot;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class Main  {
	public static void main(String[] args) {
		System.out.println("Inicio");
		ApiContextInitializer.init();
		 TelegramBotsApi botsApi = new TelegramBotsApi();
		 try {
	            //botsApi.registerBot(new botdeprueba());
	            botsApi.registerBot(new Botfoto());
	          
	    		System.out.println("Registrado");

	        } catch (TelegramApiException e) {
	            e.printStackTrace();
	        }
	}
}
