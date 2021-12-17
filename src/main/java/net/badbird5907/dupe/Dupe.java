package net.badbird5907.dupe;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.block.ShulkerBox;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;
import org.bukkit.inventory.meta.BundleMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public final class Dupe extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    Set<Material> materials = Arrays.asList(Material.DRAGON_EGG,Material.ENCHANTED_GOLDEN_APPLE,Material.WRITTEN_BOOK,Material.BUNDLE).stream().collect(Collectors.toSet());
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            ItemStack itemStack = ((Player) sender).getInventory().getItemInMainHand();
            if (itemStack != null && !itemStack.getType().isAir()){
                if(itemStack.getItemMeta() instanceof BlockStateMeta){
                    BlockStateMeta im = (BlockStateMeta) itemStack.getItemMeta();
                    if(im.getBlockState() instanceof ShulkerBox){
                        ShulkerBox shulker = (ShulkerBox) im.getBlockState();
                        for (ItemStack content : shulker.getInventory().getContents()) {
                            if (content != null && !content.getType().isAir()){
                                if(materials.contains(content.getType())){
                                    sender.sendMessage(ChatColor.RED + "fuck you");
                                    return true;
                                }
                            }
                        }
                    }
                }
                if (itemStack.getItemMeta() instanceof BundleMeta){
                    BundleMeta im = (BundleMeta) itemStack.getItemMeta();
                    for (ItemStack content : im.getItems()) {
                        if (content != null && !content.getType().isAir()){
                            if(materials.contains(content.getType())){
                                sender.sendMessage(ChatColor.RED + "fuck you");
                                return true;
                            }
                        }
                    }
                }
                if(materials.contains(itemStack.getType())){
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
