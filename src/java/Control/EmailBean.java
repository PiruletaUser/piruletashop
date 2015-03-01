/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author JR
 */
public class EmailBean {

    final String username = "piruletashop@gmail.com";
    final String password = "piruleta123";

    public void EnviarEmail(String Email, String Nome) {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("PiruletaShop@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(Email));
            message.setSubject("Registro no PiruletaShop");
            message.setText("Caro " + Nome + ","
                    + "\nEspero que esteja satisfeito com nossa loja, porque foi mais dificil que conseguir cagar em um prato ao lado da estrada pela janela de um carro em movimento."
                    + "\nSe nao estiver satisfeito, faca o favor de retirar-se daqui sem reclamacoes, pois podemos invocar o Bicho Piruleta para fazer-lhe uma visita."
                    + "\nLembre-se, temos seu endereco."
                    + "\nBoas compras!");

            Transport.send(message);

            System.out.println("Enviado");

        } catch (MessagingException e) {
            System.out.print(e.getMessage());
        }

    }
}
