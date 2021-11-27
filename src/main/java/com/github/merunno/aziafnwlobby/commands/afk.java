package com.github.merunno.aziafnwlobby.commands;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import java.util.Objects;

public class afk implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (command.getName().equalsIgnoreCase("afk")) {
            Player player = (Player) sender;
            Location loc = player.getLocation();
            World afk = Bukkit.getServer().getWorld("afk");
            Location point = Objects.requireNonNull(afk).getSpawnLocation();
            player.sendMessage(ChatColor.AQUA + "[AziAfnwLobby] AFKへ移動します.....10秒待機が必要です。");
            if(player.getWorld() == afk) {
                player.sendMessage(ChatColor.RED + "[AziAfnwLobby] 既にAFKに接続しています。");
                return true;
            }
            player.sendMessage(ChatColor.AQUA + "[AziAfnwLobby] AFKに移動しました。");
            player.teleport(point);
            particle(loc);
        }
        return false;
    }

    private void particle(Location loc) {
        Objects.requireNonNull(loc.getWorld()).playEffect(loc, Effect.ENDER_SIGNAL, 0, 14);
    }
}
