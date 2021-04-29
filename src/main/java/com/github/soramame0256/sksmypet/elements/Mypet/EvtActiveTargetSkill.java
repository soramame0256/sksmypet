package com.github.soramame0256.sksmypet.elements.Mypet;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Literal;
import ch.njol.skript.lang.SkriptEvent;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.registrations.EventValues;
import ch.njol.skript.util.Getter;
import de.Keyle.MyPet.api.entity.MyPet;
import de.Keyle.MyPet.api.event.MyPetActiveTargetSkillEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.jetbrains.annotations.Nullable;

import java.util.logging.Level;

public class EvtActiveTargetSkill extends SkriptEvent {

    static {
        if (Bukkit.getPluginManager().isPluginEnabled("MyPet")) {
            Bukkit.getLogger().log(Level.INFO, "LoadingEvent: ActiveTargetSkill");
            Skript.registerEvent("ActiveTargetSkill", EvtActiveTargetSkill.class, MyPetActiveTargetSkillEvent.class, "mypet target skill")
                    .description("発動条件不明");
            EventValues.registerEventValue(MyPetActiveTargetSkillEvent.class, LivingEntity.class, new Getter<LivingEntity, MyPetActiveTargetSkillEvent>() {
                @Nullable
                @Override
                public LivingEntity get(MyPetActiveTargetSkillEvent arg) {
                    return arg.getTarget();
                }
            }, 0);
            EventValues.registerEventValue(MyPetActiveTargetSkillEvent.class, MyPet.class, new Getter<MyPet, MyPetActiveTargetSkillEvent>() {
                @Nullable
                @Override
                public MyPet get(MyPetActiveTargetSkillEvent arg) {
                    return arg.getMyPet();
                }
            }, 0);
            EventValues.registerEventValue(MyPetActiveTargetSkillEvent.class, Player.class, new Getter<Player, MyPetActiveTargetSkillEvent>() {
                @Nullable
                @Override
                public Player get(MyPetActiveTargetSkillEvent arg) {
                    return arg.getOwner().getPlayer();
                }
            }, 0);
            EventValues.registerEventValue(MyPetActiveTargetSkillEvent.class, String.class, new Getter<String, MyPetActiveTargetSkillEvent>() {
                @Nullable
                @Override
                public String get(MyPetActiveTargetSkillEvent arg) {
                    return arg.getSkill().toString();
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
