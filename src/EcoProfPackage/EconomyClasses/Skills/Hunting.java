package EcoProfPackage.EconomyClasses.Skills;

import EcoProfPackage.EconomyClasses.SkillHolder;
import EcoProfPackage.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import java.util.*;

public class Hunting
{
    private int level; //Level represents the current level of the player's woodcutting skill

    private double xp; //XP represents the current xp a player has within a level
    private double xpReq; //XP required to get to next level. XP per level: 100*(1.2^(Level-1))
    private Player player; //Player represents the current player using this class
    private ArrayList<EntityType> validEntities; //All valid entities that can be broken to benefit this skill
    private ArrayList<Double> xpEntity; //Corresponding XP for each valid entity

    public Hunting(Player player, int level, double xp)
    {
        this.player = player;
        this.level = level;
        this.xp = xp;
        xpReq = 100*Math.pow(1.2, level-1);
        validEntities = new ArrayList<EntityType>();
        xpEntity = new ArrayList<Double>();
        EntityType[] entities = {EntityType.ZOMBIE, EntityType.SKELETON, EntityType.SPIDER, EntityType.CREEPER, EntityType.ENDERMAN};
        Double[] xps = {30.0, 30.0, 30.0, 50.0, 100.0};
        for(EntityType entity : entities){
            validEntities.add(entity);
        }
        for(double xpb : xps){
            xpEntity.add(xpb);
        }
    }

    public void onKill(EntityDeathEvent event){
        EntityType livingEntity = event.getEntityType();
        Player player = event.getEntity().getKiller();

        if (!validEntities.contains(livingEntity)){return;}
        int index = validEntities.indexOf(livingEntity);

        addXP(xpEntity.get(index));
    }

    public void addXP(double amount)
    {
        if (xp+amount >= xpReq)
        {
            level++; //Later add a way to communicate this to the player
            //Bukkit.getServer().broadcastMessage(player.getName() + " has achieved hunting level " + level + "!");
            xp += (amount-xpReq);
            xpReq = 100*Math.pow(1.2, level-1);
            return;
        }
        xp += amount;
        //Bukkit.getServer().broadcastMessage(player.getName() + "'s hunting xp is currently: " + xp);
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

    public double getXpReq() {return xpReq;}
}
