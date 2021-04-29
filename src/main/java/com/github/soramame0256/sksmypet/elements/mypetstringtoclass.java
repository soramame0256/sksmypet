package com.github.soramame0256.sksmypet.elements;

import de.Keyle.MyPet.api.event.MyPetFeedEvent;

public class mypetstringtoclass {
    public static MyPetFeedEvent.Result toResult(String s) {
        if (s == "Heal") {
            return MyPetFeedEvent.Result.Heal;
        } else if (s == "Eat") {
            return MyPetFeedEvent.Result.Eat;
        }
        return null;
    }
}
