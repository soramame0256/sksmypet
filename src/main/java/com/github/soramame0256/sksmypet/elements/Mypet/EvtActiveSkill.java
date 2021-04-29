package com.github.soramame0256.sksmypet.elements.Mypet;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Literal;
import ch.njol.skript.lang.SkriptEvent;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.registrations.EventValues;
import ch.njol.skript.util.Getter;
import de.Keyle.MyPet.api.entity.MyPet;
import de.Keyle.MyPet.api.event.MyPetActiveSkillEvent;
import de.Keyle.MyPet.api.skill.SkillName;
import de.Keyle.MyPet.api.skill.skilltree.Skill;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.jetbrains.annotations.Nullable;

import java.util.logging.Level;

public class EvtActiveSkill extends SkriptEvent {

    static {
        if (Bukkit.getPluginManager().isPluginEnabled("MyPet")) {
            Bukkit.getLogger().log(Level.INFO, "LoadingEvent: MyPetActiveSkill");
            Skript.registerEvent("MyPetActivateSkill", EvtActiveSkill.class, MyPetActiveSkillEvent.class, "mypet skill [activate[d]]")
                    .description("発動条件不明");;
            EventValues.registerEventValue(MyPetActiveSkillEvent.class, MyPet.class, new Getter<MyPet, MyPetActiveSkillEvent>() {
                @Nullable
                @Override
                public MyPet get(MyPetActiveSkillEvent arg) {
                    return arg.getMyPet();
                }
            }, 0);
            EventValues.registerEventValue(MyPetActiveSkillEvent.class, Player.class, new Getter<Player, MyPetActiveSkillEvent>() {
                @Nullable
                @Override
                public Player get(MyPetActiveSkillEvent arg) {
                    return arg.getOwner().getPlayer();
                }
            }, 0);
            EventValues.registerEventValue(MyPetActiveSkillEvent.class, String.class, new Getter<String, MyPetActiveSkillEvent>() {
                @Nullable
                @Override
                public String get(MyPetActiveSkillEvent arg) {
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
