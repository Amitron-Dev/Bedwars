package net.amitron.bedwars.runnable;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class GAutoStart extends BukkitRunnable{
	
	private int timer = 20;
	
	
	@Override
	public void run() {
		
		if(timer == 10 || timer == 5 || timer == 4 || timer == 3 || timer == 2 || timer == 1) {
			Bukkit.broadcastMessage("§6[BEDWARS] §rLancement du jeu dans " + timer);
		}
		
		if(timer == 0) {
			
		}
		
		
		timer--;
	}

}
