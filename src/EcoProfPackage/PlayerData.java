package EcoProfPackage;

import EcoProfPackage.EconomyClasses.SkillHolder;
import EcoProfPackage.EconomyClasses.Skills.*;
import EcoProfPackage.Manager.Manager;
import org.bukkit.entity.Player;
import java.util.*;

public class PlayerData
{
    private Player p;
    private double money;
    private final Main plugin;
    private SkillHolder sh;

    //private Profession prof; <-- NEED TO ADD: Profession Class
    //NEED TO ADD: Nation

    public PlayerData(Manager plugin, Player player, double money)
    {
        this.plugin = plugin.getPlugin();
        this.p = player;
        this.money = money;
        this.sh = new SkillHolder(this, new Woodcutting(p, 1, 0), new Mining(p, 1, 0), new Hunting(p, 1, 0), new Farming(p, 1, 0));
    }

    public Player getPlayer()
    {
        return p;
    }

    public double getMoney()
    {
        return money;
    }

    //Method for ease of subtracting/adding money
    public void changeMoney(double difference, double sign)
    {
        money += difference*sign;
    }

    public void setMoney(double money)
    {
        this.money = money;
    }

    public void setPlayer(Player player) {
        this.p = player;

    }
    public SkillHolder getSH()
    {
        return sh;
    }

}

//I think for the yml file, we want the "path" to be the name of the player or the UUID
//And then the information to be this object
//DONT CONJUGATE "HE WILL GO" IN FRENCH AT 3 AM