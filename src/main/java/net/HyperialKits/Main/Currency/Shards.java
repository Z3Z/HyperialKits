package net.HyperialKits.Main.Currency;

import java.util.UUID;

import net.HyperialKits.Main.Main;
import net.HyperialKits.Main.Utils.HashMapStorage;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Shards implements Listener{
	
	@SuppressWarnings("unused")
	private Main plugin;
	public Shards(Main listener) {
		this.plugin = listener;		
	}
	
	public static void giveShard(Player p, int i) {
		UUID uuid = p.getUniqueId();
		HashMapStorage.Shards.put(uuid, HashMapStorage.Shards.get(uuid) + i);
	}

	public static void takeShard(Player p, int i) {
		UUID uuid = p.getUniqueId();
		HashMapStorage.Shards.put(uuid, HashMapStorage.Shards.get(uuid) - i);
	}

}
