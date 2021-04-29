package com.github.soramame0256.sksmypet.elements.Mypet.Event;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Literal;
import ch.njol.skript.lang.SkriptEvent;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.registrations.EventValues;
import ch.njol.skript.util.Getter;
import de.Keyle.MyPet.api.entity.MyPet;
import de.Keyle.MyPet.api.event.MyPetInventoryActionEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.jetbrains.annotations.Nullable;

import java.util.logging.Level;

@SuppressWarnings("ALL")
public class EvtPetInventoryAction extends SkriptEvent {

    static {
        if (Bukkit.getPluginManager().isPluginEnabled("MyPet")) {
            Bukkit.getLogger().log(Level.INFO, "LoadingEvent: mypet inventory action");
            Skript.registerEvent("MyPet Inventory Action", EvtPetInventoryAction.class, MyPetInventoryActionEvent.class, "mypet inventory action")
                    .description("ペットのインベントリが変更されたときに呼び出されます");
            EventValues.registerEventValue(MyPetInventoryActionEvent.class, MyPet.class, new Getter<MyPet, MyPetInventoryActionEvent>() {
                @Nullable
                @Override
                public MyPet get(MyPetInventoryActionEvent arg) {
                    return arg.getPet();
                }
            }, 0);
            EventValues.registerEventValue(MyPetInventoryActionEvent.class, Player.class, new Getter<Player, MyPetInventoryActionEvent>() {
                @Nullable
                @Override
                public Player get(MyPetInventoryActionEvent arg) {
                    return arg.getOwner().getPlayer();
                }
            }, 0);
            EventValues.registerEventValue(MyPetInventoryActionEvent.class, String.class, new Getter<String, MyPetInventoryActionEvent>() {
                @Nullable
                @Override
                public String get(MyPetInventoryActionEvent arg) {
                    return arg.getAction().toString();
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
