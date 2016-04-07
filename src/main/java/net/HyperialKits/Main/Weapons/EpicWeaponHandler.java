package net.HyperialKits.Main.Weapons;

import net.HyperialKits.Main.Main;
import net.HyperialKits.Main.Utils.Util;

import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EpicWeaponHandler implements Listener {
	@SuppressWarnings("unused")
	private Main plugin;

	public EpicWeaponHandler(Main hub) {
		this.plugin = hub;
	}
	
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e){
		if(e.getEntity() instanceof Player){
			if(e.getDamager() instanceof Player){
				Entity damager = (Player) e.getDamager();
				Player player = (Player) e.getEntity();
				if(player.getGameMode() == GameMode.ADVENTURE){
			    int damage = Util.randomNum(170, 200);
				Player p = (Player)damager;
				if(p.getItemInHand().getType() == Material.POISONOUS_POTATO || p.getItemInHand().getType() == Material.MUSHROOM_SOUP || p.getItemInHand().getType() == Material.DIAMOND_SPADE || p.getItemInHand().getType() == Material.MELON || p.getItemInHand().getType() == Material.STRING || p.getItemInHand().getType() == Material.GRILLED_PORK || p.getItemInHand().getType() == Material.GOLD_PICKAXE || p.getItemInHand().getType() == Material.RAW_BEEF || p.getItemInHand().getType() == Material.RAW_CHICKEN || p.getItemInHand().getType() == Material.COOKED_BEEF || p.getItemInHand().getType() == Material.WOOD_SPADE || p.getItemInHand().getType() == Material.APPLE || p.getItemInHand().getType() == Material.DIAMOND_PICKAXE || p.getItemInHand().getType() == Material.WOOD_HOE || p.getItemInHand().getType() == Material.DIAMOND_AXE){
					player.damage(damage);
					player.getWorld().playEffect(player.getLocation(), Effect.STEP_SOUND, 152);
					player.sendMessage(Util.color("&a&lYou were hit by &e&l " + damager.getName() + " &a&lfor&c&l " + damage + " &a&ldamage!"));
					damager.sendMessage(Util.color("&a&lYou hit&e&l " + player.getName() + " &a&lfor&c&l " + damage + " &a&ldamage!"));
				}
				}else{
					e.setCancelled(true);
				}
			}
		}
	}
}
