package com.github.merunno.aziafnwlobby.commands;

import com.github.merunno.aziafnwlobby.AziAfnwLobby;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.Objects;

public class lobby implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (command.getName().equalsIgnoreCase("lobby")) {
            Player player = (Player) sender;
            Location loc = player.getLocation();
            World lobby = Bukkit.getServer().getWorld("lobby");
            Location point = Objects.requireNonNull(lobby).getSpawnLocation();
            player.sendMessage(ChatColor.AQUA + "[AziAfnwLobby] ロビーへ移動します....10秒待機が必要です。");
            if(Objects.requireNonNull(player.getPlayer()).getWorld() == lobby) {
                player.sendMessage(ChatColor.RED + "[AziAfnwLobby] 既にロビーに接続しています。");
                return true;
            }
            player.sendMessage(ChatColor.AQUA + "[AziAfnwLobby] ロビーに移動しました。");
            player.teleport(point);
            particle(loc);
        }
        return false;
    }

    private void particle(Location loc) {
        Objects.requireNonNull(loc.getWorld()).playEffect(loc, Effect.ENDER_SIGNAL, 0, 14);
    }
}
