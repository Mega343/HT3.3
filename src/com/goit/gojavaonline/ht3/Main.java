package com.goit.gojavaonline.ht3;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Main {
   public static int guitarCount = 0;
   public static int  pianoCount = 0;
   public static int trubaCount = 0;



    public static void main(String[] args) {
        ArrayList<MusicalEquipment> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(new Truba());
            trubaCount++;
        }

        for (int i = 0; i < 5; i++) {
            list.add(new Piano());
            pianoCount++;
        }

        for (int i = 0; i < 5; i++) {
            list.add(new Guitar());
            guitarCount++;
        }
        MusicShop musicShop = new MusicShop(list);
        musicShop.setList(list);



        Map<String, Integer> order = new HashMap<>();
        order.put("truba", 3);
        order.put("guitar", 5);
        order.put("piano", 2);

       // System.out.println(musicShop.prepareInstruments(musicShop, order));


            try {
                ArrayList<MusicalEquipment> musicalEquipmentsToRemove = musicShop.prepareInstruments(musicShop, order);
                musicShop.removeEquipmentFromTheShop(musicShop, musicalEquipmentsToRemove);
                System.out.println("Order: " + musicalEquipmentsToRemove);
            } catch (Exception e) {
                System.out.println("Exception happened: " + e.getMessage());
            }

        System.out.println();

        System.out.println("The balance: " + musicShop.getList());

    }

}
