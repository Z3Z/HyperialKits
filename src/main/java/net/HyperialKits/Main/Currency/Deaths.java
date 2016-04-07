package net.HyperialKits.Main.Currency;

import java.util.UUID;

import net.HyperialKits.Main.Main;
import net.HyperialKits.Main.Utils.HashMapStorage;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Deaths implements Listener{
	
	@SuppressWarnings("unused")
	private Main plugin;
	public Deaths(Main listener) {
		this.plugin = listener;		
	}
	
	public static void giveDeath(Player p, int i) {
		UUID uuid = p.getUniqueId();
		HashMapStorage.Deaths.put(uuid, HashMapStorage.Deaths.get(uuid) + i);
	}

	public static void takeDeath(Player p, int i) {
		UUID uuid = p.getUniqueId();
		HashMapStorage.Deaths.put(uuid, HashMapStorage.Deaths.get(uuid) - i);
	}

}
