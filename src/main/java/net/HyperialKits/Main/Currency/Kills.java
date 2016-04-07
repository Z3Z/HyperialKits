package net.HyperialKits.Main.Currency;

import java.util.UUID;

import net.HyperialKits.Main.Main;
import net.HyperialKits.Main.Utils.HashMapStorage;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Kills implements Listener{
	
	@SuppressWarnings("unused")
	private Main plugin;
	public Kills(Main listener) {
		this.plugin = listener;		
	}
	
	public static void giveKill(Player p, int i) {
		UUID uuid = p.getUniqueId();
		HashMapStorage.Kills.put(uuid, HashMapStorage.Kills.get(uuid) + i);
	}

	public static void takeKill(Player p, int i) {
		UUID uuid = p.getUniqueId();
		HashMapStorage.Kills.put(uuid, HashMapStorage.Kills.get(uuid) - i);
	}

}
