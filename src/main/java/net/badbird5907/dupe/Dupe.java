package net.badbird5907.dupe;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public final class Dupe extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            ItemStack itemStack = ((Player) sender).getInventory().getItemInMainHand();
            if (itemStack != null && !itemStack.getType().isAir()){
                if(itemStack.getType() == Material.ENCHANTED_GOLDEN_APPLE){
                    sender.sendMessage(ChatColor.RED + "fuck you");
                    return true;
                }
                ((Player) sender).getInventory().addItem(itemStack);
            }
        }else{
            sender.sendMessage("idiot");
        }
        return true;
    }
}
