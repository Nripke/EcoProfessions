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

    public static void itemCollector(){//Gathers all the Custom Items Made so it is easy to look at.
        explodingPick();
    }

    private static void explodingPick(){
        //Makes a new Custom item with lore, enchantment and a recipe.
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



}
