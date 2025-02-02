package mergesort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class mergesort implements Callable<List<Integer>> {
    private List<Integer> arrayToSort;
    private ExecutorService executorService;

    public mergesort(List<Integer> arrayToSort, ExecutorService executorService) {
        this.arrayToSort = arrayToSort;
        this.executorService = executorService;
    }

    @Override
    public List<Integer> call() throws Exception {
        if (arrayToSort.size() <= 1) {
            return arrayToSort;
        }
        //System.out.println(Thread.currentThread().getName());
        List<Integer> leftArray  = new ArrayList<Integer>();
        List<Integer> rightArray = new ArrayList<Integer>();
        int mid = arrayToSort.size()/2;
        for(int i=0;i<arrayToSort.size();i++){
            if(i<mid){
                leftArray.add(arrayToSort.get(i));
            }
            else{
                rightArray.add((arrayToSort.get(i)));
            }
        }
        mergesort left = new mergesort(leftArray,executorService);
        mergesort right = new mergesort(rightArray,executorService);


        Future<List<Integer>> l =  executorService.submit(left);
        Future<List<Integer>> r =  executorService.submit(right);

       List<Integer> leftSorted =  l.get();
        List<Integer> rightSorted = r.get();

        List<Integer> sortedArray = new ArrayList<Integer>();

        int i=0; int j=0;

        while(i<leftSorted.size() && j<rightSorted.size()){
            if(leftSorted.get(i)<rightSorted.get(j)){
                sortedArray.add(leftSorted.get(i));
                i++;
            }
            else{
                sortedArray.add(rightSorted.get(j));
                j++;
            }
        }
        while(i<leftSorted.size()){
            sortedArray.add(leftSorted.get(i));
            i++;
        }

        while(i<rightSorted.size()){
            sortedArray.add(rightSorted.get(i));
            j++;
        }

        return sortedArray;
    }
}
