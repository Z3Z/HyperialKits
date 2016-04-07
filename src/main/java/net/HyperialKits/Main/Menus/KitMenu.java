package net.HyperialKits.Main.Menus;

import java.util.Arrays;

import net.HyperialKits.Main.Main;
import net.HyperialKits.Main.Utils.HashMapStorage;
import net.HyperialKits.Main.Utils.Util;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class KitMenu implements Listener{
	
	public static Inventory inv;
	
	@SuppressWarnings("unused")
	private Main plugin;
	public KitMenu(Main listener) {
		this.plugin = listener;	
	}
	
	public static void Menu(Player p){
		inv = Bukkit.createInventory(null, 45, Util.color("&3&lKit Menu"));
		Border();
		Knight();
		Archer();
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
	
	public static void Knight(){
		ItemStack knight = Util.createItem(Material.IRON_HELMET, 1, 0, Util.color("&a&lKIT KNIGHT"), Arrays.asList(Util.color(" "), Util.color("&a&lACCESS ✓")));
		inv.setItem(10, knight);
	}
	
	public static void Archer(){
		ItemStack archer = Util.createItem(Material.BOW, 1, 0, Util.color("&a&lKIT ARCHER"), Arrays.asList(Util.color(" "), Util.color("&a&lACCESS ✓")));
		inv.setItem(11, archer);
	}
	
	@EventHandler
	public void menuClickEvent(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		if(e.getInventory().getName().equals(Util.color("&3&lKit Menu"))){
			e.setCancelled(true);
			if(e.getWhoClicked() instanceof Player){
				if(!(e.getInventory() == null)){
					if(!(e.getCurrentItem() == null)){
						if(!(e.getCurrentItem().getType() == Material.AIR)){
							
							
							if(e.getCurrentItem().getType().equals(Material.STAINED_GLASS_PANE)){
								if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Util.color(" "))){
									e.setCancelled(true);
								}
							}else if(e.getCurrentItem().getType().equals(Material.IRON_HELMET)){
								if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Util.color("&a&lKIT KNIGHT"))){
									if(!(HashMapStorage.Kit.containsKey(p.getUniqueId()))){
									ItemStack helmet = Util.createItem(Material.CHAINMAIL_HELMET,1,0,Util.color("&e&lKIT KNIGHT"), null);
									ItemStack chestplate = Util.createItem(Material.CHAINMAIL_CHESTPLATE,1,0,Util.color("&e&lKIT KNIGHT"), null);
									ItemStack legs = Util.createItem(Material.CHAINMAIL_LEGGINGS,1,0,Util.color("&e&lKIT KNIGHT"), null);
									ItemStack boots = Util.createItem(Material.CHAINMAIL_BOOTS,1,0,Util.color("&e&lKIT KNIGHT"), null);
									ItemStack weapon = Util.createItem(Material.IRON_SWORD,1,0,Util.color("&e&lKIT KNIGHT"), null);
									ItemStack buff = Util.createItem(Material.GOLDEN_APPLE,3,1,Util.color("&e&lKIT KNIGHT"), null);
									ItemStack kitselector = Util.createItem(Material.CHEST,1,0,Util.color("&c&lKit Selector &8- &7&lRight Click"), Arrays.asList(Util.color(" "), Util.color("&7Use this to select your kits!")));
									p.getInventory().remove(kitselector);
									p.getInventory().addItem(buff);
									p.getInventory().addItem(weapon);
									p.getInventory().setHelmet(helmet);
									p.getInventory().setChestplate(chestplate);
									p.getInventory().setLeggings(legs);
									p.getInventory().setBoots(boots);
									HashMapStorage.Kit.put(p.getUniqueId(), "Kit");
									e.setCancelled(true);
									}else if(HashMapStorage.Kit.containsKey(p.getUniqueId())){
										p.sendMessage(Util.color("&c&lYou may only have one kit per life!"));
										e.setCancelled(true);
									}
								}
							}else if(e.getCurrentItem().getType().equals(Material.BOW)){
								if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Util.color("&a&lKIT ARCHER"))){
									if(!(HashMapStorage.Kit.containsKey(p.getUniqueId()))){
									ItemStack helmet = Util.createItem(Material.IRON_HELMET,1,0,Util.color("&e&lKIT ARCHER"), null);
									ItemStack chestplate = Util.createItem(Material.IRON_CHESTPLATE,1,0,Util.color("&e&lKIT ARCHER"), null);
									ItemStack legs = Util.createItem(Material.IRON_LEGGINGS,1,0,Util.color("&e&lKIT ARCHER"), null);
									ItemStack boots = Util.createItem(Material.IRON_BOOTS,1,0,Util.color("&e&lKIT ARCHER"), null);
									ItemStack weapon = Util.createItem(Material.BOW,1,0,Util.color("&e&lKIT ARCHER"), null);
									ItemStack buff = Util.createItem(Material.GOLDEN_APPLE,3,1,Util.color("&e&lKIT ARCHER"), null);
									ItemStack arrow = Util.createItem(Material.ARROW,1,0,Util.color("&e&lKIT ARCHER"), null);
									ItemStack kitselector = Util.createItem(Material.CHEST,1,0,Util.color("&c&lKit Selector &8- &7&lRight Click"), Arrays.asList(Util.color(" "), Util.color("&7Use this to select your kits!")));
									p.getInventory().remove(kitselector);
									weapon.addEnchantment(Enchantment.ARROW_INFINITE, 1);
									p.getInventory().addItem(arrow);
									p.getInventory().addItem(buff);
									p.getInventory().addItem(weapon);
									p.getInventory().setHelmet(helmet);
									p.getInventory().setChestplate(chestplate);
									p.getInventory().setLeggings(legs);
									p.getInventory().setBoots(boots);
									HashMapStorage.Kit.put(p.getUniqueId(), "Kit");
									e.setCancelled(true);
									}else if(HashMapStorage.Kit.containsKey(p.getUniqueId())){
										p.sendMessage(Util.color("&c&lYou may only have one kit per life!"));
										e.setCancelled(true);
									}
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
