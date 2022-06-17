package business;

import com.fazecast.jSerialComm.SerialPort;

import java.io.PrintWriter;

public class Arduino {
    private SerialPort serialPort = null;
    private PrintWriter out = null;

    //opretter en konstruktør, der tager en string parameter, så man kan sætte portnavnet
    public Arduino(String port) {
        serialPort = SerialPort.getCommPort(port); //kalder klassemetoden getCommPort(String portDescriptor)
        serialPort.openPort(); //åbner porten vha. openPort() metoden som kaldes på serialPort objektet
        serialPort.setComPortParameters(9600, 8, 1,0); //sætter seriel kommunikation parametre, bithastighed, 8 databit, 1 stop, 0 paritetsbit (samme som i Arduino)
        serialPort.setFlowControl(SerialPort.FLOW_CONTROL_DISABLED);  //specificerer flowcontrol for porten, metoden er: setFlowControl(int newFlowControlSettings). FLOW_CONTROL_DISABLED er en indbygget konstant
        //sp.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0); // bloker indtil der kan skrives bytes?

        out = new PrintWriter(serialPort.getOutputStream(), true); //tildeler out værdien fra metodekaldet getOutputStream() på serialport objektet. true parameteren gør at meddelsen bliver sendt med det samme
    }

    public void write(String messege) {
        out.println(messege);
    }

    public void isOpen() {
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
        }else {
            System.out.println("Failed to close port :(");
        }
    }

}