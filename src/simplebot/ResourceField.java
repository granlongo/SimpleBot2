/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplebot;

/**
 *
 * @author Longo
 */
public class ResourceField {

    String type;
    String CSSselector;
    int lvl;

    public ResourceField(String Check, String Selector) {
        CheckIron(Check);
        CheckClay(Check);
        CheckWood(Check);
        CheckCrop(Check);
        CSSselector = Selector;
    }
    
    void CheckIron(String Check) {
        String word = "Iron";
        Boolean Wood;

        Wood = Check.contains(word);

        if (Wood == true) {
            System.out.println("iron");

            String substring = Check.substring(16);
            int i = Integer.decode(substring);
            System.out.println(i);
            lvl =i;

        }
    }

void CheckClay(String Check) {
        String word = "Clay";
        Boolean Wood;

        Wood = Check.contains(word);

        if (Wood == true) {
            System.out.println("clay");

            String substring = Check.substring(15);
            int i = Integer.decode(substring);
            System.out.println(i);
            lvl=i;

        }
    }

    void CheckWood(String Check) {
        String word = "Woodcutter";
        Boolean Wood;

        Wood = Check.contains(word);

        if (Wood == true) {
            System.out.println("wood");

            String substring = Check.substring(17);
            int i = Integer.decode(substring);
            lvl=i;
            System.out.println(i);
 
        }
    }
      void CheckCrop(String Check) {
        String word = "Crop";
        Boolean Wood;

        Wood = Check.contains(word);

        if (Wood == true) {
            System.out.println("Crop");

            String substring = Check.substring(15);
            int i = Integer.decode(substring);
            System.out.println(i);
            lvl=i;
 
        }
    }
}
