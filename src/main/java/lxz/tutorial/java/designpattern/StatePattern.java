package lxz.tutorial.java.designpattern;

/**
 * 在状态模式中，我们创建表示各种状态的对象和一个行为随着状态对象改变而改变的 context 对象。 当一个对象内在状态改变时允许其改变行为，这个对象看起来像是改变了其类。说实话，这个定义的后半句我也没看懂，看过GOF
 * 才明白是怎么回事: Allow an object to alter its behavior when its internal state changes. The object will
 * appear to change its class. [GoF, p305]，也就是说状态模式封装的非常好，状态的变更引起了行为的变更，从外部看起来就好像这个对象对应的类发生了改变一样。
 *
 * 其实就是行为与状态有关联，所以呢，不同状态只能允许执行特定的行为，执行完成后，进入下一个状态，整个过程就是一个状态机，按照允许的行为流转
 *
 * 如果不把这种流程的流转拆分成不同的状态加以控制的话，就会在每一种行为中加入状态判断的if／else来实现状态对行为的控制，拆分成不同状态就会产生有的行为在当前状态不能被执行，
 * 那么对应的方法就是空的或者抛异常，因为状态接口包扩所有状态的方法
 *
 * 行为可以改变状态，状态可以限制行为
 */
public class StatePattern {

  public static void main(String[] args) {
    Context context = new Context();
    context.setState(new WaterState());

    context.getState().freeze(context);
    context.getState().melt(context);
    context.getState().boil(context);
    context.getState().condenses(context);

    context.getState().melt(context);
  }

  interface H2OState {

    // water
    void freeze(Context context);

    void boil(Context context);

    // ice
    void melt(Context context);

    // vapor
    //v. 浓缩；使缩短（condense的三单形式）,水蒸气凝结成水
    void condenses(Context context);
  }

  static class Context {

    H2OState state;

    public H2OState getState() {
      return state;
    }

    public void setState(H2OState state) {
      this.state = state;
    }
  }

  //水蒸气
  static class VapourState implements H2OState {

    @Override
    public void freeze(Context context) {
      throw new UnsupportedOperationException("vapour can't be freeze");
    }

    @Override
    public void boil(Context context) {
      throw new UnsupportedOperationException("vapour can't be boil");
    }

    @Override
    public void melt(Context context) {
      throw new UnsupportedOperationException("vapour can't be melt");
    }

    @Override
    public void condenses(Context context) {
      System.out.println("vapour is condenses and state is changed to water");
      context.setState(new WaterState());
    }
  }

  static class WaterState implements H2OState {

    @Override
    public void freeze(Context context) {
      System.out.println("water is frozen and state is changed to ice");
      context.setState(new IceState());
    }

    @Override
    public void boil(Context context) {
      System.out.println("water is boiled and state is changed to vapour");
      context.setState(new VapourState());
    }

    @Override
    public void melt(Context context) {
      throw new UnsupportedOperationException("water can't be melt");
    }

    @Override
    public void condenses(Context context) {
      throw new UnsupportedOperationException("water can't be condenses");
    }
  }

  static class IceState implements H2OState {

    @Override
    public void freeze(Context context) {
      throw new UnsupportedOperationException("ice can't be freeze");
    }

    @Override
    public void boil(Context context) {
      throw new UnsupportedOperationException("ice can't be boil");
    }

    @Override
    public void melt(Context context) {
      context.setState(new WaterState());
      System.out.println("ice is melt and state is changed to water");
    }

    @Override
    public void condenses(Context context) {
      throw new UnsupportedOperationException("ice can't be condenses");
    }
  }


}
