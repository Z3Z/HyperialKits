package net.HyperialKits.Main.Handlers;

import java.util.Map.Entry;
import java.util.UUID;

import net.HyperialKits.Main.Main;
import net.HyperialKits.Main.Utils.HashMapStorage;
import net.HyperialKits.Main.Utils.Packets;
import net.HyperialKits.Main.Utils.Util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

public class ScoreBoardHandler implements Listener{
	
	private static Main plugin;
	public ScoreBoardHandler(Main listener) {
		ScoreBoardHandler.plugin = listener;
		boardUpdater();
	}
	
public static Scoreboard board;
public static Objective objective;
	
    public static void makeScoreBoard(final Player p){
        ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
        board = scoreboardManager.getNewScoreboard();
        objective = board.registerNewObjective("lobby","dummy");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        Score score = objective.getScore(Util.color("&a&lKILLS"));
        score.setScore(14);
        Score score1 = objective.getScore(Util.color(ChatColor.GREEN + "" + ChatColor.BOLD));
        score1.setScore(13);
        Score score2 = objective.getScore(Util.color(" "));
        score2.setScore(12);
        Score score3 = objective.getScore(Util.color("&e&lCOINS"));
        score3.setScore(11);
        Score score4 = objective.getScore(Util.color(ChatColor.YELLOW + "" + ChatColor.BOLD));
        score4.setScore(10);
        Score score5 = objective.getScore(Util.color("  "));
        score5.setScore(9);
        Score score6 = objective.getScore(Util.color("&5&lSHARDS"));
        score6.setScore(8);
        Score score7 = objective.getScore(Util.color(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD));
        score7.setScore(7);
        Score score8 = objective.getScore(Util.color("   "));
        score8.setScore(6);
        Score score9 = objective.getScore(Util.color("&c&lDEATHS"));
        score9.setScore(5);
        Score score10 = objective.getScore(Util.color(ChatColor.AQUA + "" + ChatColor.BOLD));
        score10.setScore(4);
        Score score11 = objective.getScore(Util.color("    "));
        score11.setScore(3);
        Score score12 = objective.getScore(Util.color("&b&lWEBSITE"));
        score12.setScore(2);
        Score score13 = objective.getScore(Util.color(ChatColor.RED + "" + ChatColor.BOLD));
        score13.setScore(1);
        
        Team team1 = board.registerNewTeam("team1");
        team1.addEntry(ChatColor.GREEN + "" + ChatColor.BOLD);
        
        Team team2 = board.registerNewTeam("team2");
        team2.addEntry(ChatColor.YELLOW + "" + ChatColor.BOLD);

        Team team3 = board.registerNewTeam("team3");
        team3.addEntry(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD);
        
        Team team4 = board.registerNewTeam("team4");
        team4.addEntry(ChatColor.AQUA + "" + ChatColor.BOLD);
        
        Team team5 = board.registerNewTeam("team5");
        team5.addEntry(ChatColor.RED + "" + ChatColor.BOLD);
		p.setScoreboard(board);
    }
    
    
    public static void boardUpdater(){
    	Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable(){
        		public void run() {
        			
        			for (Entry<UUID, Integer> entry : HashMapStorage.Coins.entrySet()) {
    					plugin.getConfig().set(entry.getKey() + ".Coins", entry.getValue());
    				}
        			
        			for (Entry<UUID, Integer> entry : HashMapStorage.Shards.entrySet()) {
    					plugin.getConfig().set(entry.getKey() + ".Shards", entry.getValue());
    				}
        			
        			for (Entry<UUID, Integer> entry : HashMapStorage.Kills.entrySet()) {
    					plugin.getConfig().set(entry.getKey() + ".Kills", entry.getValue());
    				}
        			
        			for (Entry<UUID, Integer> entry : HashMapStorage.Deaths.entrySet()) {
    					plugin.getConfig().set(entry.getKey() + ".Deaths", entry.getValue());
    				}
        			
        			for(final Player p : Bukkit.getOnlinePlayers()){
        			if(!(p.equals(null))){
        				
        			p.setPlayerListName(Util.color("&7&lK/D&8&l<&a&l" + HashMapStorage.Kills.get(p.getUniqueId()).toString() + "&8&l/&c&l" + HashMapStorage.Deaths.get(p.getUniqueId()).toString() + "&8&l>&e " + p.getName()));
        				
        		    int health = (int) ((Damageable)p).getHealth();
        		    if(health >= 3000){
        		        Packets.sendActionBar(p, Util.color("&e&lHEALTH: &6&l(&a&l" + health + "&6&l/" + "&a&l5000&6&l)"));
        		    }else if(health <= 2999 || health >= 1000){
        		    	Packets.sendActionBar(p, Util.color("&e&lHEALTH: &6&l(&e&l" + health + "&6&l/" + "&a&l5000&6&l)"));
        		    }else if(health <= 999){
        		    	Packets.sendActionBar(p, Util.color("&e&lHEALTH: &6&l(&c&l" + health + "&6&l/" + "&a&l5000&6&l)"));
        		    }
        				
        			Team team1 = p.getScoreboard().getTeam("team1");
    				team1.setPrefix(Util.color("&7&l" + "▶ "));
    				team1.setSuffix(Util.color("&f" + HashMapStorage.Kills.get(p.getUniqueId()).toString()));
        			
    				Team team2 = p.getScoreboard().getTeam("team2"); 
    				team2.setPrefix(Util.color("&7&l" + "▶ "));
    				team2.setSuffix(Util.color("&f" + HashMapStorage.Coins.get(p.getUniqueId()).toString()));
    				
    				Team team3 = p.getScoreboard().getTeam("team3");
    				team3.setPrefix(Util.color("&7&l" + "▶ "));
    				team3.setSuffix(Util.color("&f" + HashMapStorage.Shards.get(p.getUniqueId()).toString()));
    				
    				Team team4 = p.getScoreboard().getTeam("team4");
    				team4.setPrefix(Util.color("&7&l" + "▶ "));
    				team4.setSuffix(Util.color("&f" + HashMapStorage.Deaths.get(p.getUniqueId()).toString()));
    				
    				Team team5 = p.getScoreboard().getTeam("team5");
    				team5.setPrefix(Util.color("&7&l" + "▶ "));
    				team5.setSuffix(Util.color("&7HyperialMC.net"));
    				
    				p.getScoreboard().getObjective("lobby").setDisplayName(Util.color("&e&lHyperial&7&lMC"));
        			}
        			}
        		}
            	}, 0, 5);
    }
}
