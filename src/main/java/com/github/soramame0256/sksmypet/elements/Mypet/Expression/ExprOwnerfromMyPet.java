package com.github.soramame0256.sksmypet.elements.Mypet.Expression;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import de.Keyle.MyPet.api.entity.MyPet;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.jetbrains.annotations.Nullable;

public class ExprOwnerfromMyPet extends SimpleExpression<Player> {

    static {
        if (Bukkit.getPluginManager().isPluginEnabled("MyPet")) {
            Skript.registerExpression(ExprOwnerfromMyPet.class, Player.class, ExpressionType.COMBINED, "owner of %mypet%");
        }
    }
    Expression<MyPet> pet;
    @Nullable
    @Override
    protected Player[] get(Event e) {
        return new Player[]{pet.getSingle(e).getOwner().getPlayer()};
    }

    @Override
    public boolean isSingle() {
        return true;
    }

    @Override
    public Class<? extends Player> getReturnType() {
        return Player.class;
    }

    @Override
    public String toString(@Nullable Event e, boolean debug) {
        return "owner of %mypet%";
    }

    @Override
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, SkriptParser.ParseResult parseResult) {
        this.pet = (Expression<MyPet>)exprs[0];
        return true;
    }
}
