package fr.thibma.dragonrush.commands;

import fr.thibma.dragonrush.DragonRush;
import fr.thibma.dragonrush.classes.ClassEnums;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TabCompleter implements org.bukkit.command.TabCompleter {

    @Nullable
    @Override
    public List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String arg, @NotNull String[] args) {
        List<String> completionList = new ArrayList<>();

        if (command.getName().equalsIgnoreCase("class")) {
            if (args.length == 1) {
                for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                    completionList.add(player.getDisplayName());
                    return completionList;
                }
            }
            else if (args.length == 2) {
                completionList.addAll(List.of(
                        "add",
                        "remove",
                        "level",
                        "getSkills"
                ));
                return completionList;
            }
            else if (args.length == 3) {
                if (args[1].equalsIgnoreCase("add")) {
                    for (ClassEnums classEnums : ClassEnums.values()) {
                        completionList.add(classEnums.toString());
                    }
                    return completionList;
                }
                else if (args[1].equalsIgnoreCase("level")) {
                    completionList.addAll(List.of(
                            "1",
                            "2",
                            "3"
                    ));
                    return completionList;
                }
            }
        }

        return null;
    }

}
