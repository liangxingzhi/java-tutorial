package lxz.tutorial.java.exception;

public class ExceptionRelated {

  public static void main(String[] args) {
    ExceptionRelated er = new ExceptionRelated();
    er.eatExceptionWithFinally1();
    er.eatExceptionWithFinally2();
//    er.throwAfterCatch();
    er.throwWithoutCatch();
  }

  public void eatExceptionWithFinally1() {
    try {
      throw new RuntimeException();
    } catch (Exception e) {
      throw e;
    } finally {
      return;
    }
  }

  public void eatExceptionWithFinally2() {
    try {
      throw new RuntimeException();
    } finally {
      return;
    }
  }

  public void throwAfterCatch() {
    try {
      throw new RuntimeException();
    } catch (Exception e) {
      throw e;
    }
  }

  public void throwWithoutCatch() {
    try {
      throw new RuntimeException();
    } finally {

    }
  }
}
