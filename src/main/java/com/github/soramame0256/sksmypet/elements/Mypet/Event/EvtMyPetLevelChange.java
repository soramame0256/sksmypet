package com.github.soramame0256.sksmypet.elements.Mypet.Event;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Literal;
import ch.njol.skript.lang.SkriptEvent;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.registrations.EventValues;
import ch.njol.skript.util.Getter;
import de.Keyle.MyPet.api.entity.MyPet;
import de.Keyle.MyPet.api.event.MyPetLevelEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.jetbrains.annotations.Nullable;

import java.util.logging.Level;

@SuppressWarnings("ALL")
public class EvtMyPetLevelChange extends SkriptEvent {

    static {
        if (Bukkit.getPluginManager().isPluginEnabled("MyPet")) {
            Bukkit.getLogger().log(Level.INFO, "LoadingEvent: Pet Level Change");
            Skript.registerEvent("MyPet Level Change", EvtMyPetLevelChange.class, MyPetLevelEvent.class, "mypet level change")
                    .description("ペットのレベルが変化したときに呼び出されます");
            EventValues.registerEventValue(MyPetLevelEvent.class, int.class, new Getter<Integer, MyPetLevelEvent>() {
                @Nullable
                @Override
                public Integer get(MyPetLevelEvent arg) {
                    return arg.getLevel();
                }
            }, 0);
            EventValues.registerEventValue(MyPetLevelEvent.class, Player.class, new Getter<Player, MyPetLevelEvent>() {
                @Nullable
                @Override
                public Player get(MyPetLevelEvent arg) {
                    return arg.getOwner().getPlayer();
                }
            }, 0);
            EventValues.registerEventValue(MyPetLevelEvent.class, MyPet.class, new Getter<MyPet, MyPetLevelEvent>() {
                @Nullable
                @Override
                public MyPet get(MyPetLevelEvent arg) {
                    return arg.getPet();
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
