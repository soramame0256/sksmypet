package com.github.soramame0256.sksmypet.elements.Mypet.Event;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Literal;
import ch.njol.skript.lang.SkriptEvent;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.registrations.EventValues;
import ch.njol.skript.util.Getter;
import de.Keyle.MyPet.api.entity.MyPet;
import de.Keyle.MyPet.api.event.MyPetOnHitSkillEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.jetbrains.annotations.Nullable;

import java.util.logging.Level;

@SuppressWarnings("ALL")
public class EvtMyPetSkillHit extends SkriptEvent {

    static {
        if (Bukkit.getPluginManager().isPluginEnabled("MyPet")) {
            Bukkit.getLogger().log(Level.INFO, "LoadingEvent: Hit Skill");
            Skript.registerEvent("MyPet On Hit Skill", EvtMyPetSkillHit.class, MyPetOnHitSkillEvent.class, "mypet hit skill")
                    .description("発生条件不明");
            EventValues.registerEventValue(MyPetOnHitSkillEvent.class, MyPet.class, new Getter<MyPet, MyPetOnHitSkillEvent>() {
                @Nullable
                @Override
                public MyPet get(MyPetOnHitSkillEvent arg) {
                    return arg.getMyPet();
                }
            }, 0);
            EventValues.registerEventValue(MyPetOnHitSkillEvent.class, Player.class, new Getter<Player, MyPetOnHitSkillEvent>() {
                @Nullable
                @Override
                public Player get(MyPetOnHitSkillEvent arg) {
                    return arg.getOwner().getPlayer();
                }
            }, 0);
            EventValues.registerEventValue(MyPetOnHitSkillEvent.class, LivingEntity.class, new Getter<LivingEntity, MyPetOnHitSkillEvent>() {
                @Nullable
                @Override
                public LivingEntity get(MyPetOnHitSkillEvent arg) {
                    return arg.getTarget();
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
