package org.bukkit.event.block;

import java.util.Collection;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

/**
 * Called when a block is broken by a player.
 * <p>
 * If you wish to have the block drop experience, you must set the experience
 * value above 0. By default, experience will be set in the event if:
 * <ol>
 * <li>The player is not in creative or adventure mode
 * <li>The player can loot the block (ie: does not destroy it completely, by
 *     using the correct tool)
 * <li>The player does not have silk touch
 * <li>The block drops experience in vanilla Minecraft
 * </ol>
 * <p>
 * Note:
 * Plugins wanting to simulate a traditional block drop should set the block
 * to air and utilize their own methods for determining what the default drop
 * for the block being broken is and what to do about it, if anything.
 * <p>
 * If a Block Break event is cancelled, the block will not break and
 * experience will not drop.
 */
public class BlockBreakEvent extends BlockExpEvent implements Cancellable {
    private final Player player;
    private boolean cancel;
    private Collection<ItemStack> BlockDrops;
    private boolean dropOnFeet;
    
    public BlockBreakEvent(final Block theBlock, final Player player) {
        super(theBlock, 0);

        this.player = player;
                
        this.setDropOnFeet(false);
    }

    /**
     * Gets the Player that is breaking the block involved in this event.
     *
     * @return The Player that is breaking the block involved in this event
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Check if breaking the block is Cancelled.
     *
     * @return if the block involved is break in this event
     */
    public boolean isCancelled() {
        return cancel;
    }


    /**
     * Allow or Disallow Block Break Event.
     *
     * @return VOID
     */
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }


    /**
     * TThis method return an collection of itemstack of drops.
     *
     * @return Collection<ItemStack> drops of block
     */
	public Collection<ItemStack> getBlockDrops() {
		return BlockDrops;
	}



    /**
     * TThis method set an collection of itemstack of drops.
     *
     * @return VOID
     */
	public void setBlockDrops(Collection<ItemStack> blockDrops) {
		BlockDrops = blockDrops;
	}



    /**
     * This method return if drops drop on feet or not
     *
     * @return boolean drop item on feet or not
     */
	public boolean isDropOnFeet() {
		return dropOnFeet;
	}

    /**
     * This method set drops block on feet or not
     *
     * @return VOID
     */
	public void setDropOnFeet(boolean dropOnFeet) {
		this.dropOnFeet = dropOnFeet;
	}
}
