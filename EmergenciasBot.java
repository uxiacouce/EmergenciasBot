package pruebasbot;

import java.util.*;

import org.telegram.telegrambots.api.methods.send.SendLocation;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.send.SendPhoto;
import org.telegram.telegrambots.api.objects.PhotoSize;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.*;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.api.objects.*;
import org.telegram.telegrambots.api.*;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import com.vdurmont.emoji.EmojiParser;
public class EmergenciasBot extends TelegramLongPollingBot {
	String oldMessage="";
	String name;
	
	HashMap<Long, String> messagesOld=new HashMap<>();
	@Override
	public String getBotUsername() {
		// TODO Auto-generated method stub
		return "Botfoto";
	}

	@Override
	public void onUpdateReceived(Update update) {
		// TODO Auto-generated method stub
		if (update.hasMessage() && update.getMessage().hasText()) {

			String message_text = update.getMessage().getText();
			long chat_id = update.getMessage().getChatId();
			String oldMessage=messagesOld.get(chat_id);
			System.out.println(message_text);
			System.out.println(oldMessage);
			if (message_text.equals("/start") || message_text.equals("Hola")) {
				SendMessage message = new SendMessage().setChatId(chat_id)
						.setText("Hola,estoy diseñado para ayudarte en caso de emergencia!Espero serte de gran ayuda");
				SendMessage message1 = new SendMessage().setChatId(chat_id).setText("MENU:");
				ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
				List<KeyboardRow> keyboard = new ArrayList<>();
				KeyboardRow row = new KeyboardRow();
				row.add(EmojiParser.parseToUnicode("QUEMADURA :fire:"));
				row.add(EmojiParser.parseToUnicode("INFARTO :no_mouth:"));
				row.add(EmojiParser.parseToUnicode("PC :heart:"));
				keyboard.add(row);
				KeyboardRow row2 = new KeyboardRow();

				row2.add(EmojiParser.parseToUnicode("CRISIS EPILEPSICA"));
				row2.add(EmojiParser.parseToUnicode("INTOXICACION :mask:"));
				row2.add(EmojiParser.parseToUnicode("HEMORRAGIA :syringe:"));
				keyboard.add(row2);
				keyboardMarkup.setKeyboard(keyboard);
				message1.setReplyMarkup(keyboardMarkup);
			

				try {
					execute(message);
					execute(message1);

				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			} 
			else if (message_text.equals("menu")) {
				oldMessage="";
				SendMessage message = new SendMessage().setChatId(chat_id).setText("MENU:");
				ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
				List<KeyboardRow> keyboard = new ArrayList<>();
				KeyboardRow row = new KeyboardRow();
				row.add(EmojiParser.parseToUnicode("QUEMADURA :fire:"));
				row.add(EmojiParser.parseToUnicode("INFARTO :no_mouth:"));
				row.add(EmojiParser.parseToUnicode("PC :heart:"));
				keyboard.add(row);
				KeyboardRow row2 = new KeyboardRow();

				row2.add(EmojiParser.parseToUnicode("CRISIS EPILEPSICA"));
				row2.add(EmojiParser.parseToUnicode("INTOXICACION :mask:"));
				row2.add(EmojiParser.parseToUnicode("HEMORRAGIA :syringe:"));
				keyboard.add(row2);
				keyboardMarkup.setKeyboard(keyboard);
				message.setReplyMarkup(keyboardMarkup);
				try {
					execute(message);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			} else if (message_text.equals(EmojiParser.parseToUnicode("QUEMADURA :fire:"))) {

				SendMessage message = new SendMessage().setChatId(chat_id).setText("MENU QUEMADURA:");
				ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
				List<KeyboardRow> keyboard = new ArrayList<>();
				KeyboardRow row = new KeyboardRow();
				row.add("QUIMICA");
				row.add("ELECTRICA");
				row.add("TERMICA");
				keyboard.add(row);
				keyboardMarkup.setKeyboard(keyboard).setResizeKeyboard(true);
				message.setReplyMarkup(keyboardMarkup);
				try {
					execute(message);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}}
		
			
				
			else if (message_text.equals(EmojiParser.parseToUnicode("INFARTO :no_mouth:"))) {
				SendMessage message6 = new SendMessage().setChatId(chat_id)
						.setText("Procure que la persona se siente, descanse y trate de mantener la calma.");
				SendMessage message = new SendMessage().setChatId(chat_id)
						.setText("Afloje cualquier prenda de vestir ajustada.");

				SendMessage message1 = new SendMessage().setChatId(chat_id).setText(
						"Pregúntele si toma medicamentos para el dolor torácico (pecho), como nitroglicerina, por una enfermedad cardíaca conocida");
				ReplyKeyboardMarkup keyboardMarkup = truefalse();
				message.setReplyMarkup(keyboardMarkup);
				try {
					execute(message6);
					execute(message);
					execute(message1);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}

			} 
			else if (message_text.equals(EmojiParser.parseToUnicode("PC :heart:"))){
				SendMessage message = new SendMessage().setChatId(chat_id).setText("Llame al 112 y observe su respiración");
				ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
				List<KeyboardRow> keyboard = new ArrayList<>();
				KeyboardRow row = new KeyboardRow();
				row.add("ausente");
				row.add("respira");
				keyboard.add(row);
				keyboardMarkup.setKeyboard(keyboard).setResizeKeyboard(true);
				message.setReplyMarkup(keyboardMarkup);
				try {
					execute(message);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}	
			}
			else if (message_text.equals("CRISIS EPILEPSICA")){
				SendMessage message = new SendMessage().setChatId(chat_id).setText("Proteja.Trate de evitar una caída. Coloque a la persona en el suelo en una zona segura. Despeje el área de muebles u otros objetos punzantes.");
				SendMessage message1 = new SendMessage().setChatId(chat_id).setText("Afloje la ropa apretada, especialmente alrededor del cuello.");
				SendMessage message2 = new SendMessage().setChatId(chat_id).setText("Coloque a la persona en posicion lateral de seguridad , esto puede evitatr que se atragante con el vomito");
				SendPhoto foto1 = new SendPhoto().setChatId(chat_id)
						.setPhoto("AgADBAADd6wxGyBW6VCDcyyRUxBTwmFJ9RkABFPXOzdL8kUiNS4DAAEC").setCaption("Posicion lateral de seguridad");
				SendMessage message3 = new SendMessage().setChatId(chat_id).setText("Sigue consciente y respira?");
				ReplyKeyboardMarkup keyboardMarkup = truefalse();
				message3.setReplyMarkup(keyboardMarkup);
				try {
					execute(message);
					execute(message1);
					execute(message2);
					sendPhoto(foto1);
					execute(message3);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}	
		}
			else if (message_text.equals(EmojiParser.parseToUnicode("INTOXICACION :mask:"))){
				SendMessage message = new SendMessage().setChatId(chat_id).setText("Identifique la causa:");
				SendMessage message2 = new SendMessage().setChatId(chat_id).setText("En caso de duda llame al 91 562 04 20");
				SendMessage message3 = new SendMessage().setChatId(chat_id).setText("Posteriormente llame al 112 para que acudan a ayudarle");
				ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
				List<KeyboardRow> keyboard = new ArrayList<>();
				KeyboardRow row = new KeyboardRow();
				row.add(("Ingestion"));
				row.add(("Inhalacion"));
				row.add(("Via cutanea"));
				row.add(("Intravenosa"));
				keyboard.add(row);
				keyboardMarkup.setKeyboard(keyboard);
				message.setReplyMarkup(keyboardMarkup);
				try {
					execute(message);
					execute(message2);
					execute(message3);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			}
			else if (message_text.equals(EmojiParser.parseToUnicode("HEMORRAGIA :syringe:"))){
				SendMessage message1 = new SendMessage().setChatId(chat_id).setText("Tumbar al accidentado en posicion horizontal");
				SendMessage message = new SendMessage().setChatId(chat_id).setText("Tipo:");
				ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
				List<KeyboardRow> keyboard = new ArrayList<>();
				KeyboardRow row = new KeyboardRow();
				row.add("EXTERNA");
				row.add("INTERNA");
				keyboard.add(row);
				keyboardMarkup.setKeyboard(keyboard).setResizeKeyboard(true);
				message.setReplyMarkup(keyboardMarkup);
				try {
					execute(message1);
					execute(message);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			}

			else if (message_text.equals("cerrar")) {
				SendMessage msg = new SendMessage().setChatId(chat_id).setText("MENU CERRADO");
				ReplyKeyboardRemove keyboardMarkup = new ReplyKeyboardRemove();
				msg.setReplyMarkup(keyboardMarkup);
				SendMessage message = new SendMessage().setChatId(chat_id).setText("Seria de gran utilidad que nos puntuase");
				ReplyKeyboardMarkup keyboardMarkup2 = new ReplyKeyboardMarkup();
				List<KeyboardRow> keyboard1 = new ArrayList<>();
				KeyboardRow row1 = new KeyboardRow();
				row1.add(EmojiParser.parseToUnicode("Rate me :100:"));
				keyboard1.add(row1);
				keyboardMarkup2.setKeyboard(keyboard1);
				message.setReplyMarkup(keyboardMarkup2);
				try {
					execute(msg);
					execute(message);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			}
			else if (message_text.equals(EmojiParser.parseToUnicode("Rate me :100:"))){
				SendMessage message = new SendMessage().setChatId(chat_id).setText("@storebot");
				SendMessage message1 = new SendMessage().setChatId(chat_id).setText("https://telegram.me/storebot?start=yyyy_uxibot ");
				SendMessage msg = new SendMessage().setChatId(chat_id).setText("MENU CERRADO");
				ReplyKeyboardRemove keyboardMarkup = new ReplyKeyboardRemove();
				msg.setReplyMarkup(keyboardMarkup);
				try {
					execute(message);
					execute(message1);
					execute(msg);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			}

			else {
				if (oldMessage.equals(EmojiParser.parseToUnicode("QUEMADURA :fire:")) && message_text.equals("QUIMICA")){
					SendMessage message1 = new SendMessage().setChatId(chat_id)
							.setText("Llame all telefono de emergencias para ser atendido, #112");
					try {
						execute(message1);
					} catch (TelegramApiException e) {
						e.printStackTrace();
					} menu(chat_id);
				}
				else if (oldMessage.equals(EmojiParser.parseToUnicode("QUEMADURA :fire:")) && message_text.equals("TERMICA")){
					SendMessage message1 = new SendMessage().setChatId(chat_id).setText("Hay ruptura de piel?");
					ReplyKeyboardMarkup keyboardMarkup1 = truefalse();
					message1.setReplyMarkup(keyboardMarkup1);
					try {
						execute(message1);
					} catch (TelegramApiException e) {
						e.printStackTrace();
					}

				} else if (message_text.equals("si") && oldMessage.equals("TERMICA")) {
					SendMessage message1 = new SendMessage().setChatId(chat_id).setText("llame al 112 para ser atendido");
					try {
						execute(message1);
					} catch (TelegramApiException e) {
						e.printStackTrace();
					} menu(chat_id);
				} else if (message_text.equals("no") && oldMessage.equals("TERMICA")) {
					SendMessage message1 = new SendMessage().setChatId(chat_id)
							.setText("Deje correr agua fría sobre la zona de la quemadura o sumerja la zona en agua fría "
									+ "(no helada). Mantenga la zona en el agua durante al menos 5 minutos."
									+ " Una toalla limpia, húmeda y fría también ayuda a reducir el dolor.");
					try {
						execute(message1);
					} catch (TelegramApiException e) {
						e.printStackTrace();
					} menu(chat_id);
				}
				else if (oldMessage.equals(EmojiParser.parseToUnicode("QUEMADURA :fire:")) && message_text.equals("ELECTRICA")){
					SendMessage messag = new SendMessage().setChatId(chat_id)
							.setText("NO toque directamente a la víctima. Utilice un objeto no metálico "
									+ "para alejar a la persona de cables expuestos antes de comenzar a administrar los primeros auxilios.");
					SendMessage message1 = new SendMessage().setChatId(chat_id)
							.setText("Llame al 112 para que acudan a ayudarle");
					//SendLocation location = new SendLocation().setChatId(chat_id);
					SendMessage message2 = new SendMessage().setChatId(chat_id)
							.setText("Acuéstela horizontalmente y levántele los pies unos 30 centímetros.");
					SendMessage message3 = new SendMessage().setChatId(chat_id).setText("Cúbrala con una manta o abrigo..");
					SendMessage message4 = new SendMessage().setChatId(chat_id)
							.setText("La persona esta consciente y respira?");
					
					ReplyKeyboardMarkup keybordmakeup = truefalse();
					message4.setReplyMarkup(keybordmakeup);
				
					try {
						execute(messag);
						execute(message1);
						
						execute(message2);
						execute(message3);
						execute(message4);
						
					} catch (TelegramApiException e) {
						e.printStackTrace();
					}
				} else if (message_text.equals("si") && (oldMessage.equalsIgnoreCase("ELECTRICA") || oldMessage.equals("si") || oldMessage.equals("Inhalacion") || oldMessage.equals("Intravenosa") || oldMessage.equals("INTERNA") || oldMessage.equals("CRISIS EPILEPSICA"))) {
					SendMessage message7 = new SendMessage().setChatId(chat_id)
							.setText("Continue vigilando los parametros hasta que lleguen los servicios de emergencia");
					SendMessage message = new SendMessage().setChatId(chat_id)
							.setText("Quiere volver al menu principal?");
					ReplyKeyboardMarkup keybordmakeup = new ReplyKeyboardMarkup();
					List<KeyboardRow> keyboard1 = new ArrayList<>();
					KeyboardRow row1 = new KeyboardRow();
					row1.add("menu");
					row1.add("cerrar");
					keyboard1.add(row1);
					keybordmakeup.setKeyboard(keyboard1);
					message.setReplyMarkup(keybordmakeup);
					try {
						execute(message7);
						execute(message);
					} catch (TelegramApiException e) {
						e.printStackTrace();
					}
				} 

				else if (message_text.equals("no") && (oldMessage.equals("ELECTRICA") || oldMessage.equals("no") || oldMessage.equals("Inhalacion") || oldMessage.equals("Intravenosa") || oldMessage.equals("INTERNA") || oldMessage.equals("CRISIS EPILEPSICA"))) {
					SendMessage message6 = new SendMessage().setChatId(chat_id).setText(
							"Comience la maniobra de rcp como le indica en la imagen hasta que lleguen los servicios de emergencia");
					SendPhoto foto1 = new SendPhoto().setChatId(chat_id)
							.setPhoto("AgADBAADYqoxG8PGwVMFA5MtdzWCbcrW-RkABEkkFUTtTpEsjpoCAAEC").setCaption("RCP");
					
					try {
						sendPhoto(foto1);
					} catch (TelegramApiException e) {
						e.printStackTrace();
					}
					try {
						execute(message6);
					} catch (TelegramApiException e) {
						e.printStackTrace();
					}
					menu(chat_id);
				}
				else if (message_text.equals("si") && oldMessage.equals(EmojiParser.parseToUnicode("INFARTO :no_mouth:"))) {
					SendMessage message7 = new SendMessage().setChatId(chat_id)
							.setText("Si el dolor no desaparece rápidamente con el reposo o"
									+ " al cabo de 3 minutos después de haber tomado la nitroglicerina, solicite ayuda médica urgente.");
					try {
						execute(message7);
					} catch (TelegramApiException e) {
						e.printStackTrace();
					} menu(chat_id);
				} else if (message_text.equals("no") && oldMessage.equals(EmojiParser.parseToUnicode("INFARTO :no_mouth:"))) {
					SendMessage message = new SendMessage().setChatId(chat_id)
							.setText("La persona esta consciente y respira?");
					ReplyKeyboardMarkup keyboardMarkup = truefalse();
					 message.setReplyMarkup(keyboardMarkup);
					try {
						execute(message);
					} catch (TelegramApiException e) {
						e.printStackTrace();
					}}
				else if (message_text.equals("respira") && oldMessage.equals(EmojiParser.parseToUnicode("PC :heart:"))){
					SendMessage message = new SendMessage().setChatId(chat_id)
							.setText("Coloquelo en la posicion de seguridad como indica la fotografia hasta la llegada de los servicios de emergencia");
					SendPhoto foto1 = new SendPhoto().setChatId(chat_id)
							.setPhoto("AgADBAADd6wxGyBW6VCDcyyRUxBTwmFJ9RkABFPXOzdL8kUiNS4DAAEC").setCaption("Posicion lateral de seguridad");
				
					try {
						execute(message);
						sendPhoto(foto1);
					} catch (TelegramApiException e) {
						e.printStackTrace();
					} menu(chat_id);
				}
				else if (message_text.equals("ausente") && oldMessage.equals(EmojiParser.parseToUnicode("PC :heart:"))){
					SendMessage message = new SendMessage().setChatId(chat_id).setText("Se trata de un:");
					ReplyKeyboardMarkup keyboardMarkup1 = new ReplyKeyboardMarkup();
					List<KeyboardRow> keyboard1 = new ArrayList<>();
					KeyboardRow row1 = new KeyboardRow();
					row1.add(EmojiParser.parseToUnicode(":baby:"));
					row1.add(EmojiParser.parseToUnicode(":man:"));
					keyboard1.add(row1);
					keyboardMarkup1.setKeyboard(keyboard1).setResizeKeyboard(true);
					message.setReplyMarkup(keyboardMarkup1);
					try {
						execute(message);
					} catch (TelegramApiException e) {
						e.printStackTrace();
					}
				}
				else if (message_text.equals(EmojiParser.parseToUnicode(":baby:")) && oldMessage.equals("ausente")){
					SendMessage message = new SendMessage().setChatId(chat_id)
							.setText("Comenzar con 5 insuflaciones (tapando la nariz y levantando ligeramente el menton)");
					SendMessage message1 = new SendMessage().setChatId(chat_id)
							.setText("Seguidas de 30 compresiones cargando el peso del cuerpo sobre su esternon");
					SendMessage message2 = new SendMessage().setChatId(chat_id)
							.setText("Repetir sucesivamente hasta que o bien lleguen los servicos de emergencia o bien mejore");
					try{
						execute(message);
						execute(message1);
						execute(message2);
					} catch(TelegramApiException e) {
						e.printStackTrace();
					} menu(chat_id);
				
				}
				else if (message_text.equals(EmojiParser.parseToUnicode(":man:")) && oldMessage.equals("ausente")){
					SendMessage message = new SendMessage().setChatId(chat_id)
							.setText("Comenzar con  30 compresiones cargando el peso del cuerpo sobre su esternon");
					SendMessage message1 = new SendMessage().setChatId(chat_id)
							.setText("Seguidas de 2 insuflaciones (tapando la nariz y levantando ligeramente el menton)");
					SendMessage message2 = new SendMessage().setChatId(chat_id)
							.setText("Repetir sucesivamente hasta que o bien lleguen los servicos de emergencia o bien mejore");
					try{
						execute(message);
						execute(message1);
						execute(message2);
					} catch(TelegramApiException e) {
						e.printStackTrace();
					} menu(chat_id);
				}
				else if (oldMessage.equals(EmojiParser.parseToUnicode("INTOXICACION :mask:")) && message_text.equals("Ingestion")){
					SendMessage message1 = new SendMessage().setChatId(chat_id)
							.setText("identifique la sustancia y estime la cantidad ingerida.");
					SendMessage message = new SendMessage().setChatId(chat_id)
							.setText("Si el afectado vomita, limpiar el vómito procurando que no entre en contacto con la piel.Si se ha manchado las ropas, limpiarle y cambiarle.");
					SendMessage message2 = new SendMessage().setChatId(chat_id)
							.setText("Mantener a la persona cómoda y vigilada hasta que lleguen los servicios de emergencia");
					try{
						execute(message);
						execute(message1);
						execute(message2);
					} catch(TelegramApiException e) {
						e.printStackTrace();
					} menu(chat_id);
				}
				else if (oldMessage.equals(EmojiParser.parseToUnicode("INTOXICACION :mask:")) && message_text.equals("Inhalacion")){
					SendMessage message1 = new SendMessage().setChatId(chat_id)
							.setText("Retirar a la persona del foco de intoxicación, airear si es una habitación. Para ello asegúrese sobre todo de su propia seguridad. "
									+ "Tome aire y contenga la respiración. Use mascarillas, o pedazos de tela en la boca y la nariz.");
					SendMessage message = new SendMessage().setChatId(chat_id)
							.setText("La persona esta consciente y respira?");
					ReplyKeyboardMarkup keyboardMarkup = truefalse();
					 message.setReplyMarkup(keyboardMarkup);
					try {
						execute(message1);
						execute(message);
					} catch (TelegramApiException e) {
						e.printStackTrace();
					}
				}
				else if (oldMessage.equals(EmojiParser.parseToUnicode("INTOXICACION :mask:")) && message_text.equals("Via cutanea")){
					SendMessage message = new SendMessage().setChatId(chat_id)
							.setText("Se trata de una picadura o mordedura?");
					ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
					List<KeyboardRow> keyboard = new ArrayList<>();
					KeyboardRow row = new KeyboardRow();
					row.add("si");
					row.add("otros");
					keyboard.add(row);
					keyboardMarkup.setKeyboard(keyboard).setResizeKeyboard(true);
					message.setReplyMarkup(keyboardMarkup);
					try {
						execute(message);
					} catch (TelegramApiException e) {
						e.printStackTrace();
					}				
					menu(chat_id);
					
				}
				else if (oldMessage.equals("Via cutanea") && message_text.equals("si")){
					SendMessage message = new SendMessage().setChatId(chat_id)
							.setText("lavar con agua y jabón y aplicar frío local en la zona de la mordedura para ralentizar su absorción.");
					SendMessage message1 = new SendMessage().setChatId(chat_id)
							.setText("Observar si hay restos de espinas o aguijones, y retirarlos con unas pinzas");
					try {
						execute(message);
						execute(message1);
					} catch (TelegramApiException e) {
						e.printStackTrace();
					} menu(chat_id);
				}
				else if (oldMessage.equals("Via cutanea") && message_text.equals("otros")){
					SendMessage message = new SendMessage().setChatId(chat_id)
							.setText("Retirar todo el tóxico, quitar la ropa y lavar las zonas expuestas con abundante agua."
									+ "No utilizar ningún tipo de neutralizante o antídoto.");
					try {
						execute(message);
					} catch (TelegramApiException e) {
						e.printStackTrace();
					} menu(chat_id);
				}
				else if (oldMessage.equals(EmojiParser.parseToUnicode("INTOXICACION :mask:")) && message_text.equals("Intravenosa")){
					SendMessage message = new SendMessage().setChatId(chat_id)
							.setText("atención médica de urgencias ya que la única manera de neutralizarla es con antídotos específicos.");
					SendMessage message1 = new SendMessage().setChatId(chat_id)
							.setText("Mientras tanto se ha de proteger a la víctima. Controlar si sigue consciente y repira");
					ReplyKeyboardMarkup keyboardMarkup = truefalse();
					 message1.setReplyMarkup(keyboardMarkup);
					try {
						execute(message);
						execute(message1);
					} catch (TelegramApiException e) {
						e.printStackTrace();
					}
				}
				else if (oldMessage.equals(EmojiParser.parseToUnicode("HEMORRAGIA :syringe:")) && message_text.equals("EXTERNA")){
					SendMessage message = new SendMessage().setChatId(chat_id)
							.setText("Compresión Directa: Aplique sobre la herida tela limpia haciendo presión fuerte. Puede ser sustituida con un vendaje de presión,");	
					try {
						execute(message);
					} catch (TelegramApiException e) {
						e.printStackTrace();
					} menu(chat_id);
				}
				else if (oldMessage.equals(EmojiParser.parseToUnicode("HEMORRAGIA :syringe:")) && message_text.equals("INTERNA")){
					SendMessage message = new SendMessage().setChatId(chat_id)
							.setText("Llamar a los servicios de emergencia #112");
					SendMessage message1 = new SendMessage().setChatId(chat_id)
							.setText("Vigilar al accidentado para detectar signos de colapso como palidez, sed, ansiedad, frío, taquicardia. y controlar respiracion y pulso");
					SendMessage message2 = new SendMessage().setChatId(chat_id)
							.setText("Sigue consciente y respira?");
					ReplyKeyboardMarkup keyboardMarkup= truefalse();
					 message2.setReplyMarkup(keyboardMarkup);
					try {
						execute(message);
						execute(message1);
						execute(message2);
					} catch (TelegramApiException e) {
						e.printStackTrace();
					}
				}
				else {SendMessage message = new SendMessage().setChatId(chat_id)
						.setText("Perdon , no lo he entendido , podrias repetirlo con otras palabras?");
				try {
					execute(message);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}menu(chat_id);}
			}
			oldMessage=message_text;
			messagesOld.put(chat_id, message_text);
		} else if (update.hasMessage() && update.getMessage().hasPhoto()) {
			long chat_id = update.getMessage().getChatId();
			List<PhotoSize> photos = update.getMessage().getPhoto();
			String f_id = photos.stream().sorted(Comparator.comparing(PhotoSize::getFileSize).reversed()).findFirst()
					.orElse(null).getFileId();
			int f_width = photos.stream().sorted(Comparator.comparing(PhotoSize::getFileSize).reversed()).findFirst()
					.orElse(null).getWidth();
			int f_height = photos.stream().sorted(Comparator.comparing(PhotoSize::getFileSize).reversed()).findFirst()
					.orElse(null).getHeight();
			String caption = "file_id: " + f_id + "\nwidth: " + Integer.toString(f_width) + "\nheight: "
					+ Integer.toString(f_height);
			SendPhoto msg = new SendPhoto().setChatId(chat_id).setPhoto(f_id).setCaption(caption);
			try {
				sendPhoto(msg);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}

		}
	}
	public ReplyKeyboardMarkup truefalse (){
		ReplyKeyboardMarkup keyboardMarkup1 = new ReplyKeyboardMarkup();
		List<KeyboardRow> keyboard1 = new ArrayList<>();
		KeyboardRow row1 = new KeyboardRow();
		row1.add("si");
		row1.add("no");
		keyboard1.add(row1);
		keyboardMarkup1.setKeyboard(keyboard1).setResizeKeyboard(true);
		return keyboardMarkup1;
	}
	public void menu(long chat_id){
		SendMessage message = new SendMessage().setChatId(chat_id)
				.setText("Si desea realizar otra consulta pulse menu:");
		ReplyKeyboardMarkup keybordmakeup = new ReplyKeyboardMarkup();
		List<KeyboardRow> keyboard1 = new ArrayList<>();
		KeyboardRow row1 = new KeyboardRow();
		row1.add("menu");
		row1.add("cerrar");
		keyboard1.add(row1);
		keybordmakeup.setKeyboard(keyboard1);
		message.setReplyMarkup(keybordmakeup);
		try {
			execute(message);
		
		}
		 catch (TelegramApiException e) {
				e.printStackTrace();
			} oldMessage="";
	}

	@Override
	public String getBotToken() {
		// TODO Auto-generated method stub
		return "420149157:AAEQADs_pksA4DFsxDTmlN26J3asde-0HYM";
	}

}
