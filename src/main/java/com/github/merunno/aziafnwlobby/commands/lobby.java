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

public class lobby implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (command.getName().equalsIgnoreCase("lobby")) {
            Player player = (Player) sender;
            World lobby = Bukkit.getServer().getWorld("lobby");
            Location point = Objects.requireNonNull(lobby).getSpawnLocation();
            if (Objects.requireNonNull(player.getPlayer()).getWorld() == lobby) {
                player.sendMessage(ChatColor.RED + "[AziAfnwLobby] 既にロビーに接続しています。");
                return true;
            }
            player.sendMessage(ChatColor.AQUA + "[AziAfnwLobby] ロビーへ移動します......5秒待機してください。");
            new BukkitRunnable() {
                @Override
                public void run() {
                    player.sendMessage(ChatColor.YELLOW + "[AziAfnwLobby] ロビーに移動しました。");
                    player.teleport(point);
                }
            }.runTaskLater(JavaPlugin.getPlugin(AziAfnwLobby.class), 20 * 5);
        }
        return false;
    }
}
