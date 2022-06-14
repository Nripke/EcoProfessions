package EcoProfPackage.EconomyClasses.Skills;

import EcoProfPackage.EconomyClasses.SkillHolder;
import EcoProfPackage.Main;
import EcoProfPackage.Manager.Manager;
import EcoProfPackage.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;

public class SkillsListener implements Listener
{
    private Main m;

    public SkillsListener(Main nM)
    {
        m = nM;
    }

    @EventHandler
    public void onBlockBroken(BlockBreakEvent event)
    {
        SkillHolder sh = m.getManager().getPD(event.getPlayer()).getSH();
        Bukkit.getServer().broadcastMessage(event.getPlayer() + " broke " + event.getBlock().getType());
        sh.getWC().onBlockBroken(event);
        sh.getMin().onBlockBroken(event);
        sh.getFarm().onBlockBroken(event);

    }

    @EventHandler
    public void onKill(EntityDeathEvent event){
        LivingEntity entity = event.getEntity();
        Player posPlayer = entity.getKiller();
        if(posPlayer == null) {return;}
        SkillHolder sh = m.getManager().getPD(posPlayer).getSH();
        Bukkit.getServer().broadcastMessage(event.getEntity().getKiller() + " killed " + event.getEntity().getType());
        sh.getHun().onKill(event);
        sh.getFarm().onKill(event);
    }
}
