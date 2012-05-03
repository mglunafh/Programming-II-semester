/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author FedorUvarychev
 */
import uniquelist.*;
import list.*;

public class Main {

    public static void print(UniqueList<Integer> list) {
        try {
            List.ListElement t = list.hd();
            while (t != null) {
                System.out.format("%d ", t.getValue());
                t = t.getNext();
            }
        } catch (EmptyListException e) {
            System.out.println();
        }
    }

    public static void main(String[] arg) {
        int count = 0;
        int magicConst = 10;
        int maxCount = 0;
        int satanized = 0;
        int state = 16;
        for (int k = 1; k < magicConst; ++k) {
            UniqueList<Integer> list = new UniqueList<Integer>();
            maxCount = 5 * k % 40;
            state = 4 * k % 29;
            System.out.format("\nmaximal count is %d, state is %d\n", maxCount, state);
            for (int i = 0; i < maxCount; ++i) {
                try {
                    satanized = (i + 14) * 3 % state;
                    System.out.format("%d ", satanized);
                    list.addToList(satanized);
                } catch (AlreadyExists e) {
                    System.out.print("");
                    count++;
                }

            }
            System.out.println();
            Main.print(list);
            System.out.format("\n Times exception was thrown: %d\n", count);
            count = 0;
        }
    }
}
