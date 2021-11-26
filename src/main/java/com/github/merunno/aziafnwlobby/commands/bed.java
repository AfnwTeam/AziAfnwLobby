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

public class bed implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(command.getName().equalsIgnoreCase("bed")) {
            Player player = (Player) sender;
            World afnw = Bukkit.getServer().getWorld("world");
            player.sendMessage(ChatColor.AQUA + "[AziAfnwLobby] ベットロケーションへ移動します.....");
            if(Objects.requireNonNull(player.getPlayer()).getWorld() == afnw) {
                Location playerBedLocation = player.getBedSpawnLocation();
                if(playerBedLocation == null) {
                    player.sendMessage(ChatColor.RED + "[AziAfnwLobby] ベットにテレポートできません。ベットで寝ていない、もしくはベットの破壊されていてスポーンロケーションを取得できません。");
                    return true;
                }
                player.sendMessage(ChatColor.AQUA + "[AziAfnwLobby] ベットロケーションに移動しました。");
                player.teleport(playerBedLocation);
            } else {
                player.sendMessage(ChatColor.RED + "[AziAfnwLobby] ロケーションに移動できません。AfnwWorld以外のワールドです。");
                return true;
            }
        }
        return false;
    }
}
