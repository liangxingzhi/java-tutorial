package lxz.tutorial.java.thread;

public class ThreadJoin
{
    public static void main(String[] args)
    {
        Thread a = new Thread(new DemoThread(null, "A"));
        Thread b = new Thread(new DemoThread(a, "B"));
        Thread c = new Thread(new DemoThread(b, "C"));
        c.start();
        b.start();
        a.start();
    }

    static class DemoThread implements Runnable
    {
        private Thread prev;

        private String name;

        DemoThread(Thread prev, String name)
        {
            this.prev = prev;
            this.name = name;
        }

        @Override
        public void run()
        {
            System.out.println("Thread "+name+" before");
            if (prev != null)
            {
                try
                {
                    // 1 in fact, current thread is calling wait method of prev Object, 
                    // 2 only when prev Thread run finished and before exit, 
                    // 3 prev Thread native code will call prev Ojbect notify, 
                    // 4 then the current thread can get the prev object monitor and run again
                    prev.join();
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
            System.out.println("Thread "+name+" execute");
            System.out.println("Thread "+name+" after");
        }
    }
}





///jdk7/hotspot/src/share/vm/runtime/thread.cpp
//void JavaThread::run() {
//    ...
//    thread_main_inner();
//  }
//
//  void JavaThread::thread_main_inner() {
//    ...
//    this->exit(false);
//    delete this;
//  }
//
//  void JavaThread::exit(bool destroy_vm, ExitType exit_type) {
//    ...
//    // Notify waiters on thread object. This has to be done after exit() is called
//    // on the thread (if the thread is the last thread in a daemon ThreadGroup the
//    // group should have the destroyed bit set before waiters are notified).
//    ensure_join(this);
//    ...
//  }
//
//  static void ensure_join(JavaThread* thread) {
//    // We do not need to grap the Threads_lock, since we are operating on ourself.
//    Handle threadObj(thread, thread->threadObj());
//    assert(threadObj.not_null(), "java thread object must exist");
//    ObjectLocker lock(threadObj, thread);
//    // Ignore pending exception (ThreadDeath), since we are exiting anyway
//    thread->clear_pending_exception();
//    // Thread is exiting. So set thread_status field in  java.lang.Thread class to TERMINATED.
//    java_lang_Thread::set_thread_status(threadObj(), java_lang_Thread::TERMINATED);
//    // Clear the native thread instance - this makes isAlive return false and allows the join()
//    // to complete once we've done the notify_all below
//    java_lang_Thread::set_thread(threadObj(), NULL);
//    lock.notify_all(thread);
//    // Ignore pending exception (ThreadDeath), since we are exiting anyway
//    thread->clear_pending_exception();
//  }