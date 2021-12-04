package com.github.merunno.aziafnwlobby.commands;

import com.github.merunno.aziafnwlobby.AziAfnwLobby;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Objects;

public class bed implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(command.getName().equalsIgnoreCase("bed")) {
            Player player = (Player) sender;
            World afnw = Bukkit.getServer().getWorld("world");
            Location playerBedLocation = player.getBedSpawnLocation();
            if(playerBedLocation == null) {
                player.sendMessage(ChatColor.RED + "[AziAfnwLobby] ベットにテレポートできません。ベットで寝ていない、もしくはベットが破壊されていてスポーンロケーションを取得できません。");
                return true;
            }
            if(Objects.requireNonNull(player.getPlayer()).getWorld() != afnw) {
                player.sendMessage(ChatColor.RED + "[AziAfnwLobby] ロケーションに移動できません。ここでは利用できません。");
                return true;
            }
            player.sendMessage(ChatColor.AQUA + "[AziAfnwLobby] ベットロケーションへ移動します......5秒待機してください。");
            new BukkitRunnable() {
                @Override
                public void run() {
                    player.sendMessage(ChatColor.YELLOW + "[AziAfnwLobby] ベットロケーションに移動しました。");
                    player.teleport(playerBedLocation);
                }
            }.runTaskLater(JavaPlugin.getPlugin(AziAfnwLobby.class), 7 * 10);
        }
        return false;
    }
}
