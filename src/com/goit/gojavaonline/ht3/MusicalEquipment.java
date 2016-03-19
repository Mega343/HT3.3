package com.goit.gojavaonline.ht3;

import java.util.HashSet;
import java.util.List;

public abstract class  MusicalEquipment {

    public abstract String getType();

    @Override
    public String toString() {
        return "MusicEquipment{"+getType()+"}";
    }
}
