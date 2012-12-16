package com.github.coaster3000.editprotect.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import com.github.coaster3000.editprotect.EditProtect;

public class EditListener extends PluginListener<EditProtect> {
	public EditListener(EditProtect instance)
	{
		super(instance);
	}
	
	@EventHandler(priority=EventPriority.LOWEST,ignoreCancelled=true)
	public void onCommandPreProcessEvent(PlayerCommandPreprocessEvent event)
	{
		
	}
}
