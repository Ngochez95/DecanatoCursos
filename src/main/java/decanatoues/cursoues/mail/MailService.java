package decanatoues.cursoues.mail;

import decanatoues.cursoues.entity.Curso;
import decanatoues.cursoues.entity.Estudiante;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author katiro
 */
public class MailService {

    //propiedades del servicio email
    private final Properties properties = new Properties();
    private String pass;
    //clase Session que tomara las propiedades para enviar el mensaje
    private Session sesion;

    public MailService() {
    }

    //inicia todas propiedades necesarias para enviar el mensaje en la sesion 
    //SMTP es un protocolo para el envio de email puertos: 25,587,465
    private void inicio() {
        //el host que se conectara para el emisor
        properties.put("mail.smtp.host", "smtp.gmail.com");
        //habilitara el uso de TLS 
        properties.put("mail.smtp.starttls.enable", "true");
        //puerto de salida
        properties.put("mail.smtp.port", "587");
        //email emisor 
        properties.put("mail.smtp.mail.sender", "cursosdecanatoues@gmail.com");
        //nombre de usuario preterminado para SMTP
        properties.put("mail.smtp.user", "cursosdecanatoues@gmail.com");
        //autenticar el usuario
        properties.put("mail.smtp.auth", "true");
        System.out.println("inicie el servidor");

        sesion = Session.getDefaultInstance(properties);
    }

    public void enviaMensaje(Estudiante receptor,Curso curso) {
        inicio();
        try {
            //Iniciando la sesion
            MimeMessage mensaje = new MimeMessage(sesion);
            //emisor
            mensaje.setFrom(new InternetAddress((String) properties.getProperty("mail.smtp.mail.sender")));
            //receptor
            mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(receptor.getCorreoEstudiante()));
            //subjunto del mensaje 
            mensaje.setSubject("Confirmación de Inscripción Sistema Cursos Decanato");
            //texto del mensaje
            mensaje.setText("Feliz día "+receptor.getNombreEstudiante()+" "+receptor.getApellidoEstudiante()+" reciba un cordial saludo por parte del equipo de trabajo de Sistema Cursos Decanato.\n"
                    + "\n"
                    + "Su inscripción al curso "+ curso.getNombreCurso() +" se ha realizado exitosamente, agradecemos su confianza, esperamos que el curso sea de provecho\n"
                    + "para su formación y pueda disfrutarlo.\n"
                    + "\n"
                    + "Detalles:\n"
                    + "El curso inicia el día "+(curso.getFechaInicio().getDay()+21)+"/"+(curso.getFechaInicio().getMonth()+1)+"/"+(curso.getFechaInicio().getYear()+1900)+" y finaliza el día "+(curso.getFechaFin().getDay()+21)+"/"+(curso.getFechaFin().getMonth()+1)+"/"+(curso.getFechaFin().getYear()+1900)+".\n"
                    + "Su identificador de estudiante es "+receptor.getCarnet()+".\n"
                    + "\n"
                    + "Decanato UES FMOcc\n"
                    + "Final Avenida Fray Felipe de Jesús Moraga Sur, Santa Ana, El Salvador.");
            //autenticar el usuario
            try (
                    //mecanismo de transporte
                    Transport transporte = sesion.getTransport("smtp")) {
                //autenticar el usuario
                transporte.connect((String) properties.get("mail.smtp.user"), "cursos-2019");
                System.out.println("correo enviado");
                //envio del mensaje
                transporte.sendMessage(mensaje, mensaje.getAllRecipients());
                //apagar el mecanismo de transporte
            }
        } catch (MessagingException e) {
            System.out.println("NO se pudo enviar el correo");
        }
    }

}
