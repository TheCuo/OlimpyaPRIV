package info.desidia.olimpya.button;

import info.desidia.olimpya.util.ButtonUtil;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;

import java.awt.*;

public class CloseTicketButton {
	public static void execute(ButtonInteractionEvent event) {

		event.getInteraction().getMessage().delete().queue();
		EmbedBuilder embedBuilder = new EmbedBuilder();
		embedBuilder.setTitle("Ticket");
		embedBuilder.setColor(Color.CYAN);
		embedBuilder.setFooter("Desidia Network Team");
		embedBuilder.setDescription("¿Estás seguro de que quieres cerrar el ticket?");
		event.getChannel().sendMessageEmbeds(embedBuilder.build()).setActionRow(ButtonUtil.confirmCloseTicket());

	}

}
