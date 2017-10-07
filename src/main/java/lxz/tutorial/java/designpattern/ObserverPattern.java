package lxz.tutorial.java.designpattern;

import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {

  public static void main(String[] args) {
    WeatherDataSubject subject = new WeatherDataSubject();
    subject.setTemperature(20);
    DisplayTemperatureObserver displayTemperatureObserver = new DisplayTemperatureObserver(subject);
    subject.setTemperature(30);
    DisplayTemperatureObserver displayTemperatureObserver2 = new DisplayTemperatureObserver(
        subject);
    subject.setTemperature(40);
  }

  interface Observer {

    public void update();
  }

  static class WeatherDataSubject {

    int temperature;
    List<Observer> observerList = new ArrayList<>();

    public int getTemperature() {
      return temperature;
    }

    public void setTemperature(int temperature) {
      this.temperature = temperature;
      notifyObservers();
    }

    public void registerObservers(Observer o) {
      observerList.add(o);
    }

    public void removeObserver(Observer o) {
      observerList.remove(o);
    }

    public void notifyObservers() {
      for (Observer observer : observerList) {
        observer.update();
      }
    }
  }

  static class DisplayTemperatureObserver implements Observer {

    WeatherDataSubject subject;

    public DisplayTemperatureObserver(WeatherDataSubject subject) {
      subject.registerObservers(this);
      this.subject = subject;
    }

    @Override
    public void update() {
      System.out.println("Current temperature is " + subject.getTemperature());
    }
  }

}
