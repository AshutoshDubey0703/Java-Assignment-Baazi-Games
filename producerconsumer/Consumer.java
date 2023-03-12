package producerconsumer;

/**
 * This consumer class completes a job given the consumer id.
 */
public class Consumer extends Thread
{
    private final DataBuffer dataBuffer;
    private final int id;

    public Consumer(DataBuffer dataBuffer, int id) {
        this.dataBuffer = dataBuffer;
        this.id = id;
    }

    @Override
    public void run() {
        while (true){
            try {
                this.dataBuffer.completeJob(this.id);
                sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
