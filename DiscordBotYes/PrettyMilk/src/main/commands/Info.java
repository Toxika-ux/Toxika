package main.commands;

import main.main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Info extends ListenerAdapter {
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		
		if (args[0].equalsIgnoreCase(main.prefix + "info")) {
			EmbedBuilder e = new EmbedBuilder();
			e.setTitle("🍪 Informações sobre mim! 🍪");
			e.setDescription("Meu prefixo é: " + main.prefix);
			e.addField("Fui criada por @Toxik#7152", null, true);
			e.addField("Fui feita usando JDA (Java Discord API)", "Usando Eclipse IDE", true);
			e.addField("", null, true);
			event.getChannel().sendMessage(e.build()).queue();
		}
	}
}
