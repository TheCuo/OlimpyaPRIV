package info.desidia.olimpya.selectmenu;

import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.interactions.components.selections.StringSelectMenu;

public class SelectMenu {

	public static StringSelectMenu ticketselect() {
		return StringSelectMenu.create("ticketselect")

				.addOption(
						"Soporte",
						"Soporte",
						"Haz click para recibir soporte general.",
						Emoji.fromUnicode("\uD83C\uDFAB")


				)
				.addOption(
						"Reporte",
						"Reporte",
						"Haz click para reportar a alguien, sea por el motivo que sea.",
						Emoji.fromUnicode("\uD83E\uDDE7")
				)
				.build();
	}


}
