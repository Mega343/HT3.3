package com.goit.gojavaonline.ht3;

import java.util.*;

public class MusicShop {


    ArrayList<MusicalEquipment> list;

    public ArrayList<MusicalEquipment> getList() {
        return list;
    }

    public void setList(ArrayList<MusicalEquipment> list) {
        this.list = list;
    }

    public MusicShop(MusicalEquipment equipment) {
        list.add(equipment);
   }

    public MusicShop(ArrayList<MusicalEquipment> list) {
        if (!list.isEmpty())
            list.addAll(list);
        else try {
            throw new ShopIsEmptyException();
        } catch (ShopIsEmptyException e) {
            System.out.println("Warehouse is empty!");
        }

    }

    public ArrayList<MusicalEquipment> prepareInstruments(MusicShop musicShop, Map<String, Integer> order) {
        ArrayList<MusicalEquipment> result = new ArrayList<>();
        for (Map.Entry<String, Integer> orderEntry : order.entrySet()) {
            String musicEquipmentType = orderEntry.getKey();
            Integer orderValue = orderEntry.getValue();
            if (orderValue <= 0)
                try {
                    throw new InvalidValueOfOrderException();
                } catch (InvalidValueOfOrderException e) {
                    System.out.println("The value can not be negative");
                }

            int numberOfMusicEquipmentToRemove = 0;
            for (MusicalEquipment musicalEquipment : musicShop.getList()) {
                if (musicalEquipment.getType().equals(musicEquipmentType) && numberOfMusicEquipmentToRemove < orderValue) {
                    result.add(musicalEquipment);
                    numberOfMusicEquipmentToRemove++;
                }
            }
            if (numberOfMusicEquipmentToRemove < orderValue)
                try {
                    throw new InvalidKeyException();
                } catch (InvalidKeyException e) {
                    System.out.println("Shop does not have enough " + musicEquipmentType + " or your key is Invalid" + "s");
                }
        }
        return result;
    }

    public static void removeEquipmentFromTheShop(MusicShop musicShop, Map<String, Integer> order) {
        for (Map.Entry<String, Integer> orderEntry : order.entrySet()) {
            String musicEquipmentType = orderEntry.getKey();
            Integer orderValue = orderEntry.getValue();
            int numberOfMusicEquipmentToRemove = 0;
            Iterator<MusicalEquipment> iterator = musicShop.getList().iterator();
            while (iterator.hasNext()) {
                MusicalEquipment musicalEquipment = iterator.next();
                if (musicalEquipment.getType().equals(musicEquipmentType) &&
                        numberOfMusicEquipmentToRemove < orderValue) {
                    iterator.remove();
                    numberOfMusicEquipmentToRemove++;
                }
            }
        }

    }
}
