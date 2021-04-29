package com.github.soramame0256.sksmypet.elements.Mypet;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Literal;
import ch.njol.skript.lang.SkriptEvent;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.registrations.EventValues;
import ch.njol.skript.util.Getter;
import de.Keyle.MyPet.api.entity.MyPet;
import de.Keyle.MyPet.api.event.MyPetSendAwayEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.jetbrains.annotations.Nullable;

public class EvtPetSendAway extends SkriptEvent {

    static {
        Skript.registerEvent("MyPet Send Away", EvtMypetCall.class, MyPetSendAwayEvent.class, "mypet send[ ]away")
                .description("ペットが収納されたときに呼び出されます");
        EventValues.registerEventValue(MyPetSendAwayEvent.class, MyPet.class, new Getter<MyPet, MyPetSendAwayEvent>() {
            @Nullable
            @Override
            public MyPet get(MyPetSendAwayEvent arg) {
                return arg.getOwner().getMyPet();
            }
        }, 0);
        EventValues.registerEventValue(MyPetSendAwayEvent.class, Player.class, new Getter<Player, MyPetSendAwayEvent>() {
            @Nullable
            @Override
            public Player get(MyPetSendAwayEvent arg) {
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