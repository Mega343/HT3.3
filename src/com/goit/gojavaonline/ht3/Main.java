package com.goit.gojavaonline.ht3;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Main {


    public static void main(String[] args) {
        ArrayList<MusicalEquipment> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list.add(new Truba());
        }

        for (int i = 0; i < 50; i++) {
            list.add(new Piano());
        }

        for (int i = 0; i < 50; i++) {
            list.add(new Guitar());
        }
        MusicShop musicShop = new MusicShop(list);
        musicShop.setList(list);



        Map<String, Integer> order = new HashMap<>();
        order.put("truba", 50);
        order.put("guitar", 49);
        order.put("piano", 48);

       // System.out.println(musicShop.prepareInstruments(musicShop, order));



            try {
                ArrayList<MusicalEquipment> musicalEquipmentsToRemove = musicShop.prepareInstruments(musicShop, order);
                musicShop.removeEquipmentFromTheShop(musicShop, order);
                System.out.println("Order: " + musicalEquipmentsToRemove);
            } catch (Exception e) {
                System.out.println("Exception happened: " + e.getMessage());
            }



    }

}
