package net.HyperialKits.Main.Handlers;

import net.HyperialKits.Main.Main;
import net.HyperialKits.Main.Menus.CoinShopMenu;
import net.HyperialKits.Main.Menus.HelpMenu;
import net.HyperialKits.Main.Menus.KitMenu;
import net.HyperialKits.Main.Menus.ProfileMenu;
import net.HyperialKits.Main.Menus.ShardShopMenu;
import net.HyperialKits.Main.Menus.TrashMenuAcceptor;
import net.HyperialKits.Main.Menus.WarpMenu;
import net.HyperialKits.Main.Utils.Packets;
import net.HyperialKits.Main.Utils.Util;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class CommandHandler implements Listener, CommandExecutor {
	
	@SuppressWarnings("unused")
	private Main plugin;

	public CommandHandler(Main hub) {
		this.plugin = hub;
	}

	public boolean onCommand(CommandSender sender, Command command,
			String alias, String[] args) {
		Player player = (Player) sender;
		if(sender.equals(player)){
		if (alias.equalsIgnoreCase("kit") || alias.equals("kits")){
			KitMenu.Menu(player);
		}
		
		if (alias.equalsIgnoreCase("shop") || alias.equals("shops")){
			if(args.length >= 2 || args.length < 1 || args.equals(null)){
				sender.sendMessage(Util.color("&4&lERROR &8>> &cThe command is /shop [coins/shards]!"));
			}else if(args[0].equalsIgnoreCase("coins")){
				CoinShopMenu.Menu(player);
			}else if(args[0].equalsIgnoreCase("shards")){
				ShardShopMenu.Menu(player);
			}else {
				sender.sendMessage(Util.color("&4&lERROR &8>> &cThe command is /shop [coins/shards]!"));
			}
		}
		
		if (alias.equalsIgnoreCase("voucher") || alias.equals("vouchers")){
			if(sender.hasPermission("hyperialkits.vouchers")){
			if(args.length >= 2 || args.length < 1 || args.equals(null)){
				sender.sendMessage(Util.color("&4&lERROR &8>> &cThe command is /voucher [common/rare/epic/legendary]!"));
			}else if(args[0].equalsIgnoreCase("common")){
				ItemStack commonvoucher = Util.createItem(Material.INK_SACK, 1, 1, Util.color("&8[&c&lCommon Voucher&8]"), null);
				player.getInventory().addItem(commonvoucher);
			}else if(args[0].equalsIgnoreCase("rare")){
				ItemStack rarevoucher = Util.createItem(Material.INK_SACK, 1, 10, Util.color("&8[&b&lRare Voucher&8]"), null);
				player.getInventory().addItem(rarevoucher);
			}else if(args[0].equalsIgnoreCase("epic")){
				ItemStack epicvoucher = Util.createItem(Material.GLOWSTONE_DUST, 1, 0, Util.color("&8[&5&lEpic Voucher&8]"), null);
				player.getInventory().addItem(epicvoucher);
			}else if(args[0].equalsIgnoreCase("legendary")){
				ItemStack legendaryvoucher = Util.createItem(Material.INK_SACK, 1, 14, Util.color("&8[&6&lLegendary Voucher&8]"), null);
				player.getInventory().addItem(legendaryvoucher);
			}else {
				sender.sendMessage(Util.color("&4&lERROR &8>> &cThe command is /voucher [common/rare/epic/legendary]!"));
			}
			}
		}
		
		
		if (alias.equalsIgnoreCase("help")){
			HelpMenu.Menu(player);
		}
		
		if (alias.equalsIgnoreCase("pack")){
			Packets.forceResourcePack(player);
		}
		
		if (alias.equalsIgnoreCase("profile")){
			ProfileMenu.Menu(player);
		}
		
		if (alias.equalsIgnoreCase("trash")){
			TrashMenuAcceptor.Menu(player);
		}
		
		if (alias.equalsIgnoreCase("warp") || alias.equals("warps")){
			WarpMenu.Menu(player);
		}
		
		if (alias.equalsIgnoreCase("pl") || alias.equals("plugins") || alias.equals("?")){
			if(sender.hasPermission("hyperialkits.plugins")){
				sender.sendMessage(Util.color(""));
			}else{
				sender.sendMessage(Util.color("&4&lERROR &8>> &cYou do not have permission for that!"));
			}
		}
		return true;
	}else{
		sender.sendMessage(Util.color("&c&lYoure not allowed to execute that command!"));
	}
		return true;
	}

}
