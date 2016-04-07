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

public class RareWeaponHandler implements Listener {
	@SuppressWarnings("unused")
	private Main plugin;

	public RareWeaponHandler(Main hub) {
		this.plugin = hub;
	}
	
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e){
		if(e.getEntity() instanceof Player){
			if(e.getDamager() instanceof Player){
				Entity damager = (Player) e.getDamager();
				Player player = (Player) e.getEntity();
				if(player.getGameMode() == GameMode.ADVENTURE){
			    int damage = Util.randomNum(140, 170);
				Player p = (Player)damager;
				if(p.getItemInHand().getType() == Material.POTATO || p.getItemInHand().getType() == Material.COOKED_RABBIT || p.getItemInHand().getType() == Material.PORK || p.getItemInHand().getType() == Material.GOLD_SPADE || p.getItemInHand().getType() == Material.DIAMOND_HOE || p.getItemInHand().getType() == Material.GOLD_AXE || p.getItemInHand().getType() == Material.IRON_AXE || p.getItemInHand().getType() == Material.IRON_PICKAXE || p.getItemInHand().getType() == Material.FIREWORK_CHARGE || p.getItemInHand().getType() == Material.BLAZE_ROD){
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
