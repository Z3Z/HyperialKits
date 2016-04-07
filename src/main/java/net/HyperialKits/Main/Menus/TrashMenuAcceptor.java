package net.HyperialKits.Main.Menus;

import java.util.Arrays;

import net.HyperialKits.Main.Main;
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

public class TrashMenuAcceptor implements Listener{
	
	public static Inventory inv;
	
	@SuppressWarnings("unused")
	private Main plugin;
	public TrashMenuAcceptor(Main listener) {
		this.plugin = listener;	
	}
	
	public static void Menu(Player p){
		inv = Bukkit.createInventory(null, 27, Util.color("&c&lTrash Acceptor"));
		Border();
		TrashAcceptor();
		TrashDeny();
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
		inv.setItem(19, border);
		inv.setItem(20, border);
		inv.setItem(21, border);
		inv.setItem(22, border);
		inv.setItem(23, border);
		inv.setItem(24, border);
		inv.setItem(25, border);
		inv.setItem(26, border);
	}
	
	public static void TrashAcceptor(){
		ItemStack item = Util.createItem(Material.STAINED_GLASS_PANE, 1, 5, Util.color("&a&lYes!"), Arrays.asList(Util.color(" "), Util.color("&7You agree that you want to"), Util.color("&7throw stuff away and agree"), Util.color("&7that noone is liable but you for"), Util.color("&7lost items!"), Util.color(" "), Util.color("&8Click to throw items away")));
		inv.setItem(10, item);
	}
	
	public static void TrashDeny(){
		ItemStack item = Util.createItem(Material.STAINED_GLASS_PANE, 1, 14, Util.color("&c&lNo!"), Arrays.asList(Util.color(" "), Util.color("&7You are stating that you"), Util.color("&7would not like to throw"), Util.color("&7Items away and close the menu!"), Util.color(" "), Util.color("&8Click to deny the trash menu")));
		inv.setItem(16, item);
	}
	
	@EventHandler
	public void menuClickEvent(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		if(e.getInventory().getName().equals(Util.color("&c&lTrash Acceptor"))){
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
							
							if(e.getCurrentItem().getType().equals(Material.STAINED_GLASS_PANE)){
								if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Util.color("&c&lNo!"))){
									p.closeInventory();
									e.setCancelled(true);
								}
							}
							
							if(e.getCurrentItem().getType().equals(Material.STAINED_GLASS_PANE)){
								if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Util.color("&a&lYes!"))){
									TrashMenu.Menu(p);
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
