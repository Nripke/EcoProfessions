package EcoProfPackage.Listeners;

import EcoProfPackage.EconomyClasses.Skills.Woodcutting;
import EcoProfPackage.Main;
import EcoProfPackage.Manager.Manager;
import EcoProfPackage.PlayerData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinTest implements Listener
{
    private Main m;

    public PlayerJoinTest(Main nM)
    {
        m = nM;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent p)
    {
        String name = p.getPlayer().getName();
        //This sees if there is already a player in the game

        //Made a Manager Class to manage

        if(m.getManager().getPlayerDataList() != null) {// So there is no exception
            for (PlayerData playerData : m.getManager().getPlayerDataList()) {
                if ((playerData.getPlayer().getName().equals(name))) {
                    return;
                }
            }
        }

        PlayerData pd = new PlayerData(m.getManager(), p.getPlayer(), 0);



        m.getManager().addPlayerData(pd);
//        m.getPlugin().getConfig().createSection(name).set(name, pd);
//        m.getPlugin().getConfig().getConfigurationSection(name).createSection("level");
//        m.getPlugin().getConfig().getConfigurationSection("level").set(name + " level " + /*this will be the level*/);
//        m.getPlugin().getConfig().set(name, pd);
       // m.saveConfig();
    }

}
