package lxz.tutorial.java.designpattern;

import java.util.HashMap;

/**
 * 解释器模式（Interpreter Pattern）提供了评估语言的语法或表达式的方式，它属于行为型模式。这种模式实现了一个表达式接口，该接口解释一个特定的上下文。这种模式被用在 SQL
 * 解析、符号处理引擎等。
 */
public class InterpreterPattern {

  public static void main(String[] args) {
    HashMap<String, String> chineseToEnglishContext = new HashMap<>();
    chineseToEnglishContext.put("你好", "Hello");
    Interpreter chineseToEnglishTranslator = new ChineseToEnglishTranslator(chineseToEnglishContext);

    HashMap<String, String> englishToChineseContext = new HashMap<>();
    englishToChineseContext.put("Hello", "你好");
    Interpreter englishToChineseTranslator = new EnglishToChineseTranslator(englishToChineseContext);

    System.out.println(chineseToEnglishTranslator.interpret("你好"));
    System.out.println(englishToChineseTranslator.interpret("Hello"));

  }

  interface Interpreter {

    public String interpret(String input);
  }

  static class ChineseToEnglishTranslator implements Interpreter {

    HashMap<String, String> context;

    public ChineseToEnglishTranslator(HashMap<String, String> context) {
      this.context = context;
    }

    @Override
    public String interpret(String input) {
      return context.get(input);
    }
  }

  static class EnglishToChineseTranslator implements Interpreter {

    HashMap<String, String> context;

    public EnglishToChineseTranslator(HashMap<String, String> context) {
      this.context = context;
    }

    @Override
    public String interpret(String input) {
      return context.get(input);
    }
  }

}
