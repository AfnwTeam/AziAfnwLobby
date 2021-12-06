package com.github.merunno.aziafnwlobby.events;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Painting;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class entity implements Listener {

    @EventHandler
    public void onHanging(EntityDamageByEntityEvent e) {
        World world = Bukkit.getWorld("world");
        Entity damager = e.getDamager();
        if (damager instanceof Player) {
            if (damager.hasPermission("afnw.op.commands")) return;
            if (damager.getWorld() == world) return;
        }
        Entity entity = e.getEntity();
        if (entity instanceof Painting || entity instanceof ItemFrame) e.setCancelled(true);
    }

}
