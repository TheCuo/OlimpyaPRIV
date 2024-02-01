package info.desidia.olimpya.command;

import info.desidia.olimpya.selectmenu.SelectMenu;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

import java.awt.*;

import static net.dv8tion.jda.api.Permission.ADMINISTRATOR;

public class TicketEmbedCommand {
	public static void execute(SlashCommandInteractionEvent event) {

		Member member = event.getMember();
		assert member == null;

		if (member.getPermissions().contains(ADMINISTRATOR)) {
			EmbedBuilder embedBuilder = new EmbedBuilder();
			embedBuilder.setTitle("Servicio de Atención y Soporte de Desidia Network");
			embedBuilder.setDescription("Cuéntanos en que podemos ayudarte, y el equipo de soporte estará contigo lo antes posible.");
			embedBuilder.setColor(Color.CYAN);
			embedBuilder.setFooter("Desidia Network Team");
			event.getChannel().sendMessageEmbeds(embedBuilder.build()).setActionRow(SelectMenu.ticketselect()).queue();
			event.reply("¡El menú se ha creado!");

			return;
		}
		event.reply("No tienes permiso para hacer esto.");

	}

}
