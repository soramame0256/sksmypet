package com.github.soramame0256.sksmypet.elements.Mypet.Event;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Literal;
import ch.njol.skript.lang.SkriptEvent;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.registrations.EventValues;
import ch.njol.skript.util.Getter;
import de.Keyle.MyPet.api.entity.MyPet;
import de.Keyle.MyPet.api.event.MyPetPickupItemEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.util.logging.Level;

@SuppressWarnings("ALL")
public class EvtPetPickupitem extends SkriptEvent {

    static {
        if (Bukkit.getPluginManager().isPluginEnabled("MyPet")) {
            Bukkit.getLogger().log(Level.INFO, "LoadedEvent: PetPickup");
            Skript.registerEvent("MyPet Pickup Item", EvtPetPickupitem.class, MyPetPickupItemEvent.class, "mypet pickup[ item]")
                    .description("ペットがアイテムを拾ったときに呼び出されます");
            EventValues.registerEventValue(MyPetPickupItemEvent.class, Player.class, new Getter<Player, MyPetPickupItemEvent>() {
                @Nullable
                @Override
                public Player get(MyPetPickupItemEvent arg) {
                    return arg.getOwner().getPlayer();
                }
            }, 0);
            EventValues.registerEventValue(MyPetPickupItemEvent.class, MyPet.class, new Getter<MyPet, MyPetPickupItemEvent>() {
                @Nullable
                @Override
                public MyPet get(MyPetPickupItemEvent arg) {
                    return arg.getPet();
                }
            }, 0);
            EventValues.registerEventValue(MyPetPickupItemEvent.class, ItemStack.class, new Getter<ItemStack, MyPetPickupItemEvent>() {
                @Nullable
                @Override
                public ItemStack get(MyPetPickupItemEvent arg) {
                    return arg.getItem().getItemStack();
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
