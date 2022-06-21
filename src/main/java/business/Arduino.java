package business;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;
import com.fazecast.jSerialComm.SerialPortTimeoutException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Arduino {
    private SerialPort serialPort = null;
    private BufferedReader portIn;

    //opretter en konstruktør, der tager en string parameter, så man kan sætte portnavnet
    public Arduino(String port) {
        try {
            serialPort = SerialPort.getCommPort(port); //kalder klassemetoden getCommPort(String portDescriptor)
            serialPort.openPort(); //åbner porten vha. openPort() metoden som kaldes på serialPort objektet
            /*serialPort.addDataListener(new SerialPortDataListener() {
                @Override
                public int getListeningEvents() {
                    return 1;
                }

                @Override
                public void serialEvent(SerialPortEvent serialPortEvent) {
                    if (serialPortEvent.getEventType() != 1){
                        observer.notify(serialPortEvent.getReceivedData());
                    }

                }
            })
            */
            System.out.println("port is open");
            serialPort.setComPortParameters(38400, Byte.SIZE, SerialPort.ONE_STOP_BIT, SerialPort.NO_PARITY); //sætter seriel kommunikation parametre, bithastighed, 8 databit, 1 stop, 0 paritetsbit (samme som i Arduino)
            //serialPort.setFlowControl(SerialPort.FLOW_CONTROL_DISABLED);  //specificerer flowcontrol for porten, metoden er: setFlowControl(int newFlowControlSettings). FLOW_CONTROL_DISABLED er en indbygget konstant
            portIn = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
        } catch (Exception e) {
            System.out.println("SerialPortException: " + e);
        }
    }
    //this.portIn = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));

    // Intern metode for os, som vi kan bruge til at sende data direkte til arduino.
    public String receiveData() {
         //åbner porten vha. openPort() metoden som kaldes på serialPort objektet

        String svar = null; //lokal variabel

        // Vi laver en while-loop for at sørge for vi får fat i alle beskederne.
        while (serialPort.bytesAvailable() > 0) { // formålet er at den læser alle beskeder på en gang
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            // Try, catch. Vi har defineret en custom timeout på 5sek, hvis det tager længere tid, så smider vi en error ud.
            try {
                svar = portIn.readLine();
                //System.out.println("[HARDWARE] " + svar);

            } catch (SerialPortTimeoutException e) { // Hvis det tager længere end 100ms at læse en linje.
                System.out.println("Kunne ikke aflæse data fra Ardunio til tiden. Tjek kommunikationskablet og prøv igen.");

                serialPort.closePort();
                System.exit(-1);
                // For alle de andre fejl.
            } catch (IOException e) {
                System.out.println("Fejlkode:" + e);
                System.out.println("Kunne ikke aflæse data fra Ardunio. Tjek kommunikationskablet og prøv igen.");
                serialPort.closePort();
                System.exit(-1);
                //} catch (IOException e) {
                //    e.printStackTrace();
                //}
            }
            // Vi returner den seneste string.

        }return svar;
    }


    public void isOpen(){
        if (serialPort.openPort()) {
            System.out.println("Port is open :)");
        } else {
            System.out.println("Failed to open port :(");
            return;
        }
    }

    public void isClosed() {
        if (serialPort.closePort()) {
            System.out.println("Port is closed :)");
        } else {
            System.out.println("Failed to close port :(");
        }
    }

}

