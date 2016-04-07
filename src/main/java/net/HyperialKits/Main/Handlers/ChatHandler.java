package net.HyperialKits.Main.Handlers;

import java.util.ArrayList;
import java.util.List;

import net.HyperialKits.Main.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatHandler implements Listener {
	@SuppressWarnings("unused")
	private Main plugin;

	public ChatHandler(Main hub) {
		this.plugin = hub;
	}

	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		String msg = e.getMessage();

		String[] messages = msg.split(" ");
		List<String> players = new ArrayList<String>();
		for (Player p : Bukkit.getOnlinePlayers()) {
			players.add(p.getName());
		}

		for (String s : messages) {
			if (players.contains(s)) {
				e.setMessage(e.getMessage().replace(
						s,
						ChatColor.translateAlternateColorCodes('&', "&e@" + s
								+ "&r")));
				Bukkit.getPlayerExact(s).playSound(
						Bukkit.getPlayerExact(s).getLocation(),
						Sound.IRONGOLEM_DEATH, 1.0F, 1.0F);
			}
		}
	}

}
