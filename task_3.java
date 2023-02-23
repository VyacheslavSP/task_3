import java.util.*;

public class task_3 {

    public static void main(String[] args) {
        ArrayList<String> color = new ArrayList<>();
        color.add("Black");
        color.add("White");
        color.add("Yellow");
        color.add("Blue");
        System.out.println(color);
        int i=0;
        while (i<color.size()) {
            String tmp =color.get(i);
            tmp=tmp+"!";
            color.add(i, tmp);
            color.remove(i+1);
            i++;
        }
        System.out.println(color);
        color.add(0, "Green!");
        System.out.println(color);
        System.out.println(color.get(color.size()-1));
        color.add(0, "Red!");
        color.remove(0+1);
        System.out.println(color);
        color.remove(2); // ну допустим это 3 элемент
        System.out.println("Исходный массив "+color);
        System.out.println(find("Red!",color));
        ArrayList<String> color_new = new ArrayList<>();
        color_new.addAll(color);
        i=0;
        while (i<2) {         //допустим удалим 2
        color_new.remove(color_new.size()-1);
        i++;
        }
        ArrayList<String> tmp=new ArrayList<>();
        tmp.addAll(color);
        System.out.println("новый массив "+color_new);
        ArrayList<String> removed=remove_list(tmp,color_new);
        ArrayList<String> color_correct=change_list(color, tmp);
        System.out.println("откорректированый 1 массив "+color_correct); 
        Collections.sort(color_correct);// в этом месте можно написать огромную кучу кода. отсортировать цвета как? 
        //По координатам цвета, по кооринатам цветности, по яркости, по насыщенности, по цветовосприятию от разных источников света, по положению на оси нм основной несущей длины волны спектра и т.д. 
        //с точки зрения программирования основых вариантов 3. текстовый цвет по алфавиту , вариант представления цвета в 16-ричной 
        //системе и сортировать по значению, представление цвета как смесь RGB и сортировка по собственно значению компонента
        System.out.println("Отсортированый список "+color_correct);
        System.out.println(time_ArrayList());
        System.out.println(time_LinkedList());
    }
    public static ArrayList<String> find(String search, ArrayList<String> list) {
        ArrayList<String> matches = new ArrayList<String>();
    
        for(String str: list) {
            if (str.contains(search)) {
                matches.add(str);
            }
        }
    
        return matches;
    }
public static ArrayList<String> remove_list (ArrayList<String> first_arr,ArrayList<String> second_arr) {
    int i=0;
        while (i<second_arr.size()) {
            if(first_arr.contains(second_arr.get(i))){
                first_arr.remove(first_arr.indexOf(second_arr.get(i)));
            i++;
            }            
        }
    return first_arr;
}
public static ArrayList<String> change_list (ArrayList<String> first_arr,ArrayList<String> arr_deleted) {
    int i=0;
        while (i<first_arr.size()) {
            if(first_arr.contains(arr_deleted.get(0))){
                first_arr.remove(first_arr.indexOf(arr_deleted.get(0)));
                arr_deleted.remove(0);
            i++;
            }            
        }
    return first_arr;
}
public static String  time_ArrayList () {
    ArrayList<String> test_1=new ArrayList<>();
    int i=0;
    long time = System.nanoTime();
    while (i<1000) {         
        test_1.add("null ");
        i++;
        }
    time = System.nanoTime() - time;
    String time_1 = "ArrayList выполнено за " + time / 1_000_000.0 + " мс";
    return time_1;
}
public static String  time_LinkedList () {
    LinkedList<String> test_2=new LinkedList<>();
    int i=0;
    long time = System.nanoTime();
    while (i<1000) {         
        test_2.add("null ");
        i++;
        }
    time = System.nanoTime() - time;
    String time_2 = "LinkedList выполнено за " + time / 1_000_000.0 + " мс";
    return time_2;
}
}