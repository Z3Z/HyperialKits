package net.HyperialKits.Main.Weapons;

import net.HyperialKits.Main.Main;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class WeaponDamageHandler implements Listener {
	@SuppressWarnings("unused")
	private Main plugin;

	public WeaponDamageHandler(Main hub) {
		this.plugin = hub;
	}
	
	
	/*ItemStack item = Util.createItem(Material.GOLD_SPADE, 1, 0, "test", null);
	ItemMeta itemmeta = item.getItemMeta();
	itemmeta.spigot().setUnbreakable(true);
	item.setItemMeta(itemmeta);
	e.getPlayer().getInventory().addItem(item);
	e.getPlayer().updateInventory();*/
	
	@EventHandler
	public void onDamage(PlayerInteractEvent e){
		Player p = e.getPlayer();
		Action action = e.getAction();
		ItemStack item = p.getItemInHand();
		ItemMeta itemmeta = item.getItemMeta();
		if(action == Action.LEFT_CLICK_AIR || action == Action.LEFT_CLICK_BLOCK || action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK){
		if(p.getItemInHand().getType() == Material.POTATO || p.getItemInHand().getType() == Material.COOKED_RABBIT || p.getItemInHand().getType() == Material.PORK || p.getItemInHand().getType() == Material.GOLD_SPADE || p.getItemInHand().getType() == Material.DIAMOND_HOE || p.getItemInHand().getType() == Material.GOLD_AXE || p.getItemInHand().getType() == Material.IRON_AXE || p.getItemInHand().getType() == Material.IRON_PICKAXE || p.getItemInHand().getType() == Material.COOKED_FISH || p.getItemInHand().getType() == Material.ARROW || p.getItemInHand().getType() == Material.COOKED_CHICKEN || p.getItemInHand().getType() == Material.STONE_SPADE || p.getItemInHand().getType() == Material.WOOD_PICKAXE || p.getItemInHand().getType() == Material.BREAD || p.getItemInHand().getType() == Material.BONE || p.getItemInHand().getType() == Material.BAKED_POTATO || p.getItemInHand().getType() == Material.COOKED_MUTTON || p.getItemInHand().getType() == Material.GOLDEN_CARROT || p.getItemInHand().getType() == Material.IRON_HOE || p.getItemInHand().getType() == Material.STONE_HOE || p.getItemInHand().getType() == Material.BLAZE_ROD || p.getItemInHand().getType() == Material.STICK || p.getItemInHand().getType() == Material.WOOD_AXE || p.getItemInHand().getType() == Material.PUMPKIN_PIE || p.getItemInHand().getType() == Material.RABBIT_STEW || p.getItemInHand().getType() == Material.STONE_AXE || p.getItemInHand().getType() == Material.MUTTON || p.getItemInHand().getType() == Material.STONE_PICKAXE || p.getItemInHand().getType() == Material.ROTTEN_FLESH || p.getItemInHand().getType() == Material.GOLD_HOE || p.getItemInHand().getType() == Material.IRON_SPADE || p.getItemInHand().getType() == Material.SLIME_BALL || p.getItemInHand().getType() == Material.POISONOUS_POTATO || p.getItemInHand().getType() == Material.MUSHROOM_SOUP || p.getItemInHand().getType() == Material.DIAMOND_SPADE || p.getItemInHand().getType() == Material.MELON || p.getItemInHand().getType() == Material.STRING || p.getItemInHand().getType() == Material.GRILLED_PORK || p.getItemInHand().getType() == Material.GOLD_PICKAXE || p.getItemInHand().getType() == Material.RAW_BEEF || p.getItemInHand().getType() == Material.RAW_CHICKEN || p.getItemInHand().getType() == Material.COOKED_BEEF || p.getItemInHand().getType() == Material.WOOD_SPADE || p.getItemInHand().getType() == Material.APPLE || p.getItemInHand().getType() == Material.DIAMOND_PICKAXE || p.getItemInHand().getType() == Material.WOOD_HOE || p.getItemInHand().getType() == Material.DIAMOND_AXE || p.getItemInHand().getType() == Material.FIREWORK_CHARGE){
			if(!(itemmeta.spigot().isUnbreakable())){
				itemmeta.spigot().setUnbreakable(true);
				itemmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
				itemmeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
				item.setItemMeta(itemmeta);
				p.getInventory().remove(item);
				p.getInventory().addItem(item);
				p.updateInventory();
			}
		}
		}
	}
	
}
