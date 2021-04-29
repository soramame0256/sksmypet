package com.github.soramame0256.sksmypet.elements.Mypet.Event;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Literal;
import ch.njol.skript.lang.SkriptEvent;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.registrations.EventValues;
import ch.njol.skript.util.Getter;
import de.Keyle.MyPet.api.entity.MyPet;
import de.Keyle.MyPet.api.event.MyPetNameEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.jetbrains.annotations.Nullable;

import java.util.logging.Level;

@SuppressWarnings("ALL")
public class EvtPetRename extends SkriptEvent {

    static {
        if (Bukkit.getPluginManager().isPluginEnabled("MyPet")) {
            Bukkit.getLogger().log(Level.INFO, "LoadingEvent: Pet Rename");
            Skript.registerEvent("MyPet Rename", EvtPetRename.class, MyPetNameEvent.class, "mypet (rename|name[ change])")
                    .description("ペットの名前が変更されたときに呼び出されます");
            EventValues.registerEventValue(MyPetNameEvent.class, String.class, new Getter<String, MyPetNameEvent>() {
                @Nullable
                @Override
                public String get(MyPetNameEvent arg) {
                    return arg.getNewName();
                }
            }, 0);
            EventValues.registerEventValue(MyPetNameEvent.class, Player.class, new Getter<Player, MyPetNameEvent>() {
                @Nullable
                @Override
                public Player get(MyPetNameEvent arg) {
                    return arg.getMyPet().getOwner().getPlayer();
                }
            },0);
            EventValues.registerEventValue(MyPetNameEvent.class, MyPet.class, new Getter<MyPet, MyPetNameEvent>() {
                @Nullable
                @Override
                public MyPet get(MyPetNameEvent arg) {
                    return arg.getMyPet();
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
