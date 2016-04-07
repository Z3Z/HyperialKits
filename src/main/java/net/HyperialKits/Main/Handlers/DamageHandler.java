package net.HyperialKits.Main.Handlers;

import java.util.Arrays;

import net.HyperialKits.Main.Main;
import net.HyperialKits.Main.Currency.Coins;
import net.HyperialKits.Main.Currency.Deaths;
import net.HyperialKits.Main.Currency.Kills;
import net.HyperialKits.Main.Currency.Shards;
import net.HyperialKits.Main.Utils.HashMapStorage;
import net.HyperialKits.Main.Utils.Util;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

public class DamageHandler implements Listener {
	@SuppressWarnings("unused")
	private Main plugin;

	public DamageHandler(Main hub) {
		this.plugin = hub;
	}
	
	@EventHandler
	public void onDeath(EntityDeathEvent e){
		if(e.getEntity() instanceof Player){
			HashMapStorage.Kit.remove(e.getEntity().getUniqueId());
			if(e.getEntity().getKiller() instanceof Player){
				Player player = (Player) e.getEntity();
				Player killer = (Player) e.getEntity().getKiller();
				player.getWorld().strikeLightningEffect(player.getLocation());
				Coins.giveCoin(killer, Util.randomNum(1, 7));
				Shards.giveShard(killer, Util.randomNum(1, 3));
				Kills.giveKill(killer, 1);
				Deaths.giveDeath(player, 1);
			}
		}
	}
	
	@EventHandler
	public void onRespawn(PlayerRespawnEvent e){
		Location loc = new Location(Bukkit.getWorld("world"), 152.5, 24.5, -188.5, 90, 0);
		e.getPlayer().teleport(loc);
		e.getPlayer().setGameMode(GameMode.ADVENTURE);
		ItemStack helpmenu = Util.createItem(Material.CHEST,1,0,Util.color("&e&lHelp Menu &8- &7&lRight Click"), Arrays.asList(Util.color(" "), Util.color("&7Use this to select your kits!")));
		if(!(e.getPlayer().getInventory().contains(helpmenu))){
			e.getPlayer().getInventory().addItem(helpmenu);
		}
	}
}
