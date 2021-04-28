package com.github.soramame0256.skthink.elements.classes;

import ch.njol.skript.classes.ClassInfo;
import ch.njol.skript.registrations.Classes;
import de.Keyle.MyPet.api.entity.MyPet;
import org.bukkit.Bukkit;

import java.util.logging.Level;

public class MyPetClass {

    static {
        if (Bukkit.getPluginManager().isPluginEnabled("MyPet")) {
            Bukkit.getLogger().log(Level.INFO, "RegisteringClass: MyPet");
            Classes.registerClass(new ClassInfo<>(MyPet.class, "mypet").user("mypet").name("MyPet").parser(new noparsable<>()));
        }
    }
}
