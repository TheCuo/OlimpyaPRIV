package info.desidia.olimpya.util;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.channel.concrete.Category;
import net.dv8tion.jda.api.events.interaction.component.StringSelectInteractionEvent;

import java.awt.*;
import java.util.EnumSet;
import java.util.List;

public class TicketUtil {

	public static void open(TicketType ticketType, StringSelectInteractionEvent event) {

	event.reply("").setEphemeral(true).queue();

	event.getInteraction().editSelectMenu(SelectMenuUtil.ticketSelect()).queue();





	Guild guild = event.getGuild();
	Member member = event.getMember();
	Category category = event.getGuild().getCategoryById("1001198936150777914");
	List<Role> roles = event.getMember().getRoles();
	Role ticketRole = guild.getRoleById("1202235906682273834");
	Role ticketLockRole = guild.getRoleById("1202426994235801680");
	EnumSet<Permission> viewChannelPermission = EnumSet.of(Permission.VIEW_CHANNEL);


		if (roles.contains(ticketRole)) {
			member.getUser().openPrivateChannel().complete().sendMessage("No puedes abrir un ticket de soporte siendo soporte. Pendejo.").queue();
					return;
		}


		if (roles.contains(ticketLockRole)) {
			member.getUser().openPrivateChannel().complete().sendMessage("Tienes un ticket bloqueado.").queue();
			return;
		}

		StringBuilder ticketTypeBuilder = new StringBuilder();
		ticketTypeBuilder.append("t");

		switch (ticketType) {
			case SUPPORT -> ticketTypeBuilder.append("s");
			case REPORT -> ticketTypeBuilder.append("r");
			default -> {
				member.getUser().openPrivateChannel().complete().sendMessage("Esta opción no puede abrir un ticket, contacta un administrador").queue();
				return;
			}
		}

		String ticketTypeString = ticketTypeBuilder.toString();

		EmbedBuilder embedBuilder = new EmbedBuilder();
		embedBuilder.setTitle("Ticket");
		embedBuilder.setColor(Color.CYAN);
		embedBuilder.setFooter("Desidia Network Team");
		embedBuilder.setDescription("Escribe en este canal, en un plazo que puede variar tendrás respuesta.");

		guild.createTextChannel(ticketTypeString + "-" + member.getId(), category)
				.addPermissionOverride(member, viewChannelPermission, null)
				.addPermissionOverride(guild.getPublicRole(), null, viewChannelPermission)
				.addPermissionOverride(ticketRole, viewChannelPermission, null)
				.complete()
				.sendMessageEmbeds(embedBuilder.build())
				.setActionRow(ButtonUtil.closeTicket())
				.queue();


	}
}
