package me.nightkungz.enhancedcustomblock;

import dev.dejvokep.boostedyaml.YamlDocument;
import dev.dejvokep.boostedyaml.dvs.versioning.BasicVersioning;
import dev.dejvokep.boostedyaml.settings.dumper.DumperSettings;
import dev.dejvokep.boostedyaml.settings.general.GeneralSettings;
import dev.dejvokep.boostedyaml.settings.loader.LoaderSettings;
import dev.dejvokep.boostedyaml.settings.updater.UpdaterSettings;
import me.nightkungz.enhancedcustomblock.event.CustomBlockListener;
import org.bukkit.plugin.java.JavaPlugin;
import redempt.redlib.blockdata.custom.CustomBlock;

import java.io.File;
import java.io.IOException;

public final class EnhancedCustomBlock extends JavaPlugin {

    private YamlDocument config;

    @Override
    public void onEnable() {

        try {
            config = YamlDocument.create(new File(getDataFolder(), "config.yml"), getResource("config.yml"),
                    GeneralSettings.DEFAULT, LoaderSettings.builder().setAutoUpdate(true).build(), DumperSettings.DEFAULT,
                    UpdaterSettings.builder().setVersioning(new BasicVersioning("config-version")).build());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        getServer().getPluginManager().registerEvents(new CustomBlockListener(this), this);
    }

    public YamlDocument getConfiguration() {
        return config;
    }

}
