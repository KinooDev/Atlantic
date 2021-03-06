package me.scifi.hcf.command;

import me.scifi.hcf.HCF;
import me.scifi.hcf.Utils;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.swing.text.PlainDocument;

public class GMSCommand implements CommandExecutor {

    private HCF plugin;

    public GMSCommand(HCF plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission(command.getPermission())){
                p.setGameMode(GameMode.SURVIVAL);
                p.sendMessage(Utils.chat(plugin.messagesYML.getString("GAMEMODE-CHANGED-SURVIVAL")));
                return true;
            }
        }
        sender.sendMessage(Utils.chat("&cOnly players may use this command."));
        return false;
    }
}
