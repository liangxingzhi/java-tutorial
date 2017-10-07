package lxz.tutorial.java.designpattern;

/**
 * 将开机的流程多个步骤整个到一个接口方法中，用户只需要关注一个"按开机键"的接口即可，隐藏了内部的实现
 */
public class FacadePattern {

  public static void main(String[] args) {
    new LinuxPowerOnFacade(new CentOsStartUpProcess()).pressPowerButton();
  }

  interface LinuxStartUpProcess {

    void bios();

    void mbr();

    void grub();

    void kernel();

    void init();

    void runlevel();
  }

  static class LinuxPowerOnFacade {

    LinuxStartUpProcess process;

    LinuxPowerOnFacade(LinuxStartUpProcess process) {
      this.process = process;
    }

    public void pressPowerButton() {
      process.bios();
      process.mbr();
      process.grub();
      process.kernel();
      process.init();
      process.runlevel();
    }
  }

  static class CentOsStartUpProcess implements LinuxStartUpProcess {

    @Override
    public void bios() {
      System.out.println("bios");
    }

    @Override
    public void mbr() {
      System.out.println("mbr");
    }

    @Override
    public void grub() {
      System.out.println("grub");
    }

    @Override
    public void kernel() {
      System.out.println("kernel");
    }

    @Override
    public void init() {
      System.out.println("init");
    }

    @Override
    public void runlevel() {
      System.out.println("runlevel");
    }
  }

}
