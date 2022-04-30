import java.util.ArrayList;

public class RubyTest {
//Given an array of time intervals for people entering and leaving a room consisting of start and
// end times [[s1,e1],[s2,e2],...] (si < ei). What is the maximum number of people in the room
// simultaneously?
// Examples:
// Input: [[2, 10], [3, 4], [6, 9]]
// Output: 2
// Input: [[1, 3], [2, 4], [2, 5], [3, 4], [3, 6], [4, 5], [5, 6]]
// Output: 4
// Input: [[1, 8], [2, 7], [3, 5], [5, 7], [6, 7], [6, 8], [7, 8]]
// Output: 5
    public static void main(String[] args) {

int [][] interval = {{1, 8}, {2, 7}, {3, 5}, {5, 7}, {6, 7}, {6, 8}, {7, 8}};  //двумерный массив со входящими значениями интервалов
        ArrayList <int[]> peopleInTheRoom = new ArrayList<>();// создаю ArrayList, в котором буду учитывать протекающие встречи, добавлять новые, удалять завершившиеся
        peopleInTheRoom.add(interval[0]); // сразу добавляю первую встречу

        for (int i = 1; i < interval.length; i++) {

           int[] a = peopleInTheRoom.get(0);//вспопогательный элемент, извлекает из ArrayList встречу, которая должна закончиться самой первой
           if(a[1] <= interval[i][0]) {//проверяем есть ли встречи, которые уже закончились, если все встречи еще идут добавляем новую встречу в ArrayList
                peopleInTheRoom.remove(0); //удаляю закончившуюся встречу
            }
                peopleInTheRoom.add(interval[i]);
            // сортирую методом пузырька, чтоб встреча, заканчивающаяся первой стала на первое место в списке
            boolean isSorted = false;
            int [] buf;
            while(!isSorted) {
                isSorted = true;
                for (int j = 0; j < peopleInTheRoom.size() - 1; j++) {
                    int[] h1 = peopleInTheRoom.get(j);
                    int[] h2 = peopleInTheRoom.get(j + 1);
                    if (h1[1] > h2[1]) {
                        isSorted = false;
                        buf = h1;
                        peopleInTheRoom.remove(j);
                        peopleInTheRoom.add(j+1, buf);
                    }
                }
            }
        }
        System.out.println("The maximum number of people in the room simultaneously is " + peopleInTheRoom.size());
    }
}
