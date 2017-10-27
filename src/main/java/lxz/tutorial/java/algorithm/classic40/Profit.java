package lxz.tutorial.java.algorithm.classic40;

import java.util.Scanner;

/**
 * 【程序12】  题目：企业发放的奖金根据利润提成。利润(I)低于或等于10万元时，奖金可提10%；利润高于10万元，
 *
 * 低于20万元时，低于10万元的部分按10%提成，高于10万元的部分，可可提成7.5%；20万到40万之间时，
 *
 * 高于20万元的部分，可提成5%；
 *
 * 40万到60万之间时高于40万元的部分，可提成3%；60万到100万之间时，高于60万元的部分，可提成1.5%，
 *
 * 高于100万元时，超过100万元的部分按1%提成，从键盘输入当月利润I，求应发放奖金总数？
 */
public class Profit {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("请输入利润：");
    Double profit = scanner.nextDouble();

    Double reward = Double.valueOf(0);

    Double oneUnit = Double.valueOf(100 * 1000);

    if (profit.compareTo(oneUnit * 10) > 0) {
      reward += (profit - oneUnit * 10) * 0.01;
      profit = 10 * oneUnit;
    }
    if(profit.compareTo(oneUnit * 6) > 0) {
      reward += (profit - oneUnit * 6) * 0.015;
      profit = oneUnit * 6;
    }
    if(profit.compareTo(oneUnit * 4) > 0) {
      reward += (profit - oneUnit * 4) * 0.03;
      profit = oneUnit * 4;
    }
    if(profit.compareTo(oneUnit * 2) > 0) {
      reward += (profit - oneUnit * 2) * 0.05;
      profit = oneUnit * 2;
    }
    if(profit.compareTo(oneUnit*1)>0) {
      reward += (profit - oneUnit) * 0.075;
      profit = oneUnit;
    }
    if(profit.compareTo(oneUnit)<=0) {
      reward += profit * 0.1;
    }

    System.out.println("reward => "+ reward);

  }

}
