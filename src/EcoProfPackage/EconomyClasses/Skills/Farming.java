package EcoProfPackage.EconomyClasses.Skills;

import org.bukkit.Bukkit;
import org.bukkit.CropState;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.ArrayList;

public class Farming {
    private int level; //Level represents the current level of the player's woodcutting skill
    private double xp; //XP represents the current xp a player has within a level
    private double xpReq; //XP required to get to next level. XP per level: 100*(1.2^(Level-1))
    private Player player; //Player represents the current player using this class
    private ArrayList<Material> validBlocks; //All valid blocks that can be broken to benefit this skill
    private ArrayList<EntityType> validEntity; //All valid Entity's that can be killed
    private ArrayList<Double> xpBlocks; //Corresponding XP for each valid block

    public Farming(Player player, int level, double xp)
    {
        this.player = player;
        this.level = level;
        this.xp = xp;
        xpReq = 100*Math.pow(1.2, level-1);
        validBlocks = new ArrayList<Material>();
        validEntity = new ArrayList<EntityType>();
        xpBlocks = new ArrayList<Double>();
        Material[] materials = {Material.WHEAT, Material.CARROT, Material.POTATO, Material.BEETROOT, Material.MELON, Material.PUMPKIN, Material.SUGAR_CANE, Material.BAMBOO, Material.CACTUS};
        EntityType[] entityType = {EntityType.SHEEP, EntityType.PIG, EntityType.COW, EntityType.CHICKEN};
        Double[] xps = {30.0, 30.0, 30.0, 30.0, 70.0, 70.0, 40.0, 20.0, 70.0};
        for(Material material : materials){
            validBlocks.add(material);
        }
        for(EntityType entityType1 : entityType){
            validEntity.add(entityType1);
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

        if(block.getState().equals(CropState.RIPE)) {
            int index = validBlocks.indexOf(material);
            addXP(xpBlocks.get(index));

        }
    }
    public void onKill(EntityDeathEvent event){
        LivingEntity livingEntity = event.getEntity();
        EntityType entityType = livingEntity.getType();

        if(!validEntity.contains(entityType)){return;}
        int index = validEntity.indexOf(entityType);

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
