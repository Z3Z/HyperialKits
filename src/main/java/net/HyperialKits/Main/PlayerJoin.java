package net.HyperialKits.Main;

import java.util.Arrays;

import net.HyperialKits.Main.Handlers.ScoreBoardHandler;
import net.HyperialKits.Main.Utils.HashMapStorage;
import net.HyperialKits.Main.Utils.Packets;
import net.HyperialKits.Main.Utils.Util;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;


public class PlayerJoin implements Listener{
	
	private Main plugin;
	public PlayerJoin(Main listener) {
		this.plugin = listener;		
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		e.setJoinMessage(Util.color("&a&lJOIN &8» &e" + e.getPlayer().getName()));
		
		p.setHealthScale(40.0);
		p.setMaxHealth(5000.0);
		if(!(p.hasPlayedBefore())){
			Bukkit.getServer().broadcastMessage(Util.color("&e&lNOTICE&8: &eWelcome &a" + p.getName() + " &eto the server! &b(&6NEW&b)"));
			p.setHealth(5000.0);
			p.setGameMode(GameMode.SURVIVAL);
			Location loc = new Location(Bukkit.getWorld("world"), 152.5, 24.5, -188.5, 90, 0);
			e.getPlayer().teleport(loc);
		}
		
		p.setGameMode(GameMode.SURVIVAL);
		
		e.getPlayer().setFoodLevel(20);
		Packets.sendTabTitle(e.getPlayer(), Util.color("&8&l«&f&l&m--&r &e&lHyperial&7&lMC &f&l&m--&8&l»"), null, null, null, null, Util.color("&8&l«&f&l&m--&r &6&lHyperialMC.Net &f&l&m--&8&l»"));
		Packets.sendTitle(e.getPlayer(), Util.color("&e&lHyperial&7&lMC"), Util.color("&8&lIN DEVELOPMENT"));
		
		Location loc = new Location(Bukkit.getWorld("world"), 152.5, 24.5, -188.5, 90, 0);
		e.getPlayer().teleport(loc);
		
		Packets.forceResourcePack(p);
		
		ScoreBoardHandler.makeScoreBoard(e.getPlayer());
		
		ItemStack helpmenu = Util.createItem(Material.CHEST,1,0,Util.color("&e&lHelp Menu &8- &7&lRight Click"), Arrays.asList(Util.color(" "), Util.color("&7Use this to warp get kits and spend currency!")));
		if(!(e.getPlayer().getInventory().contains(helpmenu))){
			e.getPlayer().getInventory().addItem(helpmenu);
		}
		
		if (!plugin.getConfig().contains(p.getUniqueId().toString())) {
			plugin.getConfig().set(p.getUniqueId() + ".Coins", 0);
			HashMapStorage.Coins.put(p.getUniqueId(), 0);
			plugin.getConfig().set(p.getUniqueId() + ".Kills", 0);
			HashMapStorage.Kills.put(p.getUniqueId(), 0);
			plugin.getConfig().set(p.getUniqueId() + ".Deaths", 0);
			HashMapStorage.Deaths.put(p.getUniqueId(), 0);
			plugin.getConfig().set(p.getUniqueId() + ".Shards", 0);
			HashMapStorage.Shards.put(p.getUniqueId(), 0);
		} else {
			HashMapStorage.Coins.put(p.getUniqueId(), plugin.getConfig().getInt(p.getUniqueId() + ".Coins"));
			HashMapStorage.Kills.put(p.getUniqueId(), plugin.getConfig().getInt(p.getUniqueId() + ".Kills"));
			HashMapStorage.Deaths.put(p.getUniqueId(), plugin.getConfig().getInt(p.getUniqueId() + ".Deaths"));
			HashMapStorage.Shards.put(p.getUniqueId(), plugin.getConfig().getInt(p.getUniqueId() + ".Shards"));
		}
	}

}
