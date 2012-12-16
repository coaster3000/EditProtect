package com.github.coaster3000.editprotect.util;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;


import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

public class VaultAdapter {
    private static Plugin plugin;
    private static Permission permission = null;
    private static Economy economy = null;
    private static Chat chat = null;

    /**
	 * @return the permission
	 */
	public static final Permission getPermission() {
		return permission;
	}

	/**
	 * @param permission the permission to set
	 */
	public static final void setPermission(Permission permission) {
		VaultAdapter.permission = permission;
	}

	/**
	 * @return the economy
	 */
	public static final Economy getEconomy() {
		return economy;
	}

	/**
	 * @param economy the economy to set
	 */
	public static final void setEconomy(Economy economy) {
		VaultAdapter.economy = economy;
	}

	/**
	 * @return the chat
	 */
	public static final Chat getChat() {
		return chat;
	}

	/**
	 * @param chat the chat to set
	 */
	public static final void setChat(Chat chat) {
		VaultAdapter.chat = chat;
	}

	public static void destroy() {
	permission = null;
	economy = null;
	chat = null;
	plugin = null;
    }

    public static int setup() {
	int error = 0;
	if (!setupChat())
	    error = error | 1;
	if (!setupEconomy())
	    error = error | 2;
	if (!setupPermissions())
	    error = error | 4;
	return error;
    }

    /**
     * Checks if permissions are loaded.
     * 
     * @return true, if is permission loaded
     */
    public static boolean isPermissionLoaded() {
	return loaded("permission");
    }

    /**
     * Checks if economy is loaded.
     * 
     * @return true, if economy loaded
     */
    public static boolean isEconomyLoaded() {
	return loaded("economy");
    }

    /**
     * Checks if chat is loaded.
     * 
     * @return true, if chat is loaded
     */
    public static boolean isChatLoaded() {
	return loaded("chat");
    }

    /**
     * Is something loaded?
     * 
     * <i>Possible values to enter:</i>
     * <b>Permission , Economy, Chat</b>
     * 
     * @param what is loaded?
     * @return true, if that thing is loaded
     */
    public static boolean loaded(String what) {
    	what = what.toUpperCase();
    	if (what.equals("PERMISSION"))
    		return (permission == null)?false:true;
    	else if (what.equals("ECONOMY"))
    		return (economy == null) ? false:true;
    	else if (what.equals("CHAT"))
    		return (chat == null)?false : true;
    	return false;
    }

    public static void init(Plugin plugin) {
	VaultAdapter.plugin = plugin;
    }

    /**
     * Setup permissions.
     * 
     * @return true, if successful
     */
    private static boolean setupPermissions() {
	RegisteredServiceProvider<Permission> permissionProvider = plugin.getServer().getServicesManager().getRegistration(net.milkbowl.vault.permission.Permission.class);
	if (permissionProvider != null) {
	    permission = permissionProvider.getProvider();
	}
	return (permission != null);
    }

    /**
     * Setup chat.
     * 
     * @return true, if successful
     */
    private static boolean setupChat() {
	RegisteredServiceProvider<Chat> chatProvider = plugin.getServer().getServicesManager().getRegistration(net.milkbowl.vault.chat.Chat.class);
	if (chatProvider != null) {
	    chat = chatProvider.getProvider();
	}

	return (chat != null);
    }

    /**
     * Setup economy.
     * 
     * @return true, if successful
     */
    private static boolean setupEconomy() {
	RegisteredServiceProvider<Economy> economyProvider = plugin.getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
	if (economyProvider != null) {
	    economy = economyProvider.getProvider();
	}

	return (economy != null);
    }
}
