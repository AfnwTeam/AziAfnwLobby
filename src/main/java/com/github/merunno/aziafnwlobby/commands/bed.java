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
            if(player.hasPermission("afnw.op.commands")) {
                player.sendTitle(ChatColor.YELLOW + "オペレーターテレポート", "制限を回避してロビーに移動しました。", 3, 60, 1);
                player.sendMessage(ChatColor.YELLOW + "[AziAfnwLobby] オペレーターテレポートによりワールド設定、5秒の待機時間を回避しました。");
                player.teleport(playerBedLocation);
                return true;
            }
            if(Objects.requireNonNull(player.getPlayer()).getWorld() != afnw) {
                player.sendMessage(ChatColor.RED + "[AziAfnwLobby] ロケーションに移動できません。ここでは利用できません。");
                return true;
            }
            player.sendMessage(ChatColor.AQUA + "[AziAfnwLobby] ベットロケーションへ移動します......7秒待機してください。");
            new BukkitRunnable() {
                @Override
                public void run() {
                    if(Objects.requireNonNull(player.getPlayer()).getWorld() != afnw) {
                        player.sendMessage(ChatColor.RED + "[AziAfnwLobby] 不明なエラーにより、ロケーションの移動に失敗しました。");
                        return;
                    }
                    player.sendTitle(ChatColor.YELLOW + "Screaaaam!!!", "ベットロケーションに移動しました。", 3, 60, 1);
                    player.sendMessage(ChatColor.YELLOW + "[AziAfnwLobby] ベットロケーションに移動しました。");
                    player.teleport(playerBedLocation);
                }
            }.runTaskLater(JavaPlugin.getPlugin(AziAfnwLobby.class), 20 * 7);
        }
        return false;
    }
}
