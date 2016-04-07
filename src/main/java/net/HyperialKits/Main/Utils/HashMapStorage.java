package net.HyperialKits.Main.Utils;

import java.util.HashMap;
import java.util.UUID;

import net.HyperialKits.Main.Main;

import org.bukkit.event.Listener;

public class HashMapStorage implements Listener{
	
	@SuppressWarnings("unused")
	private Main plugin;
	public HashMapStorage(Main listener) {
		this.plugin = listener;		
	}
	
	public static HashMap<UUID, Integer> Coins = new HashMap<UUID, Integer>();
	public static HashMap<UUID, Integer> Kills = new HashMap<UUID, Integer>();
	public static HashMap<UUID, Integer> Deaths = new HashMap<UUID, Integer>();
	public static HashMap<UUID, Integer> Shards = new HashMap<UUID, Integer>();
	public static HashMap<UUID, String> Kit = new HashMap<UUID, String>();
}
