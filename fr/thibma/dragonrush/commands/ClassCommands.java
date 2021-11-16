package fr.thibma.dragonrush.commands;

import fr.thibma.dragonrush.DragonRush;
import fr.thibma.dragonrush.classes.Class;
import fr.thibma.dragonrush.classes.ClassEnums;
import fr.thibma.dragonrush.events.AddClassEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ClassCommands implements CommandExecutor {

    private final String usage = ChatColor.RED + "Utilisation: " + ChatColor.YELLOW + "/class <player>";
    private final String addUsage = ChatColor.YELLOW + "add <class>";
    private final String removeUsage = ChatColor.YELLOW + "remove";
    private final List<String> args = new ArrayList<>(
            List.of(usage,
                    addUsage,
                    removeUsage,
                    ChatColor.YELLOW + "level <1, 2, 3>",
                    ChatColor.YELLOW + "getSkills"));


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender.hasPermission("dragonrush.class")) {
            if (args.length == 0) {
                sender.sendMessage(usage);
                return false;
            }
            else if (args.length > 1) {
                Player target = Bukkit.getPlayerExact(args[0]);
                if (target != null) {
                    if (args[1].equalsIgnoreCase("add")) {
                        try {
                            ClassEnums classEnums = ClassEnums.valueOf(args[2]);
                            sender.sendMessage("Ajout d'une classe ok");
                            Bukkit.getServer().getPluginManager().callEvent(new AddClassEvent(target, classEnums));
                            return true;
                        }
                        catch (IllegalArgumentException e) {
                            sender.sendMessage(usage);
                            sender.sendMessage(addUsage);
                            sender.sendMessage(ChatColor.RED + "Classes disponibles :");
                            for (ClassEnums classes : ClassEnums.values()) {
                                sender.sendMessage(ChatColor.GREEN + classes.toString());
                            }
                            return false;
                        }
                    }
                    else if (args[1].equalsIgnoreCase("remove")) {
                        if (DragonRush.classes.getPlayerClass(target) != null) {
                            DragonRush.classes.removePlayerClass(target);
                            return true;
                        }
                        else {
                            sender.sendMessage(ChatColor.RED + "Ce joueur ne possède pas de classe.");
                            return false;
                        }
                    }
                    else if (args[1].equalsIgnoreCase("level")) {
                        if (DragonRush.classes.getPlayerClass(target) == null) {
                            sender.sendMessage(ChatColor.RED + "Ce joueur ne possède pas de classe.");
                            return false;
                        }
                        switch (Integer.parseInt(args[2])) {
                            case 1 -> DragonRush.classes.getPlayerClass(target).setLevel(1);
                            case 2 -> DragonRush.classes.getPlayerClass(target).setLevel(2);
                            case 3 -> DragonRush.classes.getPlayerClass(target).setLevel(3);
                            default -> {
                                sender.sendMessage(ChatColor.RED + "Ce joueur ne possède pas de classe.");
                                return false;
                            }
                        }
                        sender.sendMessage(ChatColor.GREEN + "Le niveau de " + target.getDisplayName() + " a bien été modifié.");
                        return true;
                    }
                    else if (args[1].equalsIgnoreCase("getSkills")) {
                        if (DragonRush.classes.getPlayerClass(target) == null) {
                            sender.sendMessage(ChatColor.RED + "Ce joueur ne possède pas de classe.");
                            return false;
                        }
                        sender.sendMessage(ChatColor.GREEN + "Les skills ont bien été ajoutés.");
                        DragonRush.classes.getPlayerClass(target).addSkills();
                        return true;
                    }
                    else {
                        for (String message : args) {
                            sender.sendMessage(message);
                            return false;
                        }
                    }
                }
            }
            else {
                for (String arguments : this.args) {
                    sender.sendMessage(arguments);
                    return false;
                }
            }
        }
        return false;
    }
}
