package net.HyperialKits.Main.Menus;

import java.util.Arrays;

import net.HyperialKits.Main.Main;
import net.HyperialKits.Main.Utils.HashMapStorage;
import net.HyperialKits.Main.Utils.Util;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ProfileMenu implements Listener{
	
	public static Inventory inv;
	
	@SuppressWarnings("unused")
	private Main plugin;
	public ProfileMenu(Main listener) {
		this.plugin = listener;	
	}
	
	public static void Menu(Player p){
		inv = Bukkit.createInventory(null, 45, Util.color("&a&lProfile Menu"));
		Border();
		Profile(p);
		p.openInventory(inv);
	}
	
	public static void Border(){
		ItemStack border = Util.createItem(Material.STAINED_GLASS_PANE, 1, 15, Util.color(" "), null);
		inv.setItem(0, border);
		inv.setItem(1, border);
		inv.setItem(2, border);
		inv.setItem(3, border);
		inv.setItem(4, border);
		inv.setItem(5, border);
		inv.setItem(6, border);
		inv.setItem(7, border);
		inv.setItem(8, border);
		inv.setItem(9, border);
		inv.setItem(17, border);
		inv.setItem(18, border);
		inv.setItem(26, border);
		inv.setItem(27, border);
		inv.setItem(35, border);
		inv.setItem(36, border);
		inv.setItem(37, border);
		inv.setItem(38, border);
		inv.setItem(39, border);
		inv.setItem(40, border);
		inv.setItem(41, border);
		inv.setItem(42, border);
		inv.setItem(43, border);
		inv.setItem(44, border);
	}
	
	public static void Profile(Player p){
		if(p.isOp() == true){
		ItemStack item = Util.createSkull(p.getName(), Util.color("&eCharacter Info"), Arrays.asList(Util.color(" "), Util.color("&7Kills: &a") + HashMapStorage.Kills.get(p.getUniqueId()).toString(), Util.color("&7Coins: &e") + HashMapStorage.Coins.get(p.getUniqueId()).toString(), Util.color("&7Shards: &5") + HashMapStorage.Shards.get(p.getUniqueId()).toString(), Util.color("&7Deaths: &c") + HashMapStorage.Deaths.get(p.getUniqueId()).toString(),Util.color("&7GameMode: &6") + p.getGameMode(),  Util.color("&7IsOp: &3Yes"),Util.color(" "), Util.color("&8Click to veiw website link")));
		inv.setItem(22, item);
		}else if(p.isOp() == false){
			ItemStack item = Util.createSkull(p.getName(), Util.color("&eCharacter Info"), Arrays.asList(Util.color(" "), Util.color("&7Kills: &a") + HashMapStorage.Kills.get(p.getUniqueId()).toString(), Util.color("&7Coins: &e") + HashMapStorage.Coins.get(p.getUniqueId()).toString(), Util.color("&7Shards: &5") + HashMapStorage.Shards.get(p.getUniqueId()).toString(), Util.color("&7Deaths: &c") + HashMapStorage.Deaths.get(p.getUniqueId()).toString(),Util.color("&7GameMode: &6") + p.getGameMode(), Util.color("&7IsOp: &3No"),Util.color(" "), Util.color("&8Click to veiw website link")));
			inv.setItem(22, item);
		}
	}
	
	@EventHandler
	public void menuClickEvent(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		if(e.getInventory().getName().equals(Util.color("&a&lProfile Menu"))){
			e.setCancelled(true);
			if(e.getWhoClicked() instanceof Player){
				if(!(e.getInventory() == null)){
					if(!(e.getCurrentItem() == null)){
						if(!(e.getCurrentItem().getType() == Material.AIR)){
							
							
							
							
							
							
							
							if(e.getCurrentItem().getType().equals(Material.STAINED_GLASS_PANE)){
								if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Util.color(" "))){
									e.setCancelled(true);
								}
							}
							
							if(e.getCurrentItem().getType().equals(Material.SKULL_ITEM)){
								if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Util.color("&eCharacter Info"))){
									p.sendMessage(Util.color("&e&lWebsite: &7www.HyperialMC.net"));
									e.setCancelled(true);
								}
							}
							
							
						}else{
							e.setCancelled(true);
							p.playSound(p.getLocation(), Sound.ORB_PICKUP, Integer.MAX_VALUE, Integer.MAX_VALUE);
						}
					}else{
						e.setCancelled(true);
						p.playSound(p.getLocation(), Sound.ORB_PICKUP, Integer.MAX_VALUE, Integer.MAX_VALUE);
					}
				}else{
					e.setCancelled(true);
				}
			}else{
				e.setCancelled(true);
			}
		}
	}

}
