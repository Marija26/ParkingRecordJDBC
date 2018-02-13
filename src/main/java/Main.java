


// Map 1 tb = 100*10gb Reduce

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            strings.add("" + i);
        }

        strings = reduce(strings);

        for (String string : strings) {
            System.out.println(string);
        }
    }

    private static String map(String str){
        return str + ".";
    }

    private static List<String> reduce(List<String> list){
        List<String> result = new ArrayList<>();

        ExecutorService executorService = Executors.newFixedThreadPool(100);

        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);

            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " start");
                    result.add(map(str));
                    System.out.println(Thread.currentThread().getName() + " end");
                }
            };

            executorService.execute(runnable);
        }

        executorService.shutdown();

        while (!executorService.isTerminated()){}

        System.out.println("Finished all threads");

        return result;
    }

}


