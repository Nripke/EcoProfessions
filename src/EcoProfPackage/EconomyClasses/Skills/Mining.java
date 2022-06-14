package EcoProfPackage.EconomyClasses.Skills;

import EcoProfPackage.EconomyClasses.SkillHolder;
import EcoProfPackage.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import java.util.*;

public class Mining
{
    private int level; //Level represents the current level of the player's woodcutting skill
    private double xp; //XP represents the current xp a player has within a level
    private double xpReq; //XP required to get to next level. XP per level: 100*(1.2^(Level-1))
    private Player player; //Player represents the current player using this class
    private ArrayList<Material> validBlocks; //All valid blocks that can be broken to benefit this skill
    private ArrayList<Double> xpBlocks; //Corresponding XP for each valid block

    public Mining(Player player, int level, double xp)
    {
        this.player = player;
        this.level = level;
        this.xp = xp;
        xpReq = 100*Math.pow(1.2, level-1);
        validBlocks = new ArrayList<Material>();
        xpBlocks = new ArrayList<Double>();
        Material[] materials = {Material.STONE, Material.ANDESITE, Material.DIORITE, Material.GRANITE, Material.COAL_ORE, Material.IRON_ORE, Material.GOLD_ORE, Material.LAPIS_ORE, Material.REDSTONE_ORE, Material.DIAMOND_ORE, Material.EMERALD_ORE};
        Double[] xps = {10.0, 10.0, 10.0, 10.0, 30.0, 50.0, 70.0, 70.0, 70.0, 100.0, 200.0};
        for(Material material : materials){
            validBlocks.add(material);
        }
        for(double xpb : xps){
            xpBlocks.add(xpb);
        }
    }

    public void onBlockBroken(BlockBreakEvent event)
    {
        if (!event.getPlayer().getName().equals(player.getName())) {return;}

        Block block = event.getBlock();
        Material material = block.getType();

        if (!validBlocks.contains(material)) {return;}
        int index = validBlocks.indexOf(material);
        addXP(xpBlocks.get(index));
    }

    public void addXP(double amount)
    {
        if (xp+amount >= xpReq)
        {
            level++; //Later add a way to communicate this to the player
            Bukkit.getServer().broadcastMessage(player.getName() + " has achieved mining level " + level + "!");
            xp += (amount-xpReq);
            xpReq = 100*Math.pow(1.2, level-1);
            return;
        }
        xp += amount;
        //Bukkit.getServer().broadcastMessage(player.getName() + "'s mining xp is currently: " + xp);
    }

    public int getLevel() {
        return level;
    }

    public double getXp() {
        return xp;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setXp(double xp) {
        this.xp = xp;
    }

}
