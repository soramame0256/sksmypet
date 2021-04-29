package com.github.soramame0256.sksmypet.elements.Mypet.Event;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Literal;
import ch.njol.skript.lang.SkriptEvent;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.registrations.EventValues;
import ch.njol.skript.util.Getter;
import de.Keyle.MyPet.api.entity.MyPet;
import de.Keyle.MyPet.api.event.MyPetLevelDownEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.jetbrains.annotations.Nullable;

import java.util.logging.Level;

@SuppressWarnings("ALL")
public class EvtPetLevelDown extends SkriptEvent {

    static {
        if (Bukkit.getPluginManager().isPluginEnabled("MyPet")) {
            Bukkit.getLogger().log(Level.INFO, "LoadingEvent: PetLevelDown");
            Skript.registerEvent("Mypet Level Down", EvtPetLevelDown.class, MyPetLevelDownEvent.class, "mypet level[ ]down")
                    .description("ペットがレベルダウンしたときに呼び出されます");
            EventValues.registerEventValue(MyPetLevelDownEvent.class, int.class, new Getter<Integer, MyPetLevelDownEvent>() {
                @Nullable
                @Override
                public Integer get(MyPetLevelDownEvent arg) {
                    return arg.fromLevel();
                }
            }, 0);
            EventValues.registerEventValue(MyPetLevelDownEvent.class, Player.class, new Getter<Player, MyPetLevelDownEvent>() {
                @Nullable
                @Override
                public Player get(MyPetLevelDownEvent arg) {
                    return arg.getOwner().getPlayer();
                }
            }, 0);
            EventValues.registerEventValue(MyPetLevelDownEvent.class, MyPet.class, new Getter<MyPet, MyPetLevelDownEvent>() {
                @Nullable
                @Override
                public MyPet get(MyPetLevelDownEvent arg) {
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
