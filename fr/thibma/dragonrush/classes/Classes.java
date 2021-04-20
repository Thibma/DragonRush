package fr.thibma.dragonrush.classes;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Classes {

    private List<Class> classList = new ArrayList<>();

    public List<Class> getClassList() { return classList; }

    public void addClass(Class newClass) {
        Class getPlayerClass = this.getPlayerClass(newClass.getPlayer());

        if (getPlayerClass != null) {
            getPlayerClass.destructor();
            this.classList.remove(getPlayerClass);
        }

        this.classList.add(newClass);
    }

    public Class getPlayerClass(Player player) {
        for (Class getClass : this.getClassList()) {
            if (player == getClass.getPlayer()) {
                return getClass;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "classList=" + classList +
                '}';
    }
}
