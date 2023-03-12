package producerconsumer;

import java.util.LinkedList;

/**
 * This is DataBuffer class where producer wil be adding new tasks
 * and consumer will be consuming from this task queue.
 * This class can be used for multiple producer consumers as well.
 */
public class DataBuffer {
    private LinkedList<String> jobs = new LinkedList<>();
    private final int bufferSize;

    public DataBuffer(int bufferSize) {
        this.bufferSize = bufferSize;
    }

    /**
     * This is producer method to create new jobs.
     *
     * @param job        - Job description
     * @param producerId - producer id that is creating this job.
     * @throws InterruptedException - if any.
     */
    public synchronized void createJob(String job, int producerId) throws InterruptedException {
        while (jobs.size() == this.bufferSize) {
            System.out.println("Job queue is full. Waiting for consumer " + producerId + " to consume.");
            wait();
        }

        System.out.println("Producer with id " + producerId + " produced job " + job);
        jobs.add(job);
        System.out.println("Number of jobs in the queue for id " + producerId + " is " + jobs.size());

        notifyAll();
    }

    /**
     * This is consumer method to complete jobs from queue.
     *
     * @param consumerId - Id of consumer that is completing the job.
     * @throws InterruptedException - if any
     */
    public synchronized void completeJob(int consumerId) throws InterruptedException {
        while (jobs.isEmpty()) {
            System.out.println("Job queue is empty. Waiting for producer " + consumerId + " to produce.");
            wait();
        }

        System.out.println("Consumer with id " + consumerId + " consumed job " + jobs.get(0));
        jobs.remove(0);
        System.out.println("Number of jobs in the queue for id " + consumerId + " is  " + jobs.size());

        notifyAll();
    }
}
