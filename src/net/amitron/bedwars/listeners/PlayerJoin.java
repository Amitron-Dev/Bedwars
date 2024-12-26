package net.amitron.bedwars.listeners;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.amitron.bedwars.GMain;
import net.amitron.state.GState;

public class PlayerJoin implements Listener {
	private GMain main;
	
	public PlayerJoin(GMain main) {
		this.main = main;
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		
		if(main.isState(GState.WAITING)) {
			
			if(!p.hasPermission("bedwars.exempt")) {
				main.getPlayer().add(p);
			}
			
			p.getInventory().clear();
			if(p.hasPermission("bedwars.host")) {
				ItemStack start = new ItemStack(Material.EMERALD, 1);
				ItemMeta startM = start.getItemMeta();
				
				startM.setDisplayName("§aStart");
				startM.setLore(Arrays.asList("§4Start the bedwars game"));
				start.setItemMeta(startM);
				
				p.getInventory().setItem(4, start);
				e.setJoinMessage("§cLe host vient de rejoindre !");
			}else {
				if(!p.hasPermission("bedwars.host")) {
					e.setJoinMessage("§6[BEDWARS] §r§a+ §r§e" + Bukkit.getServer().getOnlinePlayers().size() + " / 3");
				}
				
			}
			
			p.teleport(main.getSpawn());
			p.sendMessage("§6[BEDWARS] §r§aBienvenue !");
			
			
		}
	}
	
}
