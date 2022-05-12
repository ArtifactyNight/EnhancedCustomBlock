package me.nightkungz.enhancedcustomblock.event;

import dev.dejvokep.boostedyaml.YamlDocument;
import me.nightkungz.enhancedcustomblock.EnhancedCustomBlock;
import me.nightkungz.enhancedcustomblock.util.ColorUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

import java.io.IOException;

public class CustomBlockListener implements Listener {

    private EnhancedCustomBlock plugin;

    private YamlDocument config = plugin.getConfiguration();
    public CustomBlockListener(EnhancedCustomBlock plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerPlacesCustomBlock(BlockPlaceEvent event) throws IOException {

        Player player = event.getPlayer();
        ItemStack item = event.getItemInHand();

        config.getOptionalString("message").ifPresent(
                (message) -> player.sendMessage(ColorUtil.color(message)));
    }
}
