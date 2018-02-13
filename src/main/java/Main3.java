import java.util.ArrayList;
import java.util.List;

public class Main3 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i <100 ; i++) {
           list.add(""+i);
        }
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i));

        }

        }
}
