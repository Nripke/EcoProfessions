package EcoProfPackage.EconomyClasses;

import EcoProfPackage.Main;
import EcoProfPackage.PlayerData;
import org.bukkit.entity.Player;

public class Professions {


    private final Main plugin;
    private Player player;


    public Professions(Main plugin, PlayerData playerData){
        this.plugin = plugin;
        this.player = playerData.getPlayer();
    }

    public Player getPlayer(){
        return player;
    }


}
