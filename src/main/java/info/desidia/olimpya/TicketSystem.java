package info.desidia.olimpya;

import info.desidia.olimpya.module.ButtonInteractListener;
import info.desidia.olimpya.module.SelectMenuInteractListener;
import info.desidia.olimpya.module.SlashCommandInteractListener;
import info.desidia.olimpya.util.SecretUtil;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

public class TicketSystem {

	public static JDA jda;

	public static void main(String[] args) {

	jda = JDABuilder.createDefault(SecretUtil.getToken())
			.disableCache(CacheFlag.EMOJI, CacheFlag.STICKER, CacheFlag.VOICE_STATE)
			.setStatus(OnlineStatus.ONLINE)
			.setActivity(Activity.playing("Desidia Network"))
			.addEventListeners(new ButtonInteractListener())
			.addEventListeners(new SelectMenuInteractListener())
			.addEventListeners(new SlashCommandInteractListener())



			.build();
		CommandListUpdateAction commands = jda.updateCommands();
		commands.addCommands(
				Commands.slash("ticketembed", "Envía el embed del servicio de soporte")
		).queue();


	}

	public static JDA getJda() {

		return jda;
	}

}
