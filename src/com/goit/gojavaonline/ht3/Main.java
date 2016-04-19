package com.goit.gojavaonline.ht3;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Main {
   public static int guitarCount = 0;
   public static int pianoCount = 0;
   public static int trubaCount = 0;

   static ArrayList<MusicalEquipment> list = new ArrayList<>();


    public static void main(String[] args) {

                            // Вынесли копипасту циклов по добавлению новых музыкальных инструментов
                            // в отдельный метод
        // addEquipmentToShop
//        for (int i = 0; i < 5; i++) {
//            list.add(new Truba());
//            trubaCount++;
//        }
//
//        for (int i = 0; i < 5; i++) {
//            list.add(new Piano());
//            pianoCount++;
//        }
//
//        for (int i = 0; i < 5; i++) {
//            list.add(new Guitar());
//            guitarCount++;
//        }
        addEquipmentToShop(4, new Truba());
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

    public static void addEquipmentToShop(int numberOfEquipment, MusicalEquipment nameOfEquipment){
        for (int i = 0; i < numberOfEquipment; i++) {
            if(nameOfEquipment instanceof Guitar){
                list.add(new Guitar());
                guitarCount++;
            }
            else if(nameOfEquipment instanceof Truba){
                list.add(new Truba());
                trubaCount++;
            }
            else if(nameOfEquipment instanceof Piano){
                list.add(new Piano());
                pianoCount++;
            }
        }
    }

}
