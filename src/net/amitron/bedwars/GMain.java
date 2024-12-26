package net.amitron.bedwars;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import net.amitron.bedwars.listeners.PlayerJoin;
import net.amitron.state.GState;

public class GMain extends JavaPlugin{
	
	public ArrayList<Player> players = new ArrayList<Player>();
	
	private GState state;

	@Override
	public void onEnable() {
		saveDefaultConfig();
		setState(GState.WAITING);
		Bukkit.getPluginManager().registerEvents(new PlayerJoin(this), this);
		
	}
	
	
	public Location getSpawn() {
		
		// Location spawn
		Double spawnx = getConfig().getDouble("location.spawn.x");
		Double spawny = getConfig().getDouble("location.spawn.y");
		Double spawnz = getConfig().getDouble("location.spawn.z");
		Location spawn = new Location(Bukkit.getWorld("world"), spawnx, spawny, spawnz);
		
		return spawn;
	}
	
	public void setState(GState state) {
		this.state = state;
	}
	
	public boolean isState(GState state) {
		return this.state == state;
	}
	
	public List<Player> getPlayer(){
		return players;
	}

}
