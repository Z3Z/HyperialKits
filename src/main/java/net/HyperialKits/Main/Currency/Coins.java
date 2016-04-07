package net.HyperialKits.Main.Currency;

import java.util.UUID;

import net.HyperialKits.Main.Main;
import net.HyperialKits.Main.Utils.HashMapStorage;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Coins implements Listener{
	
	@SuppressWarnings("unused")
	private Main plugin;
	public Coins(Main listener) {
		this.plugin = listener;		
	}
	
	public static void giveCoin(Player p, int i) {
		UUID uuid = p.getUniqueId();
		HashMapStorage.Coins.put(uuid, HashMapStorage.Coins.get(uuid) + i);
	}

	public static void takeCoin(Player p, int i) {
		UUID uuid = p.getUniqueId();
		HashMapStorage.Coins.put(uuid, HashMapStorage.Coins.get(uuid) - i);
	}

}
