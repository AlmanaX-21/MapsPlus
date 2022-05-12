package me.almana.mapsplus.Commands;

import me.almana.mapsplus.MapsPlus;
import me.almana.mapsplus.Utls.MapUtil;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class LogoCommand implements CommandExecutor {

    Plugin plugin = MapsPlus.getPlugin();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player player) {

            if (args.length > 0) {

                String name = String.join(" ", args);

                ItemStack map = MapUtil.makeMap(player, plugin.getConfig().getString("LOGO"));
                map.getItemMeta().displayName(LegacyComponentSerializer.legacyAmpersand().deserialize(name));

                TextComponent message = Component.text("[MapsPlus] ").color(TextColor.color(37, 105, 255))
                        .append(Component.text("Server logo generated.").color(TextColor.color(128, 193, 88)));
                player.sendMessage(message);
                player.getInventory().addItem(map);
            } else {

                TextComponent error = Component.text("[MapsPlus] ").color(TextColor.color(37, 105, 255))
                        .append(Component.text("Provide a name.").color(TextColor.color(117, 48, 71)));
                player.sendMessage(error);
            }
        }
        return true;
    }
}
