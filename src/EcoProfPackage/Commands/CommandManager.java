package EcoProfPackage.Commands;

import EcoProfPackage.EconomyClasses.SkillHolder;
import EcoProfPackage.Manager.Manager;
import EcoProfPackage.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandManager implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if (!(sender instanceof Player)) // If person executing command is not a player, stop method
        {
            return true;
        }

        Player plr = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("skills"))
        {
            if (args.length == 0) {return true;}
            if (args[0].equals("stats"))
            {
                SkillHolder sh = Manager.getPD(plr).getSH();
                plr.sendMessage(ChatColor.DARK_GREEN + "Skills Info:");
                plr.sendMessage("");
                plr.sendMessage(ChatColor.DARK_GREEN + "Woodcutting Level: " + ChatColor.GREEN + sh.getWC().getLevel());
                plr.sendMessage(ChatColor.DARK_GREEN + "Woodcutting XP: " + ChatColor.GREEN + Math.floor(sh.getWC().getXp()) + "/" + ChatColor.DARK_GREEN + Math.floor(sh.getWC().getXpReq()));
                plr.sendMessage(ChatColor.BLACK + "- - - - - - - - - - - - - - - - -");

                plr.sendMessage(ChatColor.DARK_GREEN + "Mining Level: " + ChatColor.GREEN + sh.getMin().getLevel());
                plr.sendMessage(ChatColor.DARK_GREEN + "Mining XP: " + ChatColor.GREEN + Math.floor(sh.getMin().getXp()) + "/" + ChatColor.DARK_GREEN + Math.floor(sh.getMin().getXpReq()));
                plr.sendMessage(ChatColor.BLACK + "- - - - - - - - - - - - - - - - -");

                plr.sendMessage(ChatColor.DARK_GREEN + "Hunting Level: " + ChatColor.GREEN + sh.getHun().getLevel());
                plr.sendMessage(ChatColor.DARK_GREEN + "Hunting XP: " + ChatColor.GREEN + Math.floor(sh.getHun().getXp()) + "/" + ChatColor.DARK_GREEN + Math.floor(sh.getHun().getXpReq()));
                plr.sendMessage(ChatColor.BLACK + "- - - - - - - - - - - - - - - - -");

                plr.sendMessage(ChatColor.DARK_GREEN + "Farming Level: " + ChatColor.GREEN + sh.getFarm().getLevel());
                plr.sendMessage(ChatColor.DARK_GREEN + "Farming XP: " + ChatColor.GREEN + Math.floor(sh.getFarm().getXp()) + "/" + ChatColor.DARK_GREEN + Math.floor(sh.getFarm().getXpReq()));
                return true;
            }
        }

        return false;
    }
}
