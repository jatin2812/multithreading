package producerconsumer;

public class producer implements Runnable{
    SharedResource sharedResource;

    producer(SharedResource sharedResource){
        this.sharedResource = sharedResource;
    }

    @Override
    public  void run(){
        for(int i=0;i<5;i++){
            try{
                sharedResource.produce(i);
            }catch (Exception e){

            }
        }
    }
}
