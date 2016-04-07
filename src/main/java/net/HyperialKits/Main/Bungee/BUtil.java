package net.HyperialKits.Main.Bungee;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import net.HyperialKits.Main.Main;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class BUtil implements Listener{

	private static Main plugin;

	public BUtil(Main hub) {
		BUtil.plugin = hub;
	}

	public static void sendToServer(Player player, String targetServer) {
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(b);
		try {
			out.writeUTF("Connect");
			out.writeUTF(targetServer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		player.sendPluginMessage(plugin, "BungeeCord", b.toByteArray());
	}
	
	public static void sendMessage(Player player, String playerName, String Message) {
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(b);
		try {
			out.writeUTF("Message");
			out.writeUTF(playerName);
			out.writeUTF(Message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		player.sendPluginMessage(plugin, "BungeeCord", b.toByteArray());
	}
	
	public static String getServer(Player player) {
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(b);
		try {
			out.writeUTF("GetServer");
		} catch (Exception e) {
			e.printStackTrace();
		}
		player.sendPluginMessage(plugin, "BungeeCord", b.toByteArray());
		return Main.GetServer;
	}
	
	public static Integer playerCountOfServer(Player player, String targetServer) {
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(b);
		try {
			out.writeUTF("PlayerCount");
			out.writeUTF(targetServer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		player.sendPluginMessage(plugin, "BungeeCord", b.toByteArray());
		return Main.playercount;
	}
	
	public static void kickPlayer(Player player, String playerName, String kickMessage) {
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(b);
		try {
			out.writeUTF("KickPlayer");
			out.writeUTF(playerName);
			out.writeUTF(kickMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		player.sendPluginMessage(plugin, "BungeeCord", b.toByteArray());
	}
}