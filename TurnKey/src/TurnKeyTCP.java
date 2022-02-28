import java.io.*;
import java.net.Socket;

public class TurnKeyTCP extends Thread {
    Socket socket = null;
    BufferedReader reader = null;
    PrintWriter writer = null;
    String returnString = "";

    public void run(int i){
        try{
            socket = new Socket("vault" + i + ".momandpopsflags.ca", 5555);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
            reader.readLine();

            writer.println("INITIALIZE CONNECTION");
            reader.readLine();

            writer.println("SEND FLAG");

            writer.println(reader.readLine().substring(44));
            returnString += reader.readLine() + "\n";
            returnString += reader.readLine() + "\n";
            returnString += reader.readLine() + "\n";
            returnString += reader.readLine() + "\n";
            returnString += reader.readLine() + "\n";
            returnString += reader.readLine() + "\n";
            returnString += reader.readLine() + "\n";
            returnString += reader.readLine() + "\n";
            returnString += reader.readLine() + "\n";
        }catch(IOException e){}
    }

    public void close() {
        try {
            System.out.println(returnString);
            reader.close();
            writer.close();
            socket.close();
        } catch (IOException e){

        }
    }
}
