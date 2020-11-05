package main;

import javax.security.auth.login.LoginException;

import main.commands.Clear;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

public class main 
{
	//declarando variaveis importantes
	public static JDA jda;
	public static String prefix = "!";
	  public static void main(String[] args) throws LoginException
	  {
	         @SuppressWarnings("unused")
		 JDA builder = JDABuilder.createDefault("NzczNTE0MzE3MDQ3Mzk4NDYw.X6KVWA.tYR7VBgiN5JmyQc2kF4czX1IY10") //Aqui vem o token do bot para controla-lo esse não é o token que o bot usa atualmente
	         .setActivity(Activity.playing("a")) //Atualizar a "atividade" do bot para Jogando: alguma-coisa
	         .addEventListeners(new Commands())  //Aqui vem os eventListeners...
	         .addEventListeners(new Clear())     //...
	         .build();	//fim	        
	   }
	}
