package eu.mhsl.mc.ironopen.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.Openable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

public class onBlockClick implements Listener {
    @EventHandler
    public void onBlockClick(PlayerInteractEvent e) {
        try {
            if(e.getHand() == EquipmentSlot.OFF_HAND) return;
            if(!e.getPlayer().isSneaking() && e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                Block b = e.getClickedBlock();
                Material type = b.getType();
                if(type.equals(Material.IRON_DOOR) || type.equals(Material.IRON_TRAPDOOR)) {
                    e.setCancelled(true);
                    toggleOpenable(b);
                    e.getPlayer().playSound(b.getState().getBlock().getLocation(), Sound.BLOCK_IRON_DOOR_OPEN, 1,1);
                }
            }
        } catch (Exception ex) {
            Bukkit.getLogger().warning("IronOpener failed to toggle door for Player " + e.getPlayer().getDisplayName() + " - Error: " + ex.getMessage());
        }
    }

    public void toggleOpenable(Block b) throws Exception {
        BlockState blockState = b.getState();
        Openable openable = (Openable) b.getState().getBlockData();

        openable.setOpen(!openable.isOpen());
        blockState.setBlockData(openable);
        blockState.update();
    }
}
