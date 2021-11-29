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
            World afk = Bukkit.getServer().getWorld("afk");
            Location point = Objects.requireNonNull(afk).getSpawnLocation();
            player.sendMessage(ChatColor.AQUA + "[AziAfnwLobby] AFKへ移動します.....");
            if(player.getWorld() == afk) {
                player.sendMessage(ChatColor.RED + "[AziAfnwLobby] 既にAFKに接続しています。");
                return true;
            }
            player.sendMessage(ChatColor.YELLOW + "[AziAfnwLobby] AFKに移動しました。");
            player.teleport(point);
        }
        return false;
    }
}
