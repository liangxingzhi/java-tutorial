package lxz.tutorial.java.jvm;

// Setting1:
// -XX:+HeapDumpOnOutOfMemoryError -Xmx1m -Xms1m -Xmn10k -XX:MetaspaceSize=1m -XX:MaxMetaspaceSize=1m -XX:+PrintGCTimeStamps
//
// Error1:
// Error occurred during initialization of VM
// MaxMetaspaceSize is too small.
//
// Process finished with exit code 1
public class OOMCase {

  public static void main(String[] args) {
    try {
      Thread.sleep(10);
      for(;;){
        String a = new String("hello");
      }

    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    } catch (Error e) {
      e.printStackTrace();
      throw e;
    }
  }
}
