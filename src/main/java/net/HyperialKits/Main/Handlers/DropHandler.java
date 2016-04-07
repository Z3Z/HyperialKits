package net.HyperialKits.Main.Handlers;

import net.HyperialKits.Main.Main;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class DropHandler implements Listener{
	
	@SuppressWarnings("unused")
	private Main plugin;

	public DropHandler(Main hub) {
		this.plugin = hub;
	}
	
	@EventHandler
	public void onDrop(PlayerDropItemEvent e){
			e.setCancelled(true);
	}

}
