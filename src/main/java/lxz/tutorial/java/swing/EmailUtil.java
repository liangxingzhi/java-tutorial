package lxz.tutorial.java.swing;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.util.StringUtils;

/**
 * @author Guilin Liang
 * @since 1.0.0
 */
public class EmailUtil {


  public static void main(String[] args) {
    send("guilin.liang@abc.com", "guilin.liang@abc.com","Zhangsan", "Dalian", "18612345678", "2022-03-24 8:00");
  }

  public static void send(String to, String cc, String name, String city, String phone, String datetime) {
    // Recipient's email ID needs to be mentioned.
//    String to = "guilin.liang@abc.com";

    // Sender's email ID needs to be mentioned
    String from = "guilin.liang@abc.com";
    final String username = "Guilin";//change accordingly
    final String password = "******";//change accordingly

    // Assuming you are sending email through relay.jangosmtp.net
    String host = "smtp.internal.abc.com";

    Properties props = new Properties();
//    props.put("mail.smtp.auth", "true");
//    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", host);
    props.put("mail.smtp.port", "25");

    // Get the Session object.
    Session session = Session.getInstance(props);
//    Session session = Session.getInstance(props,
//        new javax.mail.Authenticator() {
//          protected PasswordAuthentication getPasswordAuthentication() {
//            return new PasswordAuthentication(username, password);
//          }
//        });

    try {
      // Create a default MimeMessage object.
      Message message = new MimeMessage(session);

      // Set From: header field of the header.
      message.setFrom(new InternetAddress(from));

      // Set To: header field of the header.
      message.setRecipients(Message.RecipientType.TO,
          InternetAddress.parse(to));
      // Set Cc: header field of the header.
      message.setRecipients(RecipientType.CC,
          InternetAddress.parse(cc));

      // Set Subject: header field
      message.setSubject("External Visit Application");

      // Send the actual HTML message, as big as you like

      String content = "<html><head><style type='text/css'>p { text-align: center; } "
          + "body {font-family: Calibri}</style></head><body>Hi Tony,<br><br>"
          + "Please approve the visiting access for below interviewee, Thanks.<br><br>"
          + "<table width='755' border='1' style='border-collapse: collapse'><tbody>"
          + "<tr><td colspan='4' width='387'><p><strong>Visitor Information</strong></p></td>"
          + "<td colspan='4' width='369'><p><strong>Ericsson Host Information</strong></p></td></tr>"
          + "<tr><td width='58'><p><strong>Name</strong></p></td>"
          + "<td width='84'><p><strong>City</strong></p></td>"
          + "<td width='115'><p><strong>Phone Number</strong></p></td>"
          + "<td width='130'><p><strong>Date &amp; Time</strong></p></td>"
          + "<td width='85'><p><strong>Name</strong></p></td><td width='77'>"
          + "<p><strong>EID</strong></p></td><td width='81'><p><strong>Manager</strong></p></td>"
          + "<td width='125'><p><strong>Visit Purpose</strong></p></td></tr><tr>"
          + "<td width='58'><p>" + name + "</p></td>"
          + "<td width='84'><p>" + (StringUtils.isEmpty(city) ? "Dalian" : city) + "</p></td>"
          + "<td width='115'><p>" + phone + "</p></td>"
          + "<td width='130'><p>" + datetime + "</p></td>"
          + "<td width='85'><p>Guilin</p></td><td width='77'><p>EZLIAGU</p></td><td width='81'>"
          + "<p>Tony Dai</p></td><td width='125'><p>interview</p></td></tr></tbody></table>"
          + "<br>Best Regards,<br>Guilin</body></html>";
      message.setContent(content, "text/html");
      // Send message
      Transport.send(message);

      System.out.println("Sent message successfully....");

    } catch (MessagingException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }
}
