package info.desidia.olimpya.module;

import net.dv8tion.jda.api.events.interaction.component.StringSelectInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class SelectMenuInteractListener extends ListenerAdapter {

	@Override
	public void onStringSelectInteraction(StringSelectInteractionEvent event) {
		switch (event.getSelectMenu().getId().toLowerCase()) {
			case "ticketselect" -> TicketSelectSelectMenu.execute(event);
			default -> event.reply("Este menú de selección no existe");


		}
	}
}
