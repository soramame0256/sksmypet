package com.github.soramame0256.sksmypet.elements.Mypet.Expression;

import ch.njol.skript.ScriptLoader;
import ch.njol.skript.Skript;
import ch.njol.skript.classes.Changer;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import ch.njol.util.coll.CollectionUtils;
import de.Keyle.MyPet.api.event.MyPetDamageEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.jetbrains.annotations.Nullable;

import java.util.logging.Level;

@SuppressWarnings("ALL")
public class ExprPetDamageevtdamage extends SimpleExpression<Double> {

    static {
        if (Bukkit.getPluginManager().isPluginEnabled("MyPet")) {
            Bukkit.getLogger().log(Level.INFO, "LoadingExpression: petdamageevtdamage");
            Skript.registerExpression(ExprPetDamageevtdamage.class, Double.class, ExpressionType.COMBINED, "pet damage");
        }
    }
    Expression<Double> damage;
    @Nullable
    @Override
    protected Double[] get(Event e) {
        return new Double[]{((MyPetDamageEvent)e).getDamage()};
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
        return " ";
    }

    @Override
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, SkriptParser.ParseResult parseResult) {
        if (ScriptLoader.isCurrentEvent(MyPetDamageEvent.class)) {
            return true;
        }
        Skript.error("これはmypet damageイベントでのみ使用可能です");
        return false;
    }
    public void change(Event e, Object[] delta, Changer.ChangeMode mode) {
        Double damage = ((MyPetDamageEvent)e).getDamage();
        if (damage != null) {
            Double d1 = ((MyPetDamageEvent)e).getDamage();
            Number n1 = (Number)delta[0];
            Double d2 = n1.doubleValue();
            if (mode == Changer.ChangeMode.SET) {
                ((MyPetDamageEvent)e).setDamage(d2);
            } else if (mode == Changer.ChangeMode.ADD) {
                ((MyPetDamageEvent)e).setDamage(d2 + d1);
            } else if (mode == Changer.ChangeMode.REMOVE) {
                ((MyPetDamageEvent)e).setDamage(d2 - d1);
            }
        }
    }
    public Class<?>[] acceptChange(Changer.ChangeMode mode) {
        if (mode == Changer.ChangeMode.SET || mode == Changer.ChangeMode.ADD || mode == Changer.ChangeMode.REMOVE) {
            return CollectionUtils.array(Number.class);
        }
        return null;
    }
}
