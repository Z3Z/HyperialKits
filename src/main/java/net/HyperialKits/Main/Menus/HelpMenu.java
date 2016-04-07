package net.HyperialKits.Main.Menus;

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

public class HelpMenu implements Listener{
	
	public static Inventory inv;
	
	@SuppressWarnings("unused")
	private Main plugin;
	public HelpMenu(Main listener) {
		this.plugin = listener;	
	}
	
	public static void Menu(Player p){
		inv = Bukkit.createInventory(null, 45, Util.color("&c&lHelp Menu"));
		Border();
		KitMenu();
		ProfileMenu(p);
		WarpMenu();
		CoinShopMenu();
		ShardShopMenu();
		TrashMenu();
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
	
	public static void KitMenu(){
		ItemStack item = Util.createItem(Material.CHEST, 1, 0, Util.color("&3&lKit Menu"), null);
		inv.setItem(11, item);
	}
	
	public static void WarpMenu(){
		ItemStack item = Util.createItem(Material.MAP, 1, 0, Util.color("&b&lWarp Menu"), null);
		inv.setItem(15, item);
	}
	
	public static void ProfileMenu(Player p){
		ItemStack item = Util.createSkull(p.getName(), Util.color("&a&lProfile Menu"), null);
		inv.setItem(21, item);
	}
	
	public static void TrashMenu(){
		ItemStack item = Util.createItem(Material.BUCKET, 1, 0, Util.color("&c&lTrash Menu"), null);
		inv.setItem(23, item);
	}
	
	public static void CoinShopMenu(){
		ItemStack item = Util.createItem(Material.DOUBLE_PLANT, 1, 0, Util.color("&6&lCoin Shop"), null);
		inv.setItem(29, item);
	}
	
	public static void ShardShopMenu(){
		ItemStack item = Util.createItem(Material.NETHER_STAR, 1, 0, Util.color("&5&lShard Shop"), null);
		inv.setItem(33, item);
	}
	
	@EventHandler
	public void menuClickEvent(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		if(e.getInventory().getName().equals(Util.color("&c&lHelp Menu"))){
			e.setCancelled(true);
			if(e.getWhoClicked() instanceof Player){
				if(!(e.getInventory() == null)){
					if(!(e.getCurrentItem() == null)){
						if(!(e.getCurrentItem().getType() == Material.AIR)){
							
							
							
							if(e.getCurrentItem().getType().equals(Material.CHEST)){
								if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Util.color("&3&lKit Menu"))){
									KitMenu.Menu(p);
									e.setCancelled(true);
								}
							}
							
							if(e.getCurrentItem().getType().equals(Material.BUCKET)){
								if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Util.color("&c&lTrash Menu"))){
									TrashMenuAcceptor.Menu(p);
									e.setCancelled(true);
								}
							}
							
							if(e.getCurrentItem().getType().equals(Material.MAP)){
								if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Util.color("&b&lWarp Menu"))){
									WarpMenu.Menu(p);
									e.setCancelled(true);
								}
							}
							
							if(e.getCurrentItem().getType().equals(Material.SKULL_ITEM)){
								if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Util.color("&a&lProfile Menu"))){
									ProfileMenu.Menu(p);
									e.setCancelled(true);
								}
							}
							
							if(e.getCurrentItem().getType().equals(Material.DOUBLE_PLANT)){
								if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Util.color("&6&lCoin Shop"))){
									CoinShopMenu.Menu(p);
									e.setCancelled(true);
								}
							}
							
							if(e.getCurrentItem().getType().equals(Material.NETHER_STAR)){
								if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Util.color("&5&lShard Shop"))){
									ShardShopMenu.Menu(p);
									e.setCancelled(true);
								}
							}
							
							
							
							
							
							if(e.getCurrentItem().getType().equals(Material.STAINED_GLASS_PANE)){
								if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Util.color(" "))){
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
