package EcoProfPackage.CustomItems;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemManager {
    public static ItemStack totem;


    public void getCrafting(){
        itemCollector();}

    public static void itemCollector(){
        explodingPick();
        emeraldPick();
    }

    private static void explodingPick(){
        ItemStack item = new ItemStack(Material.STONE_PICKAXE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_RED +"Exploding Pick");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GOLD + "This Item is from ancient times. Only used my the minecraft Elders to revive its fallen.");
        lore.add(ChatColor.GOLD + "It has traveled to many realms looking for a suitable host to use its magic.");
        lore.add(ChatColor.GRAY + "But it has consequences, as it does not give a lot of XP :O");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LURE, 1,false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);


        item.setItemMeta(meta);

        totem = item;

        //Shaped Recipe
        ShapedRecipe shapedRecipe = new ShapedRecipe(NamespacedKey.minecraft( "explodingPick"), item);
        shapedRecipe.shape("EEE", " D ", " D ");

        shapedRecipe.setIngredient('E', Material.TNT);
        shapedRecipe.setIngredient('D', Material.DIAMOND);

        Bukkit.getServer().addRecipe(shapedRecipe);
    }
    private static void emeraldPick(){
        ItemStack item = new ItemStack(Material.DIAMOND_PICKAXE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_GREEN +"Emerald Pick");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GOLD + "This Item gives the user a big buff, greater then a diamond pickaxe.");

        meta.setLore(lore);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4,false);
        meta.addEnchant(Enchantment.DURABILITY, 4,false);
        meta.addEnchant(Enchantment.DIG_SPEED, 5,false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);


        item.setItemMeta(meta);

        totem = item;

        //Shaped Recipe
        ShapedRecipe shapedRecipe = new ShapedRecipe(NamespacedKey.minecraft( "explodingPick"), item);
        shapedRecipe.shape("EEE", " D ", " D ");

        shapedRecipe.setIngredient('E', Material.EMERALD_BLOCK);
        shapedRecipe.setIngredient('D', Material.DIAMOND_PICKAXE);

        Bukkit.getServer().addRecipe(shapedRecipe);
    }


}
