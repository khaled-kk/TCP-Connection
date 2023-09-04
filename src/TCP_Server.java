import java.io.*; 
import java.net.*; 
import java.util.ArrayList;

class TCP_Server {

	private static ServerSocket welcomeSocket;

	public static void main(String argv[]) throws Exception 
	{ 
		ArrayList<TCP_Client> clients=new ArrayList<TCP_Client>();
		int num=1;
		System.out.println("Server is ON......");
		String clientSentence=null; 
		String capitalizedSentence=null; 
		
		welcomeSocket = new ServerSocket(56783); 
		

		while(true) {
			
			System.out.println("Waiting for connection.......");
			Socket connectionSocket1 = welcomeSocket.accept(); 
			
			TCP_Client client=new TCP_Client(num,connectionSocket1);

				System.out.println("Server is now connected to the "+client.id + " Client");
				
				BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket1.getInputStream())); 

				DataOutputStream  outToClient = new DataOutputStream(connectionSocket1.getOutputStream());
				
				thread thread=new thread(clientSentence, capitalizedSentence, inFromClient, outToClient);
				
				thread.start();
				
				clients.add(client);
				
				num++;
			}
			
   			
		} 
	
} 