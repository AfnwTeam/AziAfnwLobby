package com.github.merunno.aziafnwlobby;

import com.github.merunno.aziafnwlobby.commands.*;
import com.github.merunno.aziafnwlobby.events.*;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class AziAfnwLobby extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("AziAfnwLobbyを読み込みます。");
        getLogger().info("このプラグインはAfnwCoreと依存関係を結んでいます。");

        Objects.requireNonNull(getCommand("lobby")).setExecutor(new lobby());
        Objects.requireNonNull(getCommand("bed")).setExecutor(new bed());
        Objects.requireNonNull(getCommand("afk")).setExecutor(new afk());

        getServer().getPluginManager().registerEvents(new block(), this);
        getServer().getPluginManager().registerEvents(new player(), this);
        getServer().getPluginManager().registerEvents(new entity(), this);
    }

}
