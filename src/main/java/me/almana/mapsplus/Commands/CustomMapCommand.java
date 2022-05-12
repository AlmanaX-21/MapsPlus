package me.almana.mapsplus.Commands;

import me.almana.mapsplus.MapsPlus;
import me.almana.mapsplus.Utls.MapUtil;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class CustomMapCommand implements CommandExecutor {

    Plugin plugin = MapsPlus.getPlugin();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player player) {

            if (args.length > 0) {

                ItemStack map = MapUtil.makeMap(player, args[0]);
                TextComponent message = Component.text("[MapsPlus] ").color(TextColor.color(37, 105, 255))
                        .append(Component.text("Custom map generated.").color(TextColor.color(109, 160, 77)));
                TextComponent warn = Component.text("[MapsPlus] ").color(TextColor.color(37, 105, 255))
                                .append(Component.text("Use 128 by 128 images or performance could hinder.").color(TextColor.color(251, 193, 63)));
                player.sendMessage(message);
                player.sendMessage(warn);
                player.getInventory().addItem(map);
            } else {

                TextComponent error = Component.text("[MapsPlus] ").color(TextColor.color(37, 105, 255))
                        .append(Component.text("You need to provide a url.").color(TextColor.color(245, 0, 11)));
                player.sendMessage(error);
            }
        }
        return true;
    }
}
