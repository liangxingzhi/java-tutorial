package lxz.tutorial.java.algorithm.classic40;

/**
 * 题目：海滩上有一堆桃子，五只猴子来分。第一只猴子把这堆桃子凭据分为五份，多了一个，这只猴子把多的一个扔入海中，拿走了一份。
 *
 * 第二只猴子把剩下的桃子又平均分成五份，又多了一个，它同样把多的一个扔入海中，拿走了一份，
 *
 * 第三、第四、第五只猴子都是这样做的，问海滩上原来最少有多少个桃子？
 */
public class MonkeyEatPeach2 {

  public static void main(String[] args) {
    int round = 0;
    boolean found = false;
    while (!found) {
      int n = round++;
      for (int i = 0; i < 5; i++) {
        n = getPrevious(n);
        if (i < 4) {
          if (n % 4 != 0) {
            break;
          }
        } else if (i == 4) {
          found = true;
          System.out.println("the original number is " + n);
          for (int j = 0; j < 4; j++) {
            n = getNext(n);
            System.out.println(n);
          }
        }
      }

    }
  }

  /**
   * 最后剩n个，那么上一次的个数是，n/4 * 5 + 1
   *
   * @param n 最后剩n个
   * @return 上一次剩几个
   */
  public static int getPrevious(int n) {
    return n / 4 * 5 + 1;
  }

  /**
   *
   * @param n
   * @return
   */
  public static int getNext(int n) {
    return (n - 1) / 5 * 4;
  }
}


class Dg {

  static int ts = 0;//桃子总数
  static int hs = 5;//猴子数...
  int fs = 1;//记录分的次数
  int tsscope = 5000;//桃子数的取值范围.太大容易溢出.

  public static void main(String[] args) {
    new Dg().fT(0);
  }

  public int fT(int t) {
    if (t == tsscope) {
//当桃子数到了最大的取值范围时取消递归
      System.out.println("结束");
      return 0;
    } else {
      if ((t - 1) % hs == 0 && fs <= hs) {
        if (fs == hs) {
          System.out.println("桃子数 = " + ts + " 时满足分桃条件");
        }
        fs += 1;
        return fT((t - 1) / 5 * 4);// 返回猴子拿走一份后的剩下的总数
      } else {
//没满足条件
        fs = 1;//分的次数重置为1
        return fT(ts += 1);//桃子数加+1
      }
    }
  }

}