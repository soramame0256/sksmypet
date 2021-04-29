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
public class ExprResultevtFeed extends SimpleExpression<MyPetFeedEvent.Result> {

    static {
        if (Bukkit.getPluginManager().isPluginEnabled("MyPet")) {
            Bukkit.getLogger().log(Level.INFO, "LoadingExpression: pet feed result");
            Skript.registerExpression(ExprResultevtFeed.class, MyPetFeedEvent.Result.class, ExpressionType.SIMPLE, "[pet] feed result");
        }
    }
    @Nullable
    @Override
    protected MyPetFeedEvent.Result[] get(Event e) {
        return new MyPetFeedEvent.Result[]{(((MyPetFeedEvent)e).getResult())};
    }

    @Override
    public boolean isSingle() {
        return true;
    }

    @Override
    public Class<? extends MyPetFeedEvent.Result> getReturnType() {
        return MyPetFeedEvent.Result.class;
    }

    @Override
    public String toString(@Nullable Event e, boolean debug) {
        return "feed result";
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
        MyPetFeedEvent.Result result = ((MyPetFeedEvent)e).getResult();
        if (result != null) {
            MyPetFeedEvent.Result result2 = (MyPetFeedEvent.Result) delta[0];
            if (mode == Changer.ChangeMode.SET) {
                ((MyPetFeedEvent) e).setResult(result2);
            }
        }
    }
    public Class<?>[] acceptChange(Changer.ChangeMode mode) {
        if (mode == Changer.ChangeMode.SET) {
            return CollectionUtils.array(MyPetFeedEvent.Result.class);
        }
        return null;
    }
}
