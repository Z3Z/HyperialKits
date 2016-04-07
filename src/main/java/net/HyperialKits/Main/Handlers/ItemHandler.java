package net.HyperialKits.Main.Handlers;

import net.HyperialKits.Main.Main;
import net.HyperialKits.Main.Menus.HelpMenu;
import net.HyperialKits.Main.Utils.Util;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class ItemHandler implements Listener {
	@SuppressWarnings("unused")
	private Main plugin;

	public ItemHandler(Main hub) {
		this.plugin = hub;
	}

	@EventHandler
	public void kitmenu(PlayerInteractEvent e) {
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK
				|| e.getAction() == Action.RIGHT_CLICK_AIR) {
			if (e.getPlayer().getItemInHand() != null) {
				if (e.getPlayer().getItemInHand().getType() == Material.CHEST) {
					if(e.getPlayer().getItemInHand().hasItemMeta()){
						if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equals(Util.color("&e&lHelp Menu &8- &7&lRight Click"))){
							HelpMenu.Menu(e.getPlayer());
						}
					}
				}
			}
		}
	}
}