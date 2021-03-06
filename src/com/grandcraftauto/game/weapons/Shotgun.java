package com.grandcraftauto.game.weapons;

import java.util.List;

import org.bukkit.Material;

import com.grandcraftauto.game.Rank;

public class Shotgun extends Gun {

	public Shotgun(String name, WeaponType type, List<String> lore, int cost, int minLevel, Material material, Ammo ammoType, double damage, 
			int clipSize, int roundsPerShot, int firingRate, int cooldown, double accuracy, double range, Rank rank){
		super(name, type, lore, cost, minLevel, material, ammoType, damage, clipSize, roundsPerShot, firingRate, cooldown, accuracy, range, rank);
	}
	
}
