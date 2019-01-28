package lxz.tutorial.java.thread;

import java.util.concurrent.TimeUnit;

public class ThreadJoin2 {
	public static void main(String[] args) throws InterruptedException {
		Thread a = new Thread(new DemoThread("A"));
		Thread b = new Thread(new DemoThread("B"));
		Thread c = new Thread(new DemoThread("C"));
		a.start();
		a.join();
		b.start();
		b.join();
		c.start();
		c.join();
	}

	static class DemoThread implements Runnable {
		private String name;

		DemoThread(String name) {
			this.name = name;
		}

		@Override
		public void run() {
			try {
				TimeUnit.MILLISECONDS.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Thread " + name + " execute");
		}
	}
}

/// jdk7/hotspot/src/share/vm/runtime/thread.cpp
// void JavaThread::run() {
// ...
// thread_main_inner();
// }
//
// void JavaThread::thread_main_inner() {
// ...
// this->exit(false);
// delete this;
// }
//
// void JavaThread::exit(bool destroy_vm, ExitType exit_type) {
// ...
// // Notify waiters on thread object. This has to be done after exit() is
/// called
// // on the thread (if the thread is the last thread in a daemon ThreadGroup
/// the
// // group should have the destroyed bit set before waiters are notified).
// ensure_join(this);
// ...
// }
//
// static void ensure_join(JavaThread* thread) {
// // We do not need to grap the Threads_lock, since we are operating on
/// ourself.
// Handle threadObj(thread, thread->threadObj());
// assert(threadObj.not_null(), "java thread object must exist");
// ObjectLocker lock(threadObj, thread);
// // Ignore pending exception (ThreadDeath), since we are exiting anyway
// thread->clear_pending_exception();
// // Thread is exiting. So set thread_status field in java.lang.Thread class to
/// TERMINATED.
// java_lang_Thread::set_thread_status(threadObj(),
/// java_lang_Thread::TERMINATED);
// // Clear the native thread instance - this makes isAlive return false and
/// allows the join()
// // to complete once we've done the notify_all below
// java_lang_Thread::set_thread(threadObj(), NULL);
// lock.notify_all(thread);
// // Ignore pending exception (ThreadDeath), since we are exiting anyway
// thread->clear_pending_exception();
// }