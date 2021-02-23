import java.util.*;

public class TruckSpace {
    public static void main(String[] args) {
        // num: an integer representing the number of products
        int num = 3;

        // boxes: a list of integers representing the number of available boxes for products
        List<Integer> boxes = new ArrayList<>(Arrays.asList(5, 2, 4, 3));

        //unitSize: an integer representing size of unitsPerBox
        int unitSize = 3;

        //unitsPerBox: a list of integers representing the number of units packed in each box
        List<Integer> unitsPerBox = new ArrayList<>(Arrays.asList(10, 5, 7, 9));

        //truckSize: an integer representing the number of boxes the truck can carry.
        int truckSize = 10;

        System.out.println(fillTheTruck(num, boxes, unitSize, unitsPerBox, truckSize));
    }

    private static int fillTheTruck(int num, List<Integer> boxes, int unitSize, List<Integer> unitsPerBox, int truckSize) {
        int unitCount = 0;
        int boxesLeft = truckSize;

        HashMap<Integer, Integer> unitsInBoxes = new HashMap<>();

        for(int i=0; i<boxes.size();i++){
            unitsInBoxes.put(unitsPerBox.get(i), boxes.get(i));
        }

        /** Hashmap "unitsInBoxes"
         * key  ->  Value
         * 5    ->   10
         * 2    ->   5
         * 4    ->   7
         * 3    ->   9
         * */
        int i = 0;

        Collections.sort(unitsPerBox, Collections.reverseOrder());

        /** unitsPerBox sorted in desccending order
         * {10, 9, 7, 5}
         * */

        while(boxesLeft > 0){
            int count = unitsInBoxes.get(unitsPerBox.get(i));
            if(boxesLeft - count > 0){
                boxesLeft = boxesLeft - count;
            } else {
                count = boxesLeft;
                boxesLeft = 0;
            }
            unitCount = unitCount + count*unitsPerBox.get(i);
            i++;
        }

        return unitCount;
    }
}
