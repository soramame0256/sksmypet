package com.github.soramame0256.sksmypet.elements.Mypet.Event;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Literal;
import ch.njol.skript.lang.SkriptEvent;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.registrations.EventValues;
import ch.njol.skript.util.Getter;
import de.Keyle.MyPet.api.entity.MyPet;
import de.Keyle.MyPet.api.event.MyPetSitEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("ALL")
public class EvtMyPetSit extends SkriptEvent {
    static {
        Skript.registerEvent("MyPet Sit", EvtMyPetSit.class, MyPetSitEvent.class, "mypet sit")
                .description("ペットが座ったときに呼び出されます");
        EventValues.registerEventValue(MyPetSitEvent.class, MyPet.class, new Getter<MyPet, MyPetSitEvent>() {
            @Nullable
            @Override
            public MyPet get(MyPetSitEvent arg) {
                return arg.getMyPet().getOwner().getMyPet();
            }
        }, 0);
        EventValues.registerEventValue(MyPetSitEvent.class, Player.class, new Getter<Player, MyPetSitEvent>() {
            @Nullable
            @Override
            public Player get(MyPetSitEvent arg) {
                return arg.getMyPet().getOwner().getPlayer();
            }
        }, 0);
        EventValues.registerEventValue(MyPetSitEvent.class, String.class, new Getter<String, MyPetSitEvent>() {
            @Nullable
            @Override
            public String get(MyPetSitEvent arg) {
                return arg.getAction().toString();
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
