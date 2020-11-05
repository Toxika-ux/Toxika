/*
* principal arquivo, aqui eu controlo meu bot de forma geral
* também uso esse arquivo para declarar variáveis globais "public static JDA jda;" é um exemplo
*/

package main;

import javax.security.auth.login.LoginException;

import main.commands.Clear;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

public class main 
{
	public static JDA jda;
	public static String prefix = "!";
	  public static void main(String[] args) throws LoginException
	  {
	         @SuppressWarnings("unused")
		 JDA builder = JDABuilder.createDefault("NzczNTE0MzE3MDQ3Mzk4NDYw.X6KVWA.tYR7VBgiN5JmyQc2kF4czX1IY10")	// Não, esse não é o meu token real.
	         .setActivity(Activity.playing("a"))
	         .addEventListeners(new Commands())
	         .addEventListeners(new Clear())
	         .build();      
	   }
	}
