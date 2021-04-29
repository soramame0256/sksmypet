package com.github.soramame0256.sksmypet.elements.Mypet.Event;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Literal;
import ch.njol.skript.lang.SkriptEvent;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.registrations.EventValues;
import ch.njol.skript.util.Getter;
import de.Keyle.MyPet.api.entity.MyPet;
import de.Keyle.MyPet.api.event.MyPetActivatedEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.jetbrains.annotations.Nullable;

import java.util.logging.Level;

@SuppressWarnings("ALL")
public class EvtMypetActivate extends SkriptEvent {

    static {
        if (Bukkit.getPluginManager().isPluginEnabled("MyPet")) {
            Bukkit.getLogger().log(Level.INFO, "LoadingEvent: MypetActivate");
            Skript.registerEvent("MyPet Activate", EvtMypetActivate.class, MyPetActivatedEvent.class, "mypet activate[d]")
                    .description("発動条件不明");;
            EventValues.registerEventValue(MyPetActivatedEvent.class, MyPet.class, new Getter<MyPet, MyPetActivatedEvent>() {
                @Nullable
                @Override
                public MyPet get(MyPetActivatedEvent arg) {
                    return arg.getMyPet();
                }
            }, 0);
            EventValues.registerEventValue(MyPetActivatedEvent.class, Player.class, new Getter<Player, MyPetActivatedEvent>() {
                @Nullable
                @Override
                public Player get(MyPetActivatedEvent arg) {
                    return arg.getOwner().getPlayer();
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
