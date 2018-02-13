import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        list = reduce(list);
        for (Integer integer : list) {
            System.out.println(integer);

        }

    }

    private static Integer map(Integer integer) {

         return integer * 2;
    }

    private static List<Integer> reduce(List<Integer> list) {
        List<Integer> result = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (int i = 0; i < list.size(); i++) {
            Integer ix = list.get(i);

            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "start");
                    result.add(map(ix));
                    System.out.println(Thread.currentThread().getName() + "finished");
                }
            };
            executorService.execute(runnable);

        }
        executorService.shutdown();
        while (!executorService.isTerminated()){}
            System.out.println("All threads are finished");

        return result;

    }

}
