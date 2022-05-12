package me.almana.mapsplus.Utls;

import org.bukkit.entity.Player;
import org.bukkit.map.MapCanvas;
import org.bukkit.map.MapPalette;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;
import org.jetbrains.annotations.NotNull;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class CustomRenderer extends MapRenderer {

    String imageURL;
    BufferedImage image;

    public CustomRenderer(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public void render(@NotNull MapView map, @NotNull MapCanvas canvas, @NotNull Player player) {

        try {
            URL url = new URL(imageURL);
            image = ImageIO.read(url);
            canvas.drawImage(0, 0, MapPalette.resizeImage(image));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
