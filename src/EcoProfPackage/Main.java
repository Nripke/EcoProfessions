package EcoProfPackage;

import EcoProfPackage.Commands.CommandManager;
import EcoProfPackage.EconomyClasses.Skills.SkillsListener;
import EcoProfPackage.EconomyClasses.Skills.Woodcutting;
import EcoProfPackage.Listeners.PlayerJoinTest;
import EcoProfPackage.Manager.Manager;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
{
    //Read Config.yml
    private Manager manager;

    @Override
    public void onEnable()
    {
        CommandManager command = new CommandManager();
        getCommand("skills").setExecutor(command);

        manager = new Manager(this);
        //Need to read config.yml file

        getConfig().getKeys(false).forEach(key -> {
                //PlayerData pd = new PlayerData(this, key.get  );
           //manager.addPlayerData(pd);
        });
        getServer().getPluginManager().registerEvents(new PlayerJoinTest(this), this);
        getServer().getPluginManager().registerEvents(new SkillsListener(this), this);
        getLogger().info("~EcoProfessions Plugin has been ENABLED on this world~");
    }

    @Override
    public void onDisable()
    {
        getLogger().info("~EcoProfessions Plugin has been DISABLED on this world~");
    }

    public Main getPlugin()
    {
        return this;
    }

    public Manager getManager() {
        return manager;
    }
}
