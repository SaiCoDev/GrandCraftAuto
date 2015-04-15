package com.grandcraftauto.game.missions.objectives;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import com.grandcraftauto.game.missions.Character;
import com.grandcraftauto.game.missions.Dialogue;
import com.grandcraftauto.game.missions.Objective;

public class ApproachObjective extends Objective {

	private Character approach;
	private ItemStack toGive;
	private Material toReturn;
	private int amountToReturn;
	private boolean autoDialogue;
	private boolean prostitute;
	
	public ApproachObjective(String desc, Dialogue dialogue, boolean revert, Character approach, ItemStack toGive, Material toReturn, int amountToReturn, boolean autoDialogue, boolean prostitute){
		super(desc, dialogue, revert);
		this.approach = approach;
		this.toGive = toGive;
		this.toReturn = toReturn;
		this.amountToReturn = amountToReturn;
		this.autoDialogue = autoDialogue;
		this.prostitute = prostitute;
	}
	
	/**
	 * Get the character to approach
	 * @return The character to approach
	 */
	public Character getToApproach(){
		return approach;
	}
	
	/**
	 * Get the item to give to the player after approaching
	 * @return The item to give to the player after approaching
	 */
	public ItemStack getItemToGive(){
		return toGive;
	}
	
	/**
	 * Get the type of item the player has to return
	 * @return The type of item the player has to return
	 */
	public Material getItemToReturn(){
		return toReturn;
	}
	
	/**
	 * Get the amount of items the player has to return
	 * @return The amount of items the player has to return
	 */
	public int getAmountOfItemToReturn(){
		return amountToReturn;
	}
	
	/**
	 * Get the objective's auto dialogue boolean
	 * @return The objective's auto dialogue boolean
	 */
	public boolean shouldAutoDialogue(){
		return autoDialogue;
	}
	
	/**
	 * Get the objective's prostitute return boolean
	 * @return The objective's prostitute return boolean
	 */
	public boolean shouldReturnProstitute(){
		return prostitute;
	}
}
