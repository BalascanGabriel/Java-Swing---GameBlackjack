import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
public class Mail {
    public static void sendMail(final String to, final String name,int code)
    {

        String host="smtp.mail.yahoo.com";
        final String user="balascangabriel@yahoo.com";//change accordingly
        final String password="rubphkhfcrlstfmo";//change accordingly


       // String to="gabrieldanutgd5@gmail.com";//change accordingly

        //Get the session object
        Properties props = new Properties();
        props.put("mail.smtp.host",host);
        props.put("mail.smtp.port","587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");


        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user,password);
                    }
                });

        //Compose the message
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            message.setSubject("Verify access to GabeCasino ");
            message.setText("Hello gambler, you automatically received this email for user : " + name + ". In order to finish " +
                    "the registration process you must complete in the app the code bellow : " + code + "\n\n\t Winner winner" +
                    ", chicken dinner :)");

            //send the message
            Transport.send(message);

            System.out.println("message sent successfully...");

        } catch (MessagingException e) {e.printStackTrace();}

}
}

