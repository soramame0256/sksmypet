package com.github.soramame0256.sksmypet.elements.Mypet;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Literal;
import ch.njol.skript.lang.SkriptEvent;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.registrations.EventValues;
import ch.njol.skript.util.Getter;
import de.Keyle.MyPet.api.entity.MyPet;
import de.Keyle.MyPet.api.event.MyPetRemoveEvent;
import de.Keyle.MyPet.util.sentry.util.Nullable;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import java.util.logging.Level;

public class Evtpetremove extends SkriptEvent {


    static {
        if (Bukkit.getPluginManager().isPluginEnabled("MyPet")) {
            Bukkit.getLogger().log(Level.INFO, "LoadingEvent: mypet petremove");
            Skript.registerEvent("MyPet Pet Remove", Evtpetremove.class, MyPetRemoveEvent.class, "mypet (remove|unleash)")
                    .description("ペットが削除されたときに呼び出されます");
            EventValues.registerEventValue(MyPetRemoveEvent.class, Player.class, new Getter<Player, MyPetRemoveEvent>() {
                @Nullable
                @Override
                public Player get(MyPetRemoveEvent arg) { return arg.getOwner().getPlayer(); }
            },0);
            EventValues.registerEventValue(MyPetRemoveEvent.class, String.class, new Getter<String, MyPetRemoveEvent>() {
                @Nullable
                @Override
                public String get(MyPetRemoveEvent arg) { return arg.getSource().toString(); }
            }, 0);
            EventValues.registerEventValue(MyPetRemoveEvent.class, MyPet.class, new Getter<MyPet, MyPetRemoveEvent>() {
                @Nullable
                @Override
                public MyPet get(MyPetRemoveEvent arg) { return arg.getMyPet().getOwner().getMyPet(); }
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
