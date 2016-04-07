package net.HyperialKits.Main.Handlers;

import net.HyperialKits.Main.Main;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class HungerHandler implements Listener{
	
	@SuppressWarnings("unused")
	private Main plugin;
	public HungerHandler(Main listener) {
		this.plugin = listener;		
	}
	
	@EventHandler
	public void noHunger(FoodLevelChangeEvent e){
		e.setCancelled(true);
	}

}
