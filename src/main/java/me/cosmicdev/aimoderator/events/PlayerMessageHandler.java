package me.cosmicdev.aimoderator.events;

import me.cosmicdev.aimoderator.model.Model;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

public class PlayerMessageHandler implements Listener {

    @EventHandler
    public void onPlayerMessage(PlayerChatEvent event) {
        Player player = event.getPlayer();
        String message = event.getMessage();
        double sensitivity = 0.8;
        int response = Model.callModel(message, sensitivity);

        if (response == 1) {
            event.setCancelled(true);
            Bukkit.broadcastMessage(ChatColor.YELLOW + player.getName() + ChatColor.RED + " Sent an inappropriate message!");
            player.sendMessage(ChatColor.RED + "The following message contains profanity. This is not allowed! " + ChatColor.WHITE + message);
        }
    }

}
