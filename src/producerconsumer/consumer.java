package producerconsumer;

public class consumer implements Runnable{
    SharedResource sharedResource;

    consumer(SharedResource sharedResource){
        this.sharedResource = sharedResource;
    }

    @Override
    public  void run(){
        for(int i=0;i<5;i++){
            try{
                Thread.sleep(1000);

                sharedResource.consume();
            }catch (Exception e){

            }
        }
    }
}
