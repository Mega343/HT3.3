package com.goit.gojavaonline.ht3;

import java.util.*;

public class MusicShop {

    HashSet<MusicalEquipment> list;
    public MusicShop(MusicalEquipment equipment) {
        list.add(equipment);
    }

    public MusicShop(HashSet<MusicalEquipment> name) {
        if (!name.isEmpty())
            list.addAll(name);
        // else
        // error
    }

}
