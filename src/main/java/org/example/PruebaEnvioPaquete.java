package org.example;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.Random;

/***********************************************************************************************************************************************************
 *   APLICACIÓN: PruebaEnvioPaquete                                                                                                                         *
 ************************************************************************************************************************************************************
 *   PROGRAMACIÓN DE SERVICIOS Y PROCESOS 2DAM  -  Eclipse IDE for Java Developers v2021-09 (4.21.0)                                                        *
 ************************************************************************************************************************************************************
 *   @author S.García                                                                                                                                      *
 *   @version 1.0  -  Versión inicial de la aplicación.                                                                                                     *
 *            1.1  -  Queda en espera infinita para poder "pinearle" una consola.                                                                           *
 *   @since 08MARZO2023                                                                                                                                   *
 ************************************************************************************************************************************************************
 *   COMENTARIOS:                                                                                                                                           *
 *         -  Clase para probar constructores y métodos de DatagramPacket y DatagramSocket.                                                                 *
 ************************************************************************************************************************************************************/

public class PruebaEnvioPaquete {

    public static void main(String[] args) throws UnknownHostException, SocketException, IOException {

        byte[] l_Mensaje;
        int i=1;// Bytes del mensaje a enviar.
        InetAddress l_DireccionDestino = InetAddress.getByName("localhost");                    // Dirección IP del destino.
        int l_PuertoDestino = 5_555;                                                            // Puerto destino (servicios no estándard).
        DatagramPacket l_Paquete; /*= new DatagramPacket(l_Mensaje, l_Mensaje.length,
                l_DireccionDestino, l_PuertoDestino); */    // Crear el paquete a enviar.
        DatagramSocket l_Zocalo = new DatagramSocket();                                         // Crear un zócalo temporal con el que realizar el envío.

                                                                 // Enviar el mensaje.

        while (true) {                                                                            // Pausa infinita para poder "pinear" una consola a esta aplicación
            try {
                long wait=(long) (2000);
                Thread.sleep(wait);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Proceso que envía...");
            System.out.println((byte) i);
            l_Mensaje=new byte[(byte) i];
             l_Paquete = new DatagramPacket(l_Mensaje, l_Mensaje.length,
                    l_DireccionDestino, l_PuertoDestino);
            l_Zocalo.send(l_Paquete);
            i++;
        }     // main()
    }
}     // PruebaEnvioPaquete
