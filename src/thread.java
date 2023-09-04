import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;

public class thread extends Thread{
	String clientSentence;
	String capitalizedSentence;
	BufferedReader inFromClient;
	DataOutputStream  outToClient;
	
	public thread(	String clientSentence,String capitalizedSentence,BufferedReader inFromClient,DataOutputStream  outToClient){
		this.clientSentence=clientSentence;
		this.capitalizedSentence=capitalizedSentence;
		this.inFromClient=inFromClient;
		this.outToClient=outToClient;
	}
	
	public void run(){
		while(true){
			try {
				clientSentence = inFromClient.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			} 
			
			capitalizedSentence = clientSentence.toUpperCase();
			
			System.out.println("Sentence Capitalized : "+ capitalizedSentence);
			try {
				outToClient.writeBytes(capitalizedSentence+ '\n');
			} catch (IOException e) {
				e.printStackTrace();
			} 
			
			if(clientSentence.equalsIgnoreCase("Close Socket"))
			{
				System.out.println("Connection Socket between the server and client is closed");
				System.out.println("===============================================");
				System.out.println("Server is Still Running......");
				break;
			}
		}
	}
}
