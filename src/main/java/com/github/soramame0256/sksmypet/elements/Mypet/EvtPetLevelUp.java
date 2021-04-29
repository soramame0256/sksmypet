package com.github.soramame0256.sksmypet.elements.Mypet;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Literal;
import ch.njol.skript.lang.SkriptEvent;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.registrations.EventValues;
import ch.njol.skript.util.Getter;
import de.Keyle.MyPet.api.entity.MyPet;
import de.Keyle.MyPet.api.event.MyPetLevelUpEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.jetbrains.annotations.Nullable;

import java.util.logging.Level;

public class EvtPetLevelUp extends SkriptEvent {

    static {
        if (Bukkit.getPluginManager().isPluginEnabled("MyPet")) {
            Bukkit.getLogger().log(Level.INFO, "LoadingEvent: PetLevelUp");
            Skript.registerEvent("mypet level up", EvtPetLevelUp.class, MyPetLevelUpEvent.class, "mypet level[ ]up")
                    .description("ペットがレベルアップしたときに呼び出されます");
            EventValues.registerEventValue(MyPetLevelUpEvent.class, int.class, new Getter<Integer, MyPetLevelUpEvent>() {
                @Nullable
                @Override
                public Integer get(MyPetLevelUpEvent arg) {
                    return arg.fromLevel();
                }
            }, 0);
            EventValues.registerEventValue(MyPetLevelUpEvent.class, Player.class, new Getter<Player, MyPetLevelUpEvent>() {
                @Nullable
                @Override
                public Player get(MyPetLevelUpEvent arg) {
                    return arg.getOwner().getPlayer();
                }
            }, 0);
            EventValues.registerEventValue(MyPetLevelUpEvent.class, MyPet.class, new Getter<MyPet, MyPetLevelUpEvent>() {
                @Nullable
                @Override
                public MyPet get(MyPetLevelUpEvent arg) {
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
