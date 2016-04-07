package net.HyperialKits.Main;

import java.util.Arrays;

import net.HyperialKits.Main.Utils.Util;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerQuit implements Listener{
	
	@SuppressWarnings("unused")
	private Main plugin;
	public PlayerQuit(Main listener) {
		this.plugin = listener;		
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e){
		e.setQuitMessage(Util.color("&4&lQUIT &8» &e" + e.getPlayer().getName()));
		ItemStack kitselector = Util.createItem(Material.CHEST,600,0,Util.color("&e&lKit Selector &8- &7&lRight Click"), Arrays.asList(Util.color(" "), Util.color("&7Use this to select your kits!")));
		e.getPlayer().getInventory().removeItem(kitselector);
		e.getPlayer().setPlayerListName(Util.color(e.getPlayer().getName()));
	}

}
