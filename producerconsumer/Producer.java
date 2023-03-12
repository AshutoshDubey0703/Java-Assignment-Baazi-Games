package producerconsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This producer class creates a job from list of jobs mentioned in the static field.
 * Using random number generator to select random job.
 */
public class Producer extends Thread
{
    public static final List<String> jobList = new ArrayList<>(
            List.of("Purchase Milk", "Sleep a little", "Complete your java assignment",
            "Learn coding", "Invest in stocks", "Do laundry", "Cook some food"));
    public static final Random random = new Random();
    private final DataBuffer dataBuffer;
    private final int id;

    public Producer(DataBuffer dataBuffer, int id) {
        this.dataBuffer = dataBuffer;
        this.id = id;
    }

    @Override
    public void run() {
        while (true){
            try {
                this.dataBuffer.createJob(jobList.get(random.nextInt(jobList.size())), this.id);
                sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
