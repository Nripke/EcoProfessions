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
        teleportationSword();
        gravitationalUraniumBlaster();
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


    private static void teleportationSword(){
        ItemStack item = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName( ChatColor.MAGIC + "XX" + ChatColor.BOLD+ ChatColor.DARK_PURPLE + "Teleportation Sword" + ChatColor.MAGIC + "XX");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.DARK_AQUA + "This Item gives the user access through teleportation");

        meta.setLore(lore);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4,false);
        meta.addEnchant(Enchantment.DURABILITY, 4,false);
        meta.addEnchant(Enchantment.DAMAGE_ALL, 1,false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);


        item.setItemMeta(meta);

        totem = item;

        //Shaped Recipe
        ShapedRecipe shapedRecipe = new ShapedRecipe(NamespacedKey.minecraft( "teleportationSword"), item);
        shapedRecipe.shape("EDE", "CDC", "ESE");

        shapedRecipe.setIngredient('E', Material.ENDER_PEARL);
        shapedRecipe.setIngredient('D', Material.DIAMOND_SWORD);
        shapedRecipe.setIngredient('C', Material.END_CRYSTAL);
        shapedRecipe.setIngredient('S', Material.STICK);

        Bukkit.getServer().addRecipe(shapedRecipe);
    }

    private static void gravitationalUraniumBlaster(){
        ItemStack item = new ItemStack(Material.IRON_HORSE_ARMOR, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName( ChatColor.MAGIC + "XX" + ChatColor.BOLD+ ChatColor.GREEN + "Gravitational Uranium Blaster" + ChatColor.MAGIC + "XX");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.DARK_AQUA + "This Item is one of the best Items. It has the power to destroy your enemies in seconds.");

        meta.setLore(lore);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4,false);
        meta.addEnchant(Enchantment.DURABILITY, 4,false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);


        item.setItemMeta(meta);

        totem = item;

        //Shaped Recipe
        ShapedRecipe shapedRecipe = new ShapedRecipe(NamespacedKey.minecraft( "gravitationaluraniumblaster"), item);
        shapedRecipe.shape("EDE", "DDD", " S ");

        shapedRecipe.setIngredient('E', Material.IRON_HORSE_ARMOR);
        shapedRecipe.setIngredient('D', Material.EMERALD_BLOCK);
        shapedRecipe.setIngredient('S', Material.STICK);

        Bukkit.getServer().addRecipe(shapedRecipe);
    }



}
