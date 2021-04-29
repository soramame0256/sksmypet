package com.github.soramame0256.sksmypet.elements.Mypet.Expression;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import de.Keyle.MyPet.MyPetApi;
import de.Keyle.MyPet.api.entity.MyPet;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("ALL")
public class ExprMyPetfromOwner extends SimpleExpression<MyPet> {

    static {
        if (Bukkit.getPluginManager().isPluginEnabled("MyPet")) {
            Skript.registerExpression(ExprMyPetfromOwner.class, MyPet.class, ExpressionType.COMBINED, "mypet of %player%");
        }
    }
    Expression<Player> p;
    @Nullable
    @Override
    protected MyPet[] get(Event e) {
        return new MyPet[]{MyPetApi.getPlayerManager().getMyPetPlayer(p.getSingle(e)).getMyPet()};
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
        return "mypet of %player%";
    }

    @Override
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, SkriptParser.ParseResult parseResult) {
        this.p = (Expression<Player>) exprs[0];
        return true;
    }
}
