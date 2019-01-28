package lxz.tutorial.java.executors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorDemo
{
    public static void main(String[] args)
            throws InterruptedException, ExecutionException
    {
        WaitList wl = new WaitList(0, new ArrayList<Integer>(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
        ScheduledExecutorService ses = Executors
                .newSingleThreadScheduledExecutor();
         oneShotCallableTask(wl, ses, 5);
//        oneShotRunnableTask(wl, ses, 5);
        // periodicRunnableTask(wl, ses, 5);
         ses.shutdown();
         System.out.println(ses.isTerminated());
         System.out.println(ses.isShutdown());
         ses.shutdown();
         oneShotCallableTask(wl, ses, 5);
    }

    /**
     * 
     * @description 定时调度，一次性
     * @param wl
     * @param ses
     * @return 有返回值
     * @throws InterruptedException
     * @throws ExecutionException
     * @author ezliagu
     */
    public static Integer oneShotCallableTask(WaitList wl,
            ScheduledExecutorService ses, int delay)
            throws InterruptedException, ExecutionException
    {
        long start = System.currentTimeMillis();
        System.out.println(
                "-------------------before--------------- at " + start);
        ScheduledFuture<Integer> sf = ses.schedule(new CallableTask(wl), delay,
                TimeUnit.MILLISECONDS);
        Integer result = sf.get();
        System.out.println(result);
        return result;
    }

    /**
     * 
     * @description 定时调度，一次性
     * @param wl
     * @param ses
     * @throws InterruptedException
     * @throws ExecutionException
     * @author ezliagu
     */
    public static void oneShotRunnableTask(WaitList wl,
            ScheduledExecutorService ses, int delay)
            throws InterruptedException, ExecutionException
    {
        long start = System.currentTimeMillis();
        System.out.println(
                "-------------------before--------------- at " + start);
        ses.schedule(new RunnableTask(wl), delay, TimeUnit.MILLISECONDS);
    }

    /**
     * 
     * @description 定时调度，周期运行，固定延时
     * @param wl
     * @param ses
     * @param delay
     * @throws InterruptedException
     * @throws ExecutionException
     * @author ezliagu
     */
    public static void periodicRunnableTask(WaitList wl,
            ScheduledExecutorService ses, int delay)
            throws InterruptedException, ExecutionException
    {
        long start = System.currentTimeMillis();
        System.out.println(
                "-------------------before--------------- at " + start);
        ses.scheduleWithFixedDelay(new RunnableTask(wl), delay, delay,
                TimeUnit.MILLISECONDS);
        ses.shutdown();
    }

    static class WaitList
    {
        private int position;

        private List<Integer> waitList;

        public WaitList(int position, List<Integer> waitList)
        {
            this.position = position;
            this.waitList = waitList;
        }

        public Integer next()
        {
            return waitList.get(position++ % waitList.size());
        }
    }

    static class RunnableTask implements Runnable
    {
        private WaitList waitList;

        public RunnableTask(WaitList waitList)
        {
            this.waitList = waitList;
        }

        @Override
        public void run()
        {
            System.out.println("-------------------after--------- at "
                    + System.currentTimeMillis());
            System.out.println(waitList.next());
        }
    }

    static class CallableTask implements Callable<Integer>
    {
        private WaitList waitList;

        public CallableTask(WaitList waitList)
        {
            this.waitList = waitList;
        }

        @Override
        public Integer call()
        {
            System.out.println("-------------------after--------- at "
                    + System.currentTimeMillis());
            return waitList.next();
        }
    }

}
