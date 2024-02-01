package info.desidia.olimpya.module;

import info.desidia.olimpya.button.CloseTicketButton;
import info.desidia.olimpya.button.ConfirmCloseTicketButton;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class ButtonInteractListener extends ListenerAdapter {

	public void onButtonInteraction(@NotNull ButtonInteractionEvent event) {
		switch (event.getButton().getId().toLowerCase()){
			case "closeticket" -> CloseTicketButton.execute(event);
			case "confirmcloseticket" -> ConfirmCloseTicketButton.execute(event);
		}

	}


}
