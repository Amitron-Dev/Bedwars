package net.amitron.bedwars.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import net.amitron.bedwars.GMain;
import net.amitron.bedwars.runnable.GAutoStart;
import net.amitron.state.GState;

public class ClickStartEvent implements Listener {
	
	private GMain main;
	
	public ClickStartEvent(GMain main) {
		this.main = main;
	}
		

	
	
	public void Interact(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		ItemStack it = e.getItem();
		
		if(main.isState(GState.WAITING)) {
			if(it.getType() == Material.EMERALD) {
				GAutoStart start = new GAutoStart();
				start.runTaskTimer(main, 0, 20);
			}
		}
	}

}
