/*
* esse arquivo possui comandos bem basicos e simples
* eles são apenas usados por diversão, se você está tentando achar um comando mais especifico,
* tente procurar pelo arquivo individual dele na pasta "Toxika/DiscordBotYes/Toxika/src/commands"
* Se você tem alguma ideia de comando simples, me manda uma mensagem no privado.
*/

package main;

import javax.annotation.Nonnull;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Commands extends ListenerAdapter
{
	@Override
	public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event)
	{
	    Message msg = event.getMessage();
	    MessageChannel channel = event.getChannel();
	    if (msg.getContentRaw().equalsIgnoreCase(main.prefix + "test"))
	    {
	        channel.sendMessage("Ok.").queue();
    	}
	    if (msg.getContentRaw().equalsIgnoreCase(main.prefix + "ping")) 
	    {
	    	channel.sendMessage("Pong!");
    	}
	    if (msg.getContentRaw().equalsIgnoreCase(main.prefix + "QueDiaEHoje")) 
	    {
	    	channel.sendMessage("Sabado! p.s:essa mensagem está certa apenas 1/7 das vezes");
    	}
	    if (msg.getContentRaw().equalsIgnoreCase(main.prefix + "sim")) 
	    {
	    	channel.sendMessage("Não");
    	}
	    if (msg.getContentRaw().equalsIgnoreCase(main.prefix + "nao")) 
	    {
	    	channel.sendMessage("sim");
    	}
	    if (msg.getContentRaw().equalsIgnoreCase(main.prefix + "não")) 
	    {
	    	channel.sendMessage("sim");
    		}
	}
} 
