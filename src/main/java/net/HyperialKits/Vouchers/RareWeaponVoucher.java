package net.HyperialKits.Vouchers;

import java.util.Arrays;

import net.HyperialKits.Main.Main;
import net.HyperialKits.Main.Utils.Util;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class RareWeaponVoucher implements Listener {
	@SuppressWarnings("unused")
	private Main plugin;

	public RareWeaponVoucher(Main hub) {
		this.plugin = hub;
	}
	
	@EventHandler
	public void commonVoucher(PlayerInteractEvent e) {
		int weapon = Util.randomNum(1, 10);
		ItemStack voucher = Util.createItem(Material.INK_SACK, 1, 1, Util.color("&8[&c&lCommon Voucher&8]"), null);
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK
				|| e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK) {
			if (e.getPlayer().getItemInHand() != null) {
				if (e.getPlayer().getItemInHand() == voucher) {
					if(e.getPlayer().getItemInHand().hasItemMeta()){
						if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equals(Util.color("&8[&c&lCommon Voucher&8]"))){
							if(weapon == 1){
								e.getPlayer().getInventory().addItem(Util.createItem(Material.WOOD_AXE, 1, 0, Util.color(""), Arrays.asList(Util.color(" "), Util.color("lore"))));
								e.getPlayer().getInventory().remove(voucher);
							}else if(weapon == 2){
								e.getPlayer().getInventory().addItem(Util.createItem(Material.ROTTEN_FLESH, 1, 0, Util.color(""), Arrays.asList(Util.color(" "), Util.color("lore"))));
								e.getPlayer().getInventory().remove(voucher);
							}else if(weapon == 3){
								e.getPlayer().getInventory().addItem(Util.createItem(Material.STONE_PICKAXE, 1, 0, Util.color(""), Arrays.asList(Util.color(" "), Util.color("lore"))));
								e.getPlayer().getInventory().remove(voucher);
							}else if(weapon == 4){
								e.getPlayer().getInventory().addItem(Util.createItem(Material.STONE_AXE, 1, 0, Util.color(""), Arrays.asList(Util.color(" "), Util.color("lore"))));
								e.getPlayer().getInventory().remove(voucher);
							}else if(weapon == 5){
								e.getPlayer().getInventory().addItem(Util.createItem(Material.IRON_SPADE, 1, 0, Util.color(""), Arrays.asList(Util.color(" "), Util.color("lore"))));
								e.getPlayer().getInventory().remove(voucher);
							}else if(weapon == 6){
								e.getPlayer().getInventory().addItem(Util.createItem(Material.BONE, 1, 0, Util.color(""), Arrays.asList(Util.color(" "), Util.color("lore"))));
								e.getPlayer().getInventory().remove(voucher);
							}else if(weapon == 7){
								e.getPlayer().getInventory().addItem(Util.createItem(Material.GOLD_HOE, 1, 0, Util.color(""), Arrays.asList(Util.color(" "), Util.color("lore"))));
								e.getPlayer().getInventory().remove(voucher);
							}else if(weapon == 8){
								e.getPlayer().getInventory().addItem(Util.createItem(Material.RABBIT_STEW, 1, 0, Util.color(""), Arrays.asList(Util.color(" "), Util.color("lore"))));
								e.getPlayer().getInventory().remove(voucher);
							}else if(weapon == 9){
								e.getPlayer().getInventory().addItem(Util.createItem(Material.PUMPKIN_PIE, 1, 0, Util.color(""), Arrays.asList(Util.color(" "), Util.color("lore"))));
								e.getPlayer().getInventory().remove(voucher);
							}else if(weapon == 10){
								e.getPlayer().getInventory().addItem(Util.createItem(Material.MUTTON, 1, 0, Util.color(""), Arrays.asList(Util.color(" "), Util.color("lore"))));
								e.getPlayer().getInventory().remove(voucher);
							}
						}
					}
				}
			}
		}
	}
	
	
}