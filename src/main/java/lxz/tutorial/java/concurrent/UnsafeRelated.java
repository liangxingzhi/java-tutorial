package lxz.tutorial.java.concurrent;

import sun.misc.Unsafe;

public class UnsafeRelated {
  int a = 10;
  int b = 20;
  UnsafeRelated() {
    a = 10;
    b = 30;
  }
  public static void main(String[] args) {
    try {
      UnsafeRelated ur = (UnsafeRelated) getUnsafe().allocateInstance(UnsafeRelated.class);
      System.out.println(ur + ":" + ur.a + ":" +ur.b);
    } catch (Exception e) {

    }
  }

  private static Unsafe getUnsafe() {
    try {
      return sun.misc.Unsafe.getUnsafe();
    } catch (SecurityException tryReflectionInstead) {
      tryReflectionInstead.printStackTrace();
    }
    try {
      Class<sun.misc.Unsafe> k = sun.misc.Unsafe.class;
      for (java.lang.reflect.Field f : k.getDeclaredFields()) {
        f.setAccessible(true);
        Object x = f.get(null);
        if (k.isInstance(x)) {
          return k.cast(x);
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    // following will throw exception
    try {
      return java.security.AccessController.doPrivileged
          (new java.security.PrivilegedExceptionAction<Unsafe>() {
            public sun.misc.Unsafe run() throws Exception {
              return sun.misc.Unsafe.getUnsafe();
//              throw new NoSuchFieldError("the Unsafe");
            }
          });
    } catch (Exception e) {
      throw new RuntimeException("Could not initialize intrinsics",
          e.getCause());
    }

  }

}
