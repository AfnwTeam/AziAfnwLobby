package com.github.merunno.aziafnwlobby.events;

import com.github.merunno.aziafnwlobby.AziAfnwLobby;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;


import java.util.Objects;

public class player implements Listener {

    @EventHandler
    public void onLogin(PlayerJoinEvent loginEvent) {
        Player player = loginEvent.getPlayer();
        World lobby = Bukkit.getServer().getWorld("lobby");
        Location point = Objects.requireNonNull(lobby).getSpawnLocation();
        if(player.hasPermission("afnw.op.commands")) {
            new BukkitRunnable() {
                @Override
                public void run() {
                    player.sendTitle(ChatColor.YELLOW + "オペレーターリスタート", "オペレーターのため、前回と同じ地点からスタートになります。", 3, 60, 1);
                    player.sendMessage(ChatColor.YELLOW + "[AziAfnwLobby] オペレーターリスタート機能が発動しました。オペレーターのため、前回と同じ地点からスタートになります。");
                }
            }.runTaskLater(JavaPlugin.getPlugin(AziAfnwLobby.class), 20 * 6);
            return;
        }
        player.teleport(point);
    }
}
