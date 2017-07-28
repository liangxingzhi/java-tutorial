package lxz.tutorial.java.invoke;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class MethodHandleRelated {

	
	public static void main(String[] args) {
		(new MethodHandleRelated().new Son()).thinking();
	}
	
	class GrandFather {
		protected void thinking() {
			System.out.println("GrandFather thinking");
		}
	}
	
	class Father extends GrandFather {
		protected void thinking() {
			System.out.println("Father thinking");
		}
	}
	
	class Son extends Father {
		protected void thinking() {
			try {
				super.thinking();
				MethodType mt = MethodType.methodType(void.class);
				MethodHandle mh = MethodHandles.lookup().findSpecial(GrandFather.class, "thinking", mt, getClass());
				mh.invoke(this);
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}
}

