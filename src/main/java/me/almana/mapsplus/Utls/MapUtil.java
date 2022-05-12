package me.almana.mapsplus.Utls;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.MapMeta;
import org.bukkit.map.MapView;

public class MapUtil {

    public static ItemStack makeMap(Player player, String imageURL) {

        ItemStack itemStack = new ItemStack(Material.FILLED_MAP);
        MapMeta mapMeta = (MapMeta) itemStack.getItemMeta();

        MapView mapView = Bukkit.createMap(player.getWorld());

        mapView.getRenderers().clear();

        CustomRenderer renderer = new CustomRenderer(imageURL);

        mapView.addRenderer(renderer);

        mapMeta.setMapView(mapView);

        itemStack.setItemMeta(mapMeta);

        return itemStack;
    }
}
