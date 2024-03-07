import javax.mail.*;
import java.util.Properties;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
// import javax.naming.spi.StateFactory;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;



public class newMailBot {
    
    // public void message(){
    
    //     filereader and filewriter
    // }
    
    // public static void reciverEmail(){
        
    // }

    public static void Mail() {

        String to = maliGui.reciver;
        String from = "creationofali.bot@gmail.com";
        String host = "smtp.gmail.com";

        System.out.println("preparing to send mail to " + to);

        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("creationofali.bot@gmail.com", "ljzehqqxnzuwfuqm\n");
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(maliGui.subject);
            message.setText(maliGui.msg);

            Transport.send(message);
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
        System.out.println("email sent ");
    }


}
