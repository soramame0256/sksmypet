package com.github.soramame0256.sksmypet.elements.Mypet;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Literal;
import ch.njol.skript.lang.SkriptEvent;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.registrations.EventValues;
import ch.njol.skript.util.Getter;
import de.Keyle.MyPet.api.entity.MyPet;
import de.Keyle.MyPet.api.event.MyPetDamageEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.jetbrains.annotations.Nullable;

import java.util.logging.Level;

public class EvtPetDamage extends SkriptEvent {

    static {
        if (Bukkit.getPluginManager().isPluginEnabled("MyPet")) {
            Bukkit.getLogger().log(Level.INFO, "LoadingEvent: mypetdamage");
            Skript.registerEvent("mypet damage", EvtPetDamage.class, MyPetDamageEvent.class, "mypet damage")
                    .description("ペットがダメージを与えたときに呼び出されます");
            EventValues.registerEventValue(MyPetDamageEvent.class, Player.class, new Getter<Player, MyPetDamageEvent>() {
                @Nullable
                @Override
                public Player get(MyPetDamageEvent arg) {
                    return arg.getOwner().getPlayer();
                }
            },0);
            EventValues.registerEventValue(MyPetDamageEvent.class, MyPet.class, new Getter<MyPet, MyPetDamageEvent>() {
                @Nullable
                @Override
                public MyPet get(MyPetDamageEvent arg) {
                    return null;
                }
            },0);
        }
    }
    @Override
    public boolean init(Literal<?>[] args, int matchedPattern, SkriptParser.ParseResult parseResult) {
        return true;
    }

    @Override
    public boolean check(Event e) {
        return true;
    }

    @Override
    public String toString(@Nullable Event e, boolean debug) {
        return " ";
    }
}
