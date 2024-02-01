package info.desidia.olimpya.module;

import info.desidia.olimpya.command.TicketEmbedCommand;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class SlashCommandInteractListener extends ListenerAdapter {

	@Override
	public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
		switch (event.getName().toLowerCase()) {

			case "ticketembed" -> TicketEmbedCommand.execute(event);
			default -> event.reply("Este comando no existe").setEphemeral(true).queue();

		}
	}
}
