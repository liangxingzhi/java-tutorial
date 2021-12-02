package lxz.tutorial.java.swing;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TimerClick {

  private JFrame frame;
  private JTextArea textArea;
  private JComboBox<SelectItem> comboBox;
  private JScrollPane scroll;
  private Timer timer = null;
  private AtomicInteger counter = new AtomicInteger();

  public void click() {
    try {
      frame.setVisible(true);
      Robot robot = new Robot();
      // MouseInfo.getPointerInfo().getLocation()
      // + new Random().nextInt() % frame.getHeight()
      int nextX = frame.getX() + 100 + new Random().nextInt(17);
      int nextY = frame.getY() + 100 + new Random().nextInt(17);
      while (MouseInfo.getPointerInfo().getLocation().getX() != nextX
          || MouseInfo.getPointerInfo().getLocation().getY() != nextY) {
        robot.mouseMove(nextX, nextY);
        frame.setVisible(true);
      }
      robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
      robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
      String currentText = textArea.getText();
      if (currentText == null || currentText.length() == 0) {
        currentText = "";
      } else {
        currentText = "\n" + "\n" + currentText;
      }
      ZonedDateTime ldt = ZonedDateTime.now();

      ZonedDateTime frt = ldt.withZoneSameInstant(ZoneId.of("Europe/Paris"));
      ZonedDateTime cnt = ldt.withZoneSameInstant(ZoneId.of("Asia/Shanghai"));
      ZonedDateTime ust = ldt.withZoneSameInstant(ZoneId.of("America/New_York"));
      ZonedDateTime ukt = ldt.withZoneSameInstant(ZoneId.of("Europe/London"));
      ZonedDateTime rut = ldt.withZoneSameInstant(ZoneId.of("Europe/Moscow"));


//			OffsetDateTime rust = odt.withOffsetSameInstant(ZoneOffset.of("+03:00"));
      DateTimeFormatter formatter = DateTimeFormatter.ISO_ZONED_DATE_TIME;
      textArea.setText("# " + String.format("%3s", String.valueOf(counter.incrementAndGet())).replace(' ', '0')
          + "\n" + String.format("%-3s", "CN") + " : " + formatter.format(cnt) + "\n"
          + String.format("%-3s", "UK") + " : " + formatter.format(ukt) + "\n"
          + String.format("%-3s", "US") + " : " + formatter.format(ust) + "\n"
          + String.format("%-3s", "FR") + " : " + formatter.format(frt) + "\n"
          + String.format("%-3s", "RUS") + " : " + formatter.format(rut) + "\n"
          + currentText);
      textArea.setFont(new Font("Consolas", Font.PLAIN, 16));
      scroll.setAutoscrolls(false);
      frame.setVisible(true);
    } catch (AWTException e) {
      e.printStackTrace();
    }

  }

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          TimerClick window = new TimerClick();

          window.frame.setVisible(true);

        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public TimerClick() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    frame.setBounds(screenSize.width - 520, screenSize.height - 410, 520, 360);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("Click Timer");
    textArea = new JTextArea(10, 20); // Rows and cols to be displayed
    scroll = new JScrollPane(textArea);

    comboBox = new JComboBox<>(new SelectItem[] { new SelectItem(1), new SelectItem(2), new SelectItem(4) });
    TimerClick timerClick = this;
    comboBox.addItemListener(new ItemListener() {
      @Override
      public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
          SelectItem selected = (SelectItem) e.getItem();
          if (timer != null) {
            timer.cancel();
          }
          timer = new Timer();
          timer.schedule(new CustomTimerTask(timerClick), 1000, 1000 * 60 * selected.getMinutes());
        }
      }
    });
    comboBox.setSelectedIndex(1);
    comboBox.setFont(new Font("Calibri", Font.PLAIN, 24));
    frame.getContentPane().add(comboBox, BorderLayout.NORTH);
    frame.getContentPane().add(scroll, BorderLayout.CENTER);
  }

  static class SelectItem {

    private int minutes;

    public int getMinutes() {
      return minutes;
    }

    public void setMinutes(int minutes) {
      this.minutes = minutes;
    }

    public SelectItem(int minutes) {
      this.minutes = minutes;
    }

    @Override
    public String toString() {
      return "Click Every " + minutes + " Minutes";
    }
  }

  static class CustomTimerTask extends TimerTask {

    TimerClick timerClick;

    CustomTimerTask(TimerClick timerClick) {
      this.timerClick = timerClick;
    }

    @Override
    public void run() {
      timerClick.click();

    }
  }

}
