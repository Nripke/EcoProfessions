package EcoProfPackage.Manager;

import EcoProfPackage.Main;
import EcoProfPackage.PlayerData;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Manager {
    private final Main plugin;

    private List<PlayerData> playerDataList;


    /*
    *This will manage the PlayerData, so it is not messy in the main class
    *
    *
    */

    public Manager(Main plugin){
        this.plugin = plugin;
        this.playerDataList = new ArrayList<>();
    }

    public Main getPlugin(){
        return plugin;
    }


    public void addPlayerData(PlayerData playerData) {
        this.playerDataList.add(playerData);
    }

    public List<PlayerData> getPlayerDataList() {
        return playerDataList;
    }

    public PlayerData getPD(Player player)
    {
        for (PlayerData pd : playerDataList)
        {
            if (pd.getPlayer().getName().equals(player.getName()))
            {
                return pd;
            }
        }
        return null;
    }
}
