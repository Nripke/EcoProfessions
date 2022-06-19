package EcoProfPackage.CustomItems;

import EcoProfPackage.Main;
import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Locale;
import java.util.Objects;

public class ItemListener implements Listener {

    private final Main plugin;
    public ItemListener(Main plugin){


        this.plugin = plugin;
    }
        @EventHandler
        public void onSwing(PlayerInteractEvent e){
            if(!e.hasItem()){
                return;
            }
            if(!e.getItem().hasItemMeta()){
                return;
            }
                if (e.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
                    Player player = e.getPlayer();
                    World world = player.getWorld();
                    String itemsName = player.getInventory().getItemInMainHand().getItemMeta().getDisplayName();
                    if (player.getInventory().getItemInMainHand().getType() == Material.STONE_PICKAXE && itemsName.equals("Exploding Pick")) {
                        Location location = player.getLocation();
                        Objects.requireNonNull(Bukkit.getServer().getWorld(world.getName())).createExplosion(location.add( 2,0,0),2,true, false);
                        plugin.getManager().getPD(player).getSH().getMin().addXP(50);
                    }
                    return;
                        }

                    }
        }
