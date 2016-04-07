package net.HyperialKits.Main;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.util.Map.Entry;
import java.util.UUID;

import net.HyperialKits.Main.Bungee.BUtil;
import net.HyperialKits.Main.Currency.Coins;
import net.HyperialKits.Main.Currency.Deaths;
import net.HyperialKits.Main.Currency.Kills;
import net.HyperialKits.Main.Currency.Shards;
import net.HyperialKits.Main.Handlers.BuildHandler;
import net.HyperialKits.Main.Handlers.ChatHandler;
import net.HyperialKits.Main.Handlers.CommandHandler;
import net.HyperialKits.Main.Handlers.DamageHandler;
import net.HyperialKits.Main.Handlers.DropHandler;
import net.HyperialKits.Main.Handlers.HealthHandler;
import net.HyperialKits.Main.Handlers.HungerHandler;
import net.HyperialKits.Main.Handlers.ItemHandler;
import net.HyperialKits.Main.Handlers.ScoreBoardHandler;
import net.HyperialKits.Main.Handlers.WeatherHandler;
import net.HyperialKits.Main.Menus.CoinShopMenu;
import net.HyperialKits.Main.Menus.HelpMenu;
import net.HyperialKits.Main.Menus.KitMenu;
import net.HyperialKits.Main.Menus.ProfileMenu;
import net.HyperialKits.Main.Menus.ShardShopMenu;
import net.HyperialKits.Main.Menus.TrashMenu;
import net.HyperialKits.Main.Menus.TrashMenuAcceptor;
import net.HyperialKits.Main.Menus.WarpMenu;
import net.HyperialKits.Main.Utils.HashMapStorage;
import net.HyperialKits.Main.Utils.Packets;
import net.HyperialKits.Main.Utils.Util;
import net.HyperialKits.Main.Weapons.CommonWeaponHandler;
import net.HyperialKits.Main.Weapons.EpicWeaponHandler;
import net.HyperialKits.Main.Weapons.LegendaryWeaponHandler;
import net.HyperialKits.Main.Weapons.RareWeaponHandler;
import net.HyperialKits.Main.Weapons.WeaponDamageHandler;
import net.HyperialKits.Vouchers.CommonWeaponVoucher;
import net.HyperialKits.Vouchers.EpicWeaponVoucher;
import net.HyperialKits.Vouchers.LegendaryWeaponVoucher;
import net.HyperialKits.Vouchers.RareWeaponVoucher;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

public class Main extends JavaPlugin implements Listener, PluginMessageListener{
	
	
	public static int playercount;
	public static String GetServer;
	public static String PlayerCountServer;
	
	public void onEnable(){
		final ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
		console.sendMessage(Util.color("&e&lHyperialMC &8>> &aThe kitpvp plugin has been enabled!"));
	    Bukkit.getServer().getMessenger().registerOutgoingPluginChannel(this,"BungeeCord");
	    Bukkit.getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", this);
		Listeners();
		Commands();
	}
	
	public void onDisable(){
		final ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
		console.sendMessage(Util.color("&e&lHyperialMC &8>> &cThe kitpvp plugin has been disabled!"));
		for (Entry<UUID, Integer> entry : HashMapStorage.Coins.entrySet()) {
			getConfig().set(entry.getKey() + ".Coins", entry.getValue());
		}
		
		for (Entry<UUID, Integer> entry : HashMapStorage.Kills.entrySet()) {
			getConfig().set(entry.getKey() + ".Kills", entry.getValue());
		}
		
		for (Entry<UUID, Integer> entry : HashMapStorage.Deaths.entrySet()) {
			getConfig().set(entry.getKey() + ".Deaths", entry.getValue());
		}
		
		for (Entry<UUID, Integer> entry : HashMapStorage.Shards.entrySet()) {
			getConfig().set(entry.getKey() + ".Shards", entry.getValue());
		}

		saveConfig();
	}
	
