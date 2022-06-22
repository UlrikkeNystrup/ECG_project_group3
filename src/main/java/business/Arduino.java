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
    private BufferedReader bufferedReader;

    //opretter en konstruktør, der tager en string parameter, så man kan sætte portnavnet
    public Arduino(String port) {
        try {
            serialPort = SerialPort.getCommPort(port); //kalder klassemetoden getCommPort(String portDescriptor)
            serialPort.openPort(); //åbner porten vha. openPort() metoden som kaldes på serialPort objektet
            /*serialPort.addDataListener(new SerialPortDataListener() { //løsning på busywait problem
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
            bufferedReader = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
        } catch (Exception e) {
            System.out.println("SerialPortException: " + e);
        }
    }

    // Intern metode for os, som vi kan bruge til at sende data direkte til arduino.
    public String receiveData() {
        String svar = null; //lokal variabel
        // Vi laver en while-loop for at sørger for vi får fat i alle beskederne. (ville være bedre med et obseerver pattern da dette, er "busy wait")
        try {
            while (serialPort.bytesAvailable() < 1) {

                try {Thread.sleep(3);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (serialPort.bytesAvailable() > 4 ) {
                 svar = bufferedReader.readLine();
                //System.out.println("[HARDWARE] " + svar);
            }
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
        }
        return svar;// Vi returner den seneste string.
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

