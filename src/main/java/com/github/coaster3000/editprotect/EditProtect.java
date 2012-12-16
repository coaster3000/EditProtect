package com.github.coaster3000.editprotect;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;

public class EditProtect extends JavaPlugin {
	private WorldGuardPlugin wg = null;
	private WorldEditPlugin we = null;
	
	public WorldGuardPlugin getWorldGuardPlugin()
	{
		if (wg == null)
			wg = getWorldGuardPlugin();
		else
			return wg;
		return getWorldGuard();
	}
	
	public static WorldGuardPlugin getWorldGuard()
	{
		Plugin plugin = Bukkit.getPluginManager().getPlugin("WorldGuard");
		if (plugin == null || !(plugin instanceof WorldGuardPlugin)) {
			return null; // Maybe you want throw an exception instead
		}
		return (WorldGuardPlugin) plugin;
	}
	
	public WorldEditPlugin getWorldEditPlugin()
	{
		if (we == null)
			we = getWorldEdit();
		else
			return we;
		return getWorldEdit();
	}
	
	public WorldEditPlugin getWorldEdit()
	{
		Plugin plugin = Bukkit.getPluginManager().getPlugin("WorldEdit");
		if (plugin == null || !(plugin instanceof WorldEditPlugin))
			return null;
		return (WorldEditPlugin)plugin;
	}
	
}
