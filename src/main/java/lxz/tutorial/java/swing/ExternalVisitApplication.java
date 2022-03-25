package lxz.tutorial.java.swing;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.plaf.FontUIResource;
import org.springframework.util.StringUtils;

public class ExternalVisitApplication {

  /**
   * Create the GUI and show it.  For thread safety, this method should be invoked from the
   * event-dispatching thread.
   */
  private static void createAndShowGUI() {
    //Create and populate the panel.
    JPanel p = new JPanel(new SpringLayout());
    JTextField to = createTextField("To: ", "tony.dai@abc.com", p);
    JTextField cc = createTextField("Cc: ", "reception-dl@abc.com", p);
    JTextField interviewee = createTextField("Interviewee: ", "", p);
    JTextField city = createTextField("City: ", "Dalian", p);
    JTextField phone = createTextField("Phone: ", "", p);
    JTextField visitTime = createTextField("Visit Time: ", "", p);

    JButton sendButton = new JButton("Send");
    sendButton.setSize(100, 30);
    sendButton.setFont(new FontUIResource("Calibri", 0, 25));
    JButton clearButton = new JButton("Clear");
    clearButton.setSize(100, 30);
    clearButton.setFont(new FontUIResource("Calibri", 0, 25));

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    //Lay out the panel.
    SpringUtilities.makeCompactGrid(p,
        6, 2, //rows, cols
        6, 15,        //initX, initY
        15, 15);       //xPad, yPad

    //Create and set up the window.
    JFrame frame = new JFrame("External Visit Application");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //Set up the content pane.
    p.setOpaque(true);  //content panes must be opaque
    JPanel framePanel = new JPanel();

    frame.getContentPane().add(p, BorderLayout.CENTER);
    frame.setLocation(screenSize.width - 1000, screenSize.height - 600);
    JPanel buttonPane = new JPanel();

    buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
    buttonPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
    buttonPane.add(Box.createHorizontalGlue());
    buttonPane.add(clearButton);
    buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));
    buttonPane.add(sendButton);

    frame.getContentPane().add(buttonPane, BorderLayout.PAGE_END);
    JLabel resultLabel = new JLabel("  ", JLabel.CENTER);

    resultLabel.setFont(new FontUIResource("Calibri", 0, 25));
    frame.getContentPane().add(resultLabel, BorderLayout.PAGE_START);

    //Display the window.
    frame.pack();
    frame.setVisible(true);
    clearButton.addActionListener(l -> {
      interviewee.setText("");
      phone.setText("");
      visitTime.setText("");
    });
    sendButton.addActionListener(l -> {
      sendButton.setEnabled(false);
      String toStr = to.getText().trim();
      String ccStr = cc.getText().trim();
      String intervieweeStr = interviewee.getText().trim();
      String cityStr = city.getText().trim();
      String phoneStr = phone.getText().trim();
      String visitTimeStr = visitTime.getText().trim();
      if (StringUtils.isEmpty(toStr)) {
        resultLabel.setForeground(Color.red);
        resultLabel.setText("To is Empty");
        sendButton.setEnabled(true);
        return;
      }
      if (StringUtils.isEmpty(ccStr)) {
        resultLabel.setForeground(Color.red);
        resultLabel.setText("Cc is Empty");
        sendButton.setEnabled(true);
        return;
      }
      if (StringUtils.isEmpty(intervieweeStr)) {
        resultLabel.setForeground(Color.red);
        resultLabel.setText("Interviewee is Empty");
        sendButton.setEnabled(true);
        return;
      }
      if (StringUtils.isEmpty(cityStr)) {
        resultLabel.setForeground(Color.red);
        resultLabel.setText("City is Empty");
        sendButton.setEnabled(true);
        return;
      }
      if (StringUtils.isEmpty(phoneStr)) {
        resultLabel.setForeground(Color.red);
        resultLabel.setText("Phone is Empty");
        sendButton.setEnabled(true);
        return;
      }
      if (StringUtils.isEmpty(visitTimeStr)) {
        resultLabel.setForeground(Color.red);
        resultLabel.setText("Visit Time is Empty");
        sendButton.setEnabled(true);
        return;
      }

      resultLabel.setForeground(new Color(0, 128, 0));
      resultLabel.setText("Wait a minute, sending...");
      new Thread(new Runnable() {
        @Override
        public void run() {
          try {
            EmailUtil.send(toStr, ccStr, intervieweeStr, cityStr, phoneStr, visitTimeStr);
          } catch (Exception e) {
            resultLabel.setForeground(Color.red);
            resultLabel.setText("Error Occur: " + e.getMessage());
            sendButton.setEnabled(true);
          }
          resultLabel.setText("Email Sent Successfully");
          sendButton.setEnabled(true);
        }
      }).start();
    });
  }

  private static JTextField createTextField(String label, String defaultValue, JPanel p) {
    JLabel l = new JLabel(label, JLabel.TRAILING);
//      l.setSize(100, 30);
    l.setFont(new FontUIResource("Calibri", 0, 25));
    p.add(l);
    JTextField textField = new JTextField(30);
//      textField.setSize(200, 30);
    textField.setFont(new FontUIResource("Calibri", 0, 30));
    textField.setText(defaultValue);
    l.setLabelFor(textField);
    p.add(textField);
    return textField;
  }

  public static void main(String[] args) {
    //Schedule a job for the event-dispatching thread:
    //creating and showing this application's GUI.
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        createAndShowGUI();
      }
    });
  }
}