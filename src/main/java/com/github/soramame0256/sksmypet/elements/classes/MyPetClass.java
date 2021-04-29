package com.github.soramame0256.sksmypet.elements.classes;

import ch.njol.skript.classes.ClassInfo;
import ch.njol.skript.classes.Parser;
import ch.njol.skript.classes.Serializer;
import ch.njol.skript.lang.ParseContext;
import ch.njol.skript.registrations.Classes;
import ch.njol.yggdrasil.Fields;
import com.github.soramame0256.sksmypet.elements.mypetstringtoclass;
import de.Keyle.MyPet.api.entity.MyPet;
import de.Keyle.MyPet.api.event.MyPetFeedEvent;
import de.Keyle.MyPet.api.event.MyPetInventoryActionEvent;
import de.Keyle.MyPet.util.sentry.util.Nullable;
import org.bukkit.Bukkit;

import java.io.NotSerializableException;
import java.io.StreamCorruptedException;
import java.util.logging.Level;

public class MyPetClass {

    static {
        if (Bukkit.getPluginManager().isPluginEnabled("MyPet")) {
            Bukkit.getLogger().log(Level.INFO, "RegisteringClass: MyPet");
            Classes.registerClass(new ClassInfo<>(MyPet.class, "mypet").user("mypet").name("MyPet").parser(new noparsable<>()));
            Classes.registerClass(new ClassInfo<>(MyPetFeedEvent.Result.class, "mypetfeedresult").user("mypet ?feed ?result").name("MyPet Feed Result").usage("Eat", "Heal")
                    .parser(new Parser<MyPetFeedEvent.Result>() {

                        @Nullable
                        @Override
                        public MyPetFeedEvent.Result parse(String s, ParseContext context) {
                            Object feedresultq = mypetstringtoclass.toResult(s);
                            if (feedresultq != null) {
                                return (MyPetFeedEvent.Result) feedresultq;
                            }
                            return null;
                        }
                        @Override
                        public String toString(MyPetFeedEvent.Result o, int flags) {
                            return o.toString();
                        }

                        @Override
                        public String toVariableNameString(MyPetFeedEvent.Result o) {
                            return o.toString();
                        }

                        @Override
                        public String getVariableNamePattern() {
                            return ".+";
                        }
                    }).serializer(new Serializer<MyPetFeedEvent.Result>() {
                        @Override
                        public Fields serialize(MyPetFeedEvent.Result o) throws NotSerializableException {
                            Fields f = new Fields();
                            f.putObject("mypetfeedresult", o.name());
                            return f;
                        }

                        @Override
                        public void deserialize(MyPetFeedEvent.Result o, Fields f) throws StreamCorruptedException, NotSerializableException {
                            assert false;
                        }

                        @Override
                        public boolean mustSyncDeserialization() {
                            return false;
                        }
                        @Override
                        protected MyPetFeedEvent.Result deserialize(Fields fields) throws StreamCorruptedException, NotSerializableException {
                            try {
                                return mypetstringtoclass.toResult((String) fields.getObject("mypetfeedresult"));
                            } catch (ClassCastException ex) {
                                throw new NotSerializableException(MyPetFeedEvent.Result.class.getName());
                            }
                        }
                        @Override
                        protected boolean canBeInstantiated() {
                            return false;
                        }
                    }));
        }
    }
}
