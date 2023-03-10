package org.example;

import java.io.IOException;
import java.net.*;

/***********************************************************************************************************************************************************
 *   APLICACIÓN: PruebaRecepciónPaquete                                                                                                                     *
 ************************************************************************************************************************************************************
 *   PROGRAMACIÓN DE SERVICIOS Y PROCESOS 2DAM  -  Eclipse IDE for Java Developers v2021-09 (4.21.0)                                                        *
 ************************************************************************************************************************************************************
 *   @author S.García                                                                                                                                      *
 *   @version 1.0  -  Versión inicial de la aplicación.                                                                                                     *
 *            1.1  -  Imprime por pantalla el mensaje recibido.                                                                                             *
 *   @since 08MARZO2023                                                                                                                                   *
 ************************************************************************************************************************************************************
 *   COMENTARIOS:                                                                                                                                           *
 *         -  Clase para probar constructores y métodos de DatagramPacket y DatagramSocket.                                                                 *
 ************************************************************************************************************************************************************/

public class PruebaRecepcionPaquete {

    static int TIMEOUT=5000;
    public static void main(String[] args) throws UnknownHostException, SocketException, IOException {
        boolean error = false;
        boolean activo=true;
        int l_PuertoEscucha = 5555;                                                     // Puerto a escuchar.
        byte[] l_Mensaje = new byte[1024];                                              // Array para recepción de mensajes de hasta 1KB.
        DatagramPacket l_Paquete = new DatagramPacket(l_Mensaje, l_Mensaje.length);     // Crear un paquete en el que recibir los datos.
        DatagramSocket l_Zocalo = new DatagramSocket(l_PuertoEscucha);                  // Crear un zócalo que escuche el puerto.
        System.out.println("Proceso que recibe...");
        l_Zocalo.setSoTimeout(TIMEOUT);
        while (activo) {


            try {

                l_Zocalo.receive(l_Paquete); // Recibir un paquete.
                String l_MensajeCadena = new String(l_Mensaje);
                System.out.println(l_MensajeCadena.substring(0, l_MensajeCadena.indexOf(0)));
                error=false;
            } catch (SocketTimeoutException e) {
                System.out.println("ERROR: TIMEOUT");
                error=true;
            }
        }
        if (!error)
        System.out.println(new String(l_Mensaje));                                      // Imprime la totalidad del buffer de recepción.

        String l_MensajeCadena = new String(l_Mensaje);

        System.out.println(l_MensajeCadena.substring(0, l_MensajeCadena.indexOf(0)));    // Imprime solo la parte del mensaje del buffer de recepción.

    }     // main()

}     // PruebaRecepcionPaquete
