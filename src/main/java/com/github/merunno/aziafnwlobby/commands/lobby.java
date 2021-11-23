package com.github.merunno.aziafnwlobby.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

public class lobby implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (command.getName().equalsIgnoreCase("lobby")) {
            Player player = (Player) sender;
            World lobby = Bukkit.getServer().getWorld("lobby");
            Location point = Objects.requireNonNull(lobby).getSpawnLocation();
            player.sendMessage(ChatColor.AQUA + "[AziAfnwLobby] ロビーへ移動します.....");
            player.teleport(point);
        }
        return true;
    }
}
