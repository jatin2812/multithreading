package mergesort;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.*;

public class client {

    public static void main(String[] args) throws Exception {
       // ExecutorService executorService = new ThreadPoolExecutor(5,10,10, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(10));

        ExecutorService executorService = Executors.newCachedThreadPool();

        List<Integer> arrayToSort =  List.of(
                10, 2, 8, 11, 4, 3, 9, 1
        );

        mergesort sorter =  new mergesort(arrayToSort,executorService);
        Future<List<Integer>> sortedListFuture = executorService.submit(sorter);
        List<Integer> sortedList = sortedListFuture.get();
        for (Integer i:sortedList){
            System.out.println(i);
        }

        executorService.shutdown();
    }
}
