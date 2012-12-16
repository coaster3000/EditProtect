package com.github.coaster3000.editprotect.listeners;

import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public abstract class PluginListener<T extends Plugin> implements Listener {
	private T plugin;
	public PluginListener(T instance)
	{
		this.plugin = instance;
	}
	public T getPlugin(){return plugin;}
	
}
