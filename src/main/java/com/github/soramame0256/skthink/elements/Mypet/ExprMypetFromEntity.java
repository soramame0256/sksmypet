package com.github.soramame0256.skthink.elements.Mypet;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import de.Keyle.MyPet.MyPetApi;
import de.Keyle.MyPet.api.entity.MyPet;
import de.Keyle.MyPet.api.entity.MyPetBukkitEntity;
import de.Keyle.MyPet.api.entity.MyPetMinecraftEntity;
import org.bukkit.Bukkit;
import org.bukkit.entity.Creature;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Event;
import org.jetbrains.annotations.Nullable;

import java.util.logging.Level;

public class ExprMypetFromEntity extends SimpleExpression<MyPet> {

    static {
        if (Bukkit.getPluginManager().isPluginEnabled("MyPet")) {
            Bukkit.getLogger().log(Level.INFO, "LoadingExpression: mypet from entity");
            Skript.registerExpression(ExprMypetFromEntity.class, MyPet.class, ExpressionType.COMBINED, "mypet from %living entity%");
        }
    }
    Expression<LivingEntity> entity;
    @Nullable
    @Override
    protected MyPet[] get(Event e) {
        Creature c1 = (Creature)entity;
        MyPetBukkitEntity e1 = (MyPetBukkitEntity)c1;
        if (e1.getHandle().isMyPet()) {
            return new MyPet[]{e1.getMyPet()};
        }
        return null;
    }


    @Override
    public boolean isSingle() {
        return true;
    }

    @Override
    public Class<? extends MyPet> getReturnType() {
        return MyPet.class;
    }

    @Override
    public String toString(@Nullable Event e, boolean debug) {
        return "mypet from %living entity%";
    }

    @Override
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, SkriptParser.ParseResult parseResult) {
        this.entity = (Expression<LivingEntity>)exprs[0];
        return true;
    }
}
