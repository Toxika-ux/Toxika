/*
* Simples comando que deleta mensagens em um chat.
* ele deleta a quantidades de mensagens especificadas no argumento 1 (args[1])
* transforma em um integer e roda o comando,
* porém se o numero for maior que 100, menor que 1 ou mais antigo que uma semana, ele ira dar um erro
*/


package main.commands;

import java.util.List;

import main.main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Clear extends ListenerAdapter {
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		
		if (args[0].equalsIgnoreCase(main.prefix + "DeletarMensagens")) {
			if (args.length < 2) {
				// Usagem
				EmbedBuilder usage = new EmbedBuilder();
				usage.setColor(0xff3923);
				usage.setTitle("Por favor especifique quantas mensagens eu irei deletar:");
				usage.setDescription("Usagem: `" + main.prefix + "deletar [# mensagens]`");
				event.getChannel().sendMessage(usage.build()).queue();
			}
			else {
				try {
					List<Message> messages = event.getChannel().getHistory().retrievePast(Integer.parseInt(args[1])).complete();
					event.getChannel().deleteMessages(messages).queue();
				
					// se a operação foi um sucesso:
					EmbedBuilder success = new EmbedBuilder();
					success.setColor(0x00ff00);
					success.setTitle("✅ Sucesso ao deletar " + args[1] + " mensagens.");
					event.getChannel().sendMessage(success.build()).queue();
				}
				catch (IllegalArgumentException e) {
					if (e.toString().startsWith("java.lang.IllegalArgumentException: Message retrieval")) {
						// se a operação falhou pois o author da mensagem está tentando deletar mais do que 100:
						
						EmbedBuilder error = new EmbedBuilder();
						error.setColor(0xff0000);
						error.setTitle("🔴 Muitas mensagens selecionadas");
						error.addField("Infelizmente, o Discord apenas me deixa deletar de 1-100 mensagens de uma vez só.", "detalhes: java.lang.IllegalArgumentException: Message retrieval", false);
						event.getChannel().sendMessage(error.build()).queue();
					}
					else {
						// se as mensagens foram mais antigas que 2 semanas
						 
						EmbedBuilder error = new EmbedBuilder();
						error.setColor(0xff0000);
						error.setTitle("🔴 Mensagens que são mais velhas que 2 semanas não podem ser deletadas.");
						error.addField("Isso acontece para previnir que alguem que consiga controlar o bot destrua o servidor"+ "", "Exception", false);
						error.setFooter("P.S: isso é do discord mesmo, não é algo que posso mudar");
						event.getChannel().sendMessage(error.build()).queue();
					}
				}
			}
		}
	}
}
