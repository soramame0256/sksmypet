package com.github.soramame0256.sksmypet.elements.Mypet.Event;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Literal;
import ch.njol.skript.lang.SkriptEvent;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.registrations.EventValues;
import ch.njol.skript.util.Getter;
import de.Keyle.MyPet.api.entity.MyPet;
import de.Keyle.MyPet.api.event.MyPetExpEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.jetbrains.annotations.Nullable;

import java.util.logging.Level;

@SuppressWarnings("ALL")
public class EvtMyPetExp extends SkriptEvent {

    static {
        if (Bukkit.getPluginManager().isPluginEnabled("MyPet")) {
            Bukkit.getLogger().log(Level.INFO, "LoadingEvent: mypet petexp");
            Skript.registerEvent("MyPet PetExp", EvtMyPetExp.class, MyPetExpEvent.class, "mypet exp")
                    .description("ペットが経験値を取得したときに呼び出されます");
            EventValues.registerEventValue(MyPetExpEvent.class, Player.class, new Getter<Player, MyPetExpEvent>() {
                @Nullable
                @Override
                public Player get(MyPetExpEvent arg) {
                    return arg.getOwner().getPlayer();
                }
            }, 0);
            EventValues.registerEventValue(MyPetExpEvent.class, MyPet.class, new Getter<MyPet, MyPetExpEvent>() {
                @Override
                public MyPet get(MyPetExpEvent arg) {
                    return arg.getPet();
                }
            }, 0);
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
