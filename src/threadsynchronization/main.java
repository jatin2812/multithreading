package threadsynchronization;

public class main {

    public static void main(String[] args) {
        threethreadsync printer1 = new threethreadsync(1);
        threethreadsync printer2 = new threethreadsync(2);
        threethreadsync printer3 = new threethreadsync(3);

        Thread t1 =  new Thread(printer1);
        Thread t2 = new Thread(printer2);
        Thread t3 = new Thread(printer3);

        t1.start();
        t2.start();
        t3.start();

    }
}
