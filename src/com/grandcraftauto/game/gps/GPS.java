package com.grandcraftauto.game.gps;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.grandcraftauto.game.apartment.Apartment;
import com.grandcraftauto.game.missions.objectives.PlaceBlockObjective;
import com.grandcraftauto.game.missions.objectives.ReachDestinationObjective;
import com.grandcraftauto.game.player.GPlayer;
import com.grandcraftauto.utils.Utils;

public final class GPS {
	
	/**
	 * Get the GPS inventory
	 * @return The GPS inventory
	 */
	public static final Inventory getInventory(Player player){
		GPlayer gplayer = new GPlayer(player);
		Inventory inv = Bukkit.createInventory(null, 18, ChatColor.DARK_GRAY + "GPS");
		inv.setItem(1, Utils.renameItem(new ItemStack(Material.IRON_HOE), ChatColor.DARK_RED + "Ammu" + ChatColor.WHITE + "Nation"));
		inv.setItem(2, Utils.renameItem(new ItemStack(Material.MINECART), ChatColor.GRAY + "Car Dealership"));
		inv.setItem(3, Utils.renameItem(new ItemStack(Material.WOOD_DOOR), ChatColor.GOLD + "Apartment Complex"));
		inv.setItem(4, Utils.renameItem(new ItemStack(Material.GRILLED_PORK), ChatColor.GRAY + "Gas Station"));
		inv.setItem(5, Utils.renameItem(new ItemStack(Material.GOLD_NUGGET), ChatColor.GOLD + "Bank"));
		inv.setItem(6, Utils.renameItem(new ItemStack(Material.COOKED_BEEF), ChatColor.DARK_AQUA + "Burgershot"));
		inv.setItem(7, Utils.renameItem(new ItemStack(Material.SKULL_ITEM), ChatColor.DARK_GRAY + "Black Market"));
		if(gplayer.hasMission() == true && (gplayer.getObjective() instanceof ReachDestinationObjective || gplayer.getObjective() instanceof PlaceBlockObjective)){
			if(gplayer.hasApartment() == true){
				inv.setItem(12, Utils.renameItem(new ItemStack(Material.WOOD_DOOR), ChatColor.GOLD + "Apartments"));
				inv.setItem(13, Utils.renameItem(new ItemStack(Material.COMPASS), ChatColor.GOLD + "Mission Objective"));
				inv.setItem(14, Utils.renameItem(new ItemStack(Material.PAPER), ChatColor.DARK_RED + "Cancel Route"));
			}else{
				inv.setItem(12, Utils.renameItem(new ItemStack(Material.COMPASS), ChatColor.GOLD + "Mission Objective"));
				inv.setItem(14, Utils.renameItem(new ItemStack(Material.PAPER), ChatColor.DARK_RED + "Cancel Route"));
			}
		}else{
			if(gplayer.hasApartment() == true){
				inv.setItem(12, Utils.renameItem(new ItemStack(Material.WOOD_DOOR), ChatColor.GOLD + "Apartments"));
				inv.setItem(14, Utils.renameItem(new ItemStack(Material.PAPER), ChatColor.DARK_RED + "Cancel Route"));
			}else{
				inv.setItem(13, Utils.renameItem(new ItemStack(Material.PAPER), ChatColor.DARK_RED + "Cancel Route"));
			}
		}
		return inv;
	}
	
	/**
	 * Get a player's apartment GPS inventory
	 * @param player - The player to get the inventory of
	 * @return The apartment GPS inventory for the player
	 */
	public static final Inventory getApartmentInventory(Player player){
		GPlayer gplayer = new GPlayer(player);
		List<Apartment> apartments = gplayer.getApartments();
		Inventory inv = Bukkit.createInventory(null, Utils.getRoundedInventorySize(apartments.size()), ChatColor.DARK_GRAY + "GPS - Apartments");
		int slot = 0;
		for(Apartment a : apartments){
			inv.setItem(slot, Utils.renameItem(new ItemStack(Material.PAPER), ChatColor.GOLD + a.getName()));
			slot++;
		}
		return inv;
	}
	
	/**
	 * Get the compass itemstack
	 * @return The compass itemstack
	 */
	public static final ItemStack getCompass(){
		return Utils.renameItem(new ItemStack(Material.COMPASS), ChatColor.YELLOW + "GPS");
	}
	
	/**
	 * Get the nearest NPC of the store inventory
	 * @param store - The store type to get the NPC of
	 * @return The location of the NPC
	 */
	public static final Location getNearest(Player player, Destination dest){
		Location nearest = null;
		for(Entity e : Utils.getGCAWorld().getEntities()){
			if(e instanceof Player){
				Player p = (Player) e;
				if(ChatColor.stripColor(p.getName()).toLowerCase().contains(dest.getKeyword())){
					boolean replace = true;
					if(nearest != null){
						if(nearest.distance(player.getLocation()) < e.getLocation().distance(player.getLocation())){
							replace = false;
						}
					}
					if(replace == true){
						nearest = e.getLocation();
					}
				}
			}
		}
		return nearest;
	}
}
