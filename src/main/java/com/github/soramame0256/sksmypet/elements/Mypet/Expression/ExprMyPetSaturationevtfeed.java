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
import de.Keyle.MyPet.api.event.MyPetFeedEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.jetbrains.annotations.Nullable;

import java.util.logging.Level;

@SuppressWarnings("ALL")
public class ExprMyPetSaturationevtfeed extends SimpleExpression<Double> {

    static {
        if (Bukkit.getPluginManager().isPluginEnabled("MyPet")) {
            Bukkit.getLogger().log(Level.INFO, "LoadingExpression: feed saturation");
            Skript.registerExpression(ExprMyPetSaturationevtfeed.class, Double.class, ExpressionType.SIMPLE, "[pet] feed saturation");
        }
    }
    Expression<Double> d;
    @Nullable
    @Override
    protected Double[] get(Event e) {
        return new Double[]{(((MyPetFeedEvent)e).getSaturation())};
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
        return "pet feed result";
    }

    @Override
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, SkriptParser.ParseResult parseResult) {
        if (ScriptLoader.isCurrentEvent(MyPetFeedEvent.class)) {
            return true;
        }
        Skript.error("これはmypet feedイベントでのみ使用可能です");
        return false;
    }
    public void change(Event e, Object[] delta, Changer.ChangeMode mode) {
        Double sat = ((MyPetFeedEvent)e).getSaturation();
        if (sat != null) {
            Double d1 = ((MyPetFeedEvent)e).getSaturation();
            Number n1 = (Number)delta[0];
            Double d2 = n1.doubleValue();
            if (mode == Changer.ChangeMode.SET) {
                ((MyPetFeedEvent)e).setSaturation(d2);
            } else if (mode == Changer.ChangeMode.ADD) {
                ((MyPetFeedEvent)e).setSaturation(d2 + d1);
            } else if (mode == Changer.ChangeMode.REMOVE) {
                ((MyPetFeedEvent)e).setSaturation(d2 - d1);
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
