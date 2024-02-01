package info.desidia.olimpya.module;

import info.desidia.olimpya.selectmenu.option.ReportOption;
import info.desidia.olimpya.selectmenu.option.SupportOption;
import net.dv8tion.jda.api.events.interaction.component.StringSelectInteractionEvent;

public class TicketSelectSelectMenu {
	public static void execute(StringSelectInteractionEvent event) {
		switch (event.getValues().get(0).toLowerCase()) {
			case "Soporte" -> SupportOption.execute(event);
			case "Reporte" -> ReportOption.execute(event);
			default -> event.reply("Este menú de selección no existe").setEphemeral(true).queue();

		}
	}
}
