package com.github.soramame0256.skthink.elements.Mypet;

import ch.njol.skript.Skript;
import ch.njol.skript.classes.Changer;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import ch.njol.util.coll.CollectionUtils;
import de.Keyle.MyPet.entity.MyPet;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.logging.Level;

public class ExprPetExp extends SimpleExpression<Double> {

    static {
        if (Bukkit.getPluginManager().isPluginEnabled("MyPet")) {
            Bukkit.getLogger().log(Level.INFO, "LoadingExpression: mypet exp");
            Skript.registerExpression(ExprPetExp.class, Double.class, ExpressionType.COMBINED, "[the] exp of %mypet%");
        }
    }
    Expression<MyPet> pet;
    @Nullable
    @Override
    protected Double[] get(Event e) {
        return new Double[]{Objects.requireNonNull(pet.getSingle(e)).getExperience().getExp()};
    }

    @Override
    public boolean isSingle() {
        return true;
    }

    @Override
    public Class<? extends Double> getReturnType() {
        return Double.class;
    }

    @Override
    public String toString(@Nullable Event e, boolean debug) {
        return "exp of %mypet%";
    }

    @Override
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, SkriptParser.ParseResult parseResult) {
        this.pet = (Expression<MyPet>)exprs[0];
        return true;
    }
    public void change(Event e, Object[] delta, Changer.ChangeMode mode) { ;
        MyPet peta = pet.getSingle(e);
        if (peta != null) {
            Double exp1 = peta.getExp();
            Double exp2 = (Double)delta[0];
            if (mode == Changer.ChangeMode.ADD) {
                peta.setExp(exp1 + exp2);
            } else if (mode == Changer.ChangeMode.REMOVE) {
                peta.setExp(exp1 - exp2);
            } else if (mode == Changer.ChangeMode.SET) {
                peta.setExp(exp2);
            }
        }
    }
    public Class<?>[] acceptChange(Changer.ChangeMode mode) {
        if (mode == Changer.ChangeMode.ADD || mode == Changer.ChangeMode.REMOVE || mode == Changer.ChangeMode.SET) {
            return CollectionUtils.array(Number.class);
        }
        return null;
    }
}
