package net.HyperialKits.Main.Handlers;

import net.HyperialKits.Main.Main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityRegainHealthEvent;

public class HealthHandler implements Listener {
	private Main plugin;

	public HealthHandler(Main hub) {
		this.plugin = hub;
	}
	
	@SuppressWarnings("deprecation")
    @EventHandler public void onJoin(EntityRegainHealthEvent event) {
		if(event.getEntity() instanceof Player){
        final Player player = (Player) event.getEntity();
        event.setCancelled(true);
        Bukkit.getScheduler().scheduleAsyncDelayedTask(plugin, new Runnable() {
            public void run() {
            	if(player.getHealth() <= 4950){
                player.setHealth(player.getHealth() + 50);       
            	}else if(player.getHealth() >= 4951){
            		player.setHealth(5000);
            	}
            }
        }, 7L);
        return;  
    }else{
    	event.setCancelled(true);
	}
		
	}

}
