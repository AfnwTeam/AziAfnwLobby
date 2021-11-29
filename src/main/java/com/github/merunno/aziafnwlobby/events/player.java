package com.github.merunno.aziafnwlobby.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Objects;

public class player implements Listener {

    @EventHandler
    public void onLogin(PlayerJoinEvent loginEvent) {
        Player player = loginEvent.getPlayer();
        World lobby = Bukkit.getServer().getWorld("lobby");
        Location point = Objects.requireNonNull(lobby).getSpawnLocation();
        if(player.hasPermission("afnw.op.commands")) return;
        if(!player.hasPlayedBefore()) {
            player.sendMessage(ChatColor.AQUA + "[AziAfnwLobby] 前回の再開地点がAfnwワールドでしたが、OPのため、前回と同じ地点からスタートになります。");
            player.teleport(point);
            return;
        }
        player.teleport(point);
    }
}
