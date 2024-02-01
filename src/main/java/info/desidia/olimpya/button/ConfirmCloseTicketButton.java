package info.desidia.olimpya.button;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;

import java.awt.*;
import java.util.List;

public class ConfirmCloseTicketButton {
		public static void execute(ButtonInteractionEvent event) {
			Guild guild = event.getGuild();
			Member member = event.getMember();
			List<Role> roles = event.getMember().getRoles();
			Role ticketRole = guild.getRoleById("1202235906682273834");
			if (!roles.contains(ticketRole)) {
				event.reply("No puedes cerrar este ticket.").setEphemeral(true).queue();
				return;
			}

			TextChannel textChannel = event.getChannel().asTextChannel();
			EmbedBuilder embedBuilder = new EmbedBuilder();
			embedBuilder.setTitle("Ticket");
			embedBuilder.setFooter("Desidia Network Team");
			embedBuilder.setColor(Color.CYAN);
			embedBuilder.setDescription("El ticket se ha cerrado");
			textChannel.sendMessageEmbeds(embedBuilder.build()).queue();
			String ticketType = textChannel.getName().split("-")[0];
			String channelOwner = textChannel.getName().split("-")[0];
			textChannel.getMemberPermissionOverrides().forEach(permissionOverride -> permissionOverride.delete().queue());
			switch (ticketType.toLowerCase()) {
				case "ts" -> textChannel.getManager().setName("cs-" + channelOwner).queue();
				case "tr" -> textChannel.getManager().setName("cr-" + channelOwner).queue();
				default -> textChannel.getManager().setName("c-" + channelOwner).queue();

			}
		}


}
