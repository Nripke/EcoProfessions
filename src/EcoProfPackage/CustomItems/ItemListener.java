package EcoProfPackage.CustomItems;

import EcoProfPackage.Main;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Objects;

public class ItemListener implements Listener {
    private final Main plugin;
    public ItemListener(Main plugin){
        this.plugin = plugin;
    }

        @EventHandler
        public void onSwing(PlayerInteractEvent e) {
            if (!e.hasItem())return;
            if (!Objects.requireNonNull(e.getItem()).hasItemMeta())return;
            explodingPick(e);
            emeraldPick(e);
            teleportationSword(e);
            gravitationalUraniumBlaster(e);
        }
        public void explodingPick(@NotNull PlayerInteractEvent e){
            if (e.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
                Player player = e.getPlayer();
                World world = player.getWorld();
                String itemsName = Objects.requireNonNull(player.getInventory().getItemInMainHand().getItemMeta()).getDisplayName();
                if (player.getInventory().getItemInMainHand().getType() == Material.STONE_PICKAXE && itemsName.equals("Exploding Pick")) {
                    Location location = player.getLocation();
                    Objects.requireNonNull(Bukkit.getServer().getWorld(world.getName())).createExplosion(location.add( 2,0,0),2,true, false);
                    plugin.getManager().getPD(player).getSH().getMin().addXP(50);
                }
            }
        }
        public void emeraldPick(@NotNull PlayerInteractEvent e){
            if (e.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
                Player player = e.getPlayer();
                String itemsName = Objects.requireNonNull(player.getInventory().getItemInMainHand().getItemMeta()).getDisplayName();
                if (player.getInventory().getItemInMainHand().getType() == Material.DIAMOND_PICKAXE && itemsName.equals("Emerald Pick")) {
                    PotionEffect potionEffect = new PotionEffect(PotionEffectType.FAST_DIGGING, 2, 4, false,false,false);
                    player.addPotionEffect(potionEffect);
                }
            }
        }
        public void teleportationSword(@NotNull PlayerInteractEvent e){
            if (e.getAction().equals(Action.RIGHT_CLICK_AIR)) {
                Player player = e.getPlayer();
                Location loc = player.getEyeLocation();
                Vector vector = loc.getDirection();
                String itemsName = Objects.requireNonNull(player.getInventory().getItemInMainHand().getItemMeta()).getDisplayName();
                if (player.getInventory().getItemInMainHand().getType() == Material.DIAMOND_SWORD && itemsName.equals("Teleportation Sword")) {
                    Location location = loc.clone();
                    Vector vec = vector.normalize().multiply(0.2);
                    int i = 0;
                    while(i <= 10){
                        location.add(vec);
                        if(location.getBlock().getType() != Material.AIR){
                            player.teleport(location);
                            Location loc1 = player.getLocation().add(0,5,0);
                            player.spawnParticle(Particle.DRIPPING_OBSIDIAN_TEAR, loc1,15);
                            player.playSound(location, Sound.ENTITY_ENDERMAN_TELEPORT, 3,3);
                        }
                        i+=0.2;
                    }
                }
            }
        }
        public void gravitationalUraniumBlaster(@NotNull PlayerInteractEvent e){
            String itemsName = Objects.requireNonNull(e.getPlayer().getInventory().getItemInMainHand().getItemMeta()).getDisplayName();
            Player player = e.getPlayer();
            if (e.getAction().equals(Action.LEFT_CLICK_AIR) && player.getInventory().getItemInMainHand().getType() == Material.IRON_HORSE_ARMOR && itemsName.equals("Gravitational Uranium Blaster")) {
                Location loc = player.getEyeLocation();
                Location location = loc.clone();
                Vector vector = loc.getDirection();
                Vector vec = vector.normalize().multiply(0.2);
                double i = 0;
                while(i <= 10){
                    location.add(vec);
                    Collection<Entity> entities = Objects.requireNonNull(Bukkit.getServer().getWorld(player.getWorld().getName())).getNearbyEntities(location,1,1,1);
                    if(entities != null){
                        for(Entity entity : entities){
                            if (entity instanceof LivingEntity){
                                LivingEntity livingEntity = (LivingEntity) entity;
                                livingEntity.damage(4);
                                if(livingEntity instanceof Player){
                                    Player hit = (Player) livingEntity;
                                    hit.spawnParticle(Particle.REDSTONE, player.getEyeLocation(), 5,1);
                                }
                            }
                        }
                    }
                    if(location.getBlock().getType() != Material.AIR){
                        Objects.requireNonNull(Bukkit.getServer().getWorld(player.getWorld().getName())).createExplosion(location, 1,false,false);
                        return;
                    }
                    player.spawnParticle(Particle.TOTEM, location, 2);
                    player.playSound(location, Sound.ENTITY_GUARDIAN_ATTACK, 2,2);
                    i += 0.2;
                }
                return;
            }
            if(e.getAction().equals(Action.RIGHT_CLICK_AIR) && player.getInventory().getItemInMainHand().getType() == Material.IRON_HORSE_ARMOR && itemsName.equals("Gravitational Uranium Blaster")){
                player.setWalkSpeed(-0.25F);//Makes the zoom effect.
            }else{
                player.setWalkSpeed(0.2F);//Undoes the zoom effect.
            }
        }
}
