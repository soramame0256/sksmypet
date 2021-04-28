package com.github.soramame0256.sksmypet.elements.Mypet;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Literal;
import ch.njol.skript.lang.SkriptEvent;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.registrations.EventValues;
import ch.njol.skript.util.Getter;
import de.Keyle.MyPet.api.entity.MyPet;
import de.Keyle.MyPet.api.event.MyPetCreateEvent;
import de.Keyle.MyPet.util.sentry.util.Nullable;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import java.util.logging.Level;

public class Evtpetcreate extends SkriptEvent {


    static {
        if (Bukkit.getPluginManager().isPluginEnabled("MyPet")) {
            Bukkit.getLogger().log(Level.INFO, "LoadingEvent: mypet petcreate");
            Skript.registerEvent("mypet petcreate", Evtpetcreate.class, MyPetCreateEvent.class, "mypet (create|leash)")
                    .description("Mypetにてペットが作成されたときに呼び出されます");
            EventValues.registerEventValue(MyPetCreateEvent.class, Player.class, new Getter<Player, MyPetCreateEvent>() {
                @Nullable
                @Override
                public Player get(MyPetCreateEvent arg) { return arg.getOwner().getPlayer(); }
            },0);
            EventValues.registerEventValue(MyPetCreateEvent.class, String.class, new Getter<String, MyPetCreateEvent>() {
                @Nullable
                @Override
                public String get(MyPetCreateEvent arg) { return arg.getSource().toString(); }
            }, 0);
            EventValues.registerEventValue(MyPetCreateEvent.class, MyPet.class, new Getter<MyPet, MyPetCreateEvent>() {
                @Nullable
                @Override
                public MyPet get(MyPetCreateEvent arg) { return arg.getMyPet().getOwner().getMyPet(); }
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
    public String toString(@org.jetbrains.annotations.Nullable Event e, boolean debug) {
        return " ";
    }
}
