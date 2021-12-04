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

public class afk implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (command.getName().equalsIgnoreCase("afk")) {
            Player player = (Player) sender;
            World afk = Bukkit.getServer().getWorld("afk");
            Location point = Objects.requireNonNull(afk).getSpawnLocation();
            if(player.getWorld() == afk) {
                player.sendMessage(ChatColor.RED + "[AziAfnwLobby] 既にAFKに接続しています。");
                return true;
            }
            player.sendMessage(ChatColor.AQUA + "[AziAfnwLobby] AFKへ移動します.....5秒待機してください。");
            new BukkitRunnable() {
                @Override
                public void run() {
                    player.sendMessage(ChatColor.YELLOW + "[AziAfnwLobby] AFKに移動しました。");
                    player.teleport(point);
                }
            }.runTaskLater(JavaPlugin.getPlugin(AziAfnwLobby.class), 5 * 10);
        }
        return false;
    }
}
