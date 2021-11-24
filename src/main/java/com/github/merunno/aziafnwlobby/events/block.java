package com.github.merunno.aziafnwlobby.events;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;

public class block implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent breakEvent) {
        World lobby = Bukkit.getWorld("lobby");
        Player player = breakEvent.getPlayer();
        if(breakEvent.getPlayer().getWorld() == lobby) {
            if (player.hasPermission("afnw.op.commands")) return;
            breakEvent.setCancelled(true);
        }
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent placeEvent) {
        World lobby = Bukkit.getWorld("lobby");
        Player player = placeEvent.getPlayer();
        if(placeEvent.getPlayer().getWorld() == lobby) {
            if (player.hasPermission("afnw.op.commands")) return;
            placeEvent.setCancelled(true);
        }
    }

    @EventHandler
    public void onBucket(PlayerBucketEmptyEvent BucketEmptyEvent) {
        World lobby = Bukkit.getWorld("lobby");
        Player player = BucketEmptyEvent.getPlayer();
        if(BucketEmptyEvent.getPlayer().getWorld() == lobby) {
            if (player.hasPermission("afnw.op.commands")) return;
            BucketEmptyEvent.setCancelled(true);
        }
    }

    @EventHandler
    public void onPick(EntityPickupItemEvent pickupItemEvent) {
        Player player = (Player) pickupItemEvent.getEntity();
        World lobby = Bukkit.getServer().getWorld("lobby");
        if(player.getWorld() == lobby) {
            if (player.hasPermission("afnw.op.commands")) return;
            pickupItemEvent.setCancelled(true);
        }
    }

}
