package com.github.soramame0256.sksmypet.elements.Mypet;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Literal;
import ch.njol.skript.lang.SkriptEvent;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.registrations.EventValues;
import ch.njol.skript.util.Getter;
import de.Keyle.MyPet.api.entity.MyPet;
import de.Keyle.MyPet.api.event.MyPetCallEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.jetbrains.annotations.Nullable;

public class EvtMypetCall extends SkriptEvent {

    static {
        Skript.registerEvent("Mypet call", EvtMypetCall.class, MyPetCallEvent.class, "mypet call")
                .description("ペットのコールされたときに呼び出されます");
        EventValues.registerEventValue(MyPetCallEvent.class, MyPet.class, new Getter<MyPet, MyPetCallEvent>() {
            @Nullable
            @Override
            public MyPet get(MyPetCallEvent arg) {
                return arg.getOwner().getMyPet();
            }
        }, 0);
        EventValues.registerEventValue(MyPetCallEvent.class, Player.class, new Getter<Player, MyPetCallEvent>() {
            @Nullable
            @Override
            public Player get(MyPetCallEvent arg) {
                return arg.getOwner().getPlayer();
            }
        }, 0);
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