	public void Listeners(){
		PluginManager pm = Bukkit.getServer().getPluginManager();
		pm.registerEvents(new BUtil(this), this);
		pm.registerEvents(new Util(this), this);
		pm.registerEvents(new PlayerJoin(this), this);
		pm.registerEvents(new PlayerQuit(this), this);
		pm.registerEvents(new BuildHandler(this), this);
		pm.registerEvents(new ChatHandler(this), this);
		pm.registerEvents(new DamageHandler(this), this);
		pm.registerEvents(new HungerHandler(this), this);
		pm.registerEvents(new ItemHandler(this), this);
		pm.registerEvents(new KitMenu(this), this);
		pm.registerEvents(new ScoreBoardHandler(this), this);
		pm.registerEvents(new Packets(this), this);
		pm.registerEvents(new HashMapStorage(this), this);
		pm.registerEvents(new Coins(this), this);
		pm.registerEvents(new Deaths(this), this);
		pm.registerEvents(new Kills(this), this);
		pm.registerEvents(new Shards(this), this);
		pm.registerEvents(new CommandHandler(this), this);
		pm.registerEvents(new DropHandler(this), this);
		pm.registerEvents(new CommonWeaponHandler(this), this);
		pm.registerEvents(new RareWeaponHandler(this), this);
		pm.registerEvents(new EpicWeaponHandler(this), this);
		pm.registerEvents(new LegendaryWeaponHandler(this), this);
		pm.registerEvents(new WeaponDamageHandler(this), this);
		pm.registerEvents(new CoinShopMenu(this), this);
		pm.registerEvents(new ShardShopMenu(this), this);
		pm.registerEvents(new HelpMenu(this), this);
		pm.registerEvents(new WarpMenu(this), this);
		pm.registerEvents(new ProfileMenu(this), this);
		pm.registerEvents(new HealthHandler(this), this);
		pm.registerEvents(new WeatherHandler(this), this);
		pm.registerEvents(new TrashMenu(this), this);
		pm.registerEvents(new TrashMenuAcceptor(this), this);
		pm.registerEvents(new CommonWeaponVoucher(this), this);
		pm.registerEvents(new RareWeaponVoucher(this), this);
		pm.registerEvents(new EpicWeaponVoucher(this), this);
		pm.registerEvents(new LegendaryWeaponVoucher(this), this);
	}
	
	public void Commands(){
		getCommand("kits").setExecutor(new CommandHandler(this));
		getCommand("kit").setExecutor(new CommandHandler(this));
		getCommand("?").setExecutor(new CommandHandler(this));
		getCommand("pl").setExecutor(new CommandHandler(this));
		getCommand("plugins").setExecutor(new CommandHandler(this));
		getCommand("shop").setExecutor(new CommandHandler(this));
		getCommand("shops").setExecutor(new CommandHandler(this));
		getCommand("help").setExecutor(new CommandHandler(this));
		getCommand("warp").setExecutor(new CommandHandler(this));
		getCommand("warps").setExecutor(new CommandHandler(this));
		getCommand("profile").setExecutor(new CommandHandler(this));
		getCommand("pack").setExecutor(new CommandHandler(this));
		getCommand("trash").setExecutor(new CommandHandler(this));
		getCommand("voucher").setExecutor(new CommandHandler(this));
		getCommand("vouchers").setExecutor(new CommandHandler(this));
	}

	public void onPluginMessageReceived(String channel, Player player, byte[] message) {
	    if (!channel.equals("BungeeCord")) {
	      return;
	    }
	    try{
	    	DataInputStream in = new DataInputStream(new ByteArrayInputStream(message));
		    String subchannel = in.readUTF();
	    if (subchannel.equals("PlayerCount")) {
            // Use the code sample in the 'Response' sections below to read the data.
	    	PlayerCountServer = in.readUTF(); // Name of server, as given in the arguments
	    	playercount = in.readInt();
        } else if (subchannel.equals("SomeOtherSubChannel")) {
            // Read the data for a different subchannel.
        } else if (subchannel.equals("GetServer")) {
            // Example: GetServer subchannel
        	GetServer = in.readUTF();
        }
	    }catch (Exception e){
	    	e.printStackTrace();
	    }
	  }
}
