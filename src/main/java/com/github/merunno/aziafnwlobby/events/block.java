package com.github.merunno.aziafnwlobby.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class block implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent breakEvent) {
        World lobby = Bukkit.getWorld("lobby");
        World afk = Bukkit.getWorld("afk");
        Player player = breakEvent.getPlayer();
        if(breakEvent.getPlayer().getWorld() == lobby) {
            if (player.hasPermission("afnw.op.commands")) return;
            breakEvent.setCancelled(true);
            player.sendMessage(ChatColor.RED + "[AziAfnwLobby] ロビー内ではブロックの破壊はできません。");
        } else if(breakEvent.getPlayer().getWorld() == afk) {
            if (player.hasPermission("afnw.op.commands")) return;
            breakEvent.setCancelled(true);
        }
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent placeEvent) {
        World lobby = Bukkit.getWorld("lobby");
        World afk = Bukkit.getWorld("afk");
        Player player = placeEvent.getPlayer();
        if(placeEvent.getPlayer().getWorld() == lobby) {
            if (player.hasPermission("afnw.op.commands")) return;
            placeEvent.setCancelled(true);
            player.sendMessage(ChatColor.RED + "[AziAfnwLobby] ロビー内ではブロックの設置はできません。");
        } else if(placeEvent.getPlayer().getWorld() == afk) {
            if (player.hasPermission("afnw.op.commands")) return;
            placeEvent.setCancelled(true);
        }
    }

    @EventHandler
    public void onBucket(PlayerBucketEmptyEvent BucketEmptyEvent) {
        World lobby = Bukkit.getWorld("lobby");
        World afk = Bukkit.getWorld("afk");
        Player player = BucketEmptyEvent.getPlayer();
        if(BucketEmptyEvent.getPlayer().getWorld() == lobby) {
            if (player.hasPermission("afnw.op.commands")) return;
            BucketEmptyEvent.setCancelled(true);
            player.sendMessage(ChatColor.RED + "[AziAfnwLobby] ロビー内ではバケツの操作はできません。");
        } else if(BucketEmptyEvent.getPlayer().getWorld() == afk) {
            if (player.hasPermission("afnw.op.commands")) return;
            BucketEmptyEvent.setCancelled(true);
        }
    }


    @EventHandler
    public void onInteract(PlayerInteractEvent interactEvent) {
        World afk = Bukkit.getWorld("afk");
        Player player = interactEvent.getPlayer();
        ItemStack item = interactEvent.getItem();
        World lobby = Bukkit.getServer().getWorld("lobby");
        if(interactEvent.getPlayer().getWorld() == lobby) {
            if (player.hasPermission("afnw.op.commands")) return;
            if (item != null && !item.getType().isAir()) {
                interactEvent.setCancelled(true);
            }
        } else if(interactEvent.getPlayer().getWorld() == afk) {
            if (player.hasPermission("afnw.op.commands")) return;
            if (item != null && !item.getType().isAir()) {
                interactEvent.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onPick(EntityPickupItemEvent pickupItemEvent) {
        World afk = Bukkit.getWorld("afk");
        Entity player = pickupItemEvent.getEntity();
        if(player instanceof Player) {
            World lobby = Bukkit.getServer().getWorld("lobby");
            if(player.getWorld() == lobby) {
                if (player.hasPermission("afnw.op.commands")) return;
                pickupItemEvent.setCancelled(true);
            } else if(player.getWorld() == afk) {
                if (player.hasPermission("afnw.op.commands")) return;
                pickupItemEvent.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent dropItemEvent) {
        World afk = Bukkit.getWorld("afk");
        Player player = dropItemEvent.getPlayer();
        World lobby = Bukkit.getServer().getWorld("lobby");
        if(player.getWorld() == lobby) {
            if (player.hasPermission("afnw.op.commands")) return;
            dropItemEvent.setCancelled(true);
            player.sendMessage(ChatColor.RED + "[AziAfnwLobby] ロビー内ではアイテムをドロップできません。");
        } else if(player.getWorld() == afk) {
            if (player.hasPermission("afnw.op.commands")) return;
            dropItemEvent.setCancelled(true);
        }
    }

}
