package info.desidia.olimpya.selectmenu.option;

import info.desidia.olimpya.util.TicketUtil;
import info.desidia.olimpya.util.TicketType;
import net.dv8tion.jda.api.events.interaction.component.StringSelectInteractionEvent;

public class SupportOption {

	public static void execute(StringSelectInteractionEvent event) {
		TicketUtil.open(TicketType.SUPPORT, event);



	}
}
