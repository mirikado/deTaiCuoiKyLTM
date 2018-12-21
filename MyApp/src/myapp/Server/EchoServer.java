/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStreamReader;

/**
 *
 * @author DVC_win10
 */
public class EchoServer {
  public static void main(String[] args) throws IOException {
//    if (args.length < 1) {
//      System.err.println("Usage: java EchoServer <port number>");
//      System.exit(1);
//    }
    System.out.println("Server started. Listening on Port 8005" );
    int portNumber = 8005;
      try (ServerSocket serverSocket = new ServerSocket(portNumber);
        Socket clientSocket = serverSocket.accept();
	PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
	BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));) {
	  System.out.println("Client connected on port " + portNumber +". Servicing requests.");
	  String inputLine;
	  while ((inputLine = in.readLine()) != null) {
            System.out.println("Received message: " + inputLine + " from " + clientSocket.toString());
	    out.println(inputLine);
	  }
	} catch (IOException e) {
	    System.out.println("Exception caught when trying to listen on port "
		    + portNumber + " or listening for a connection");
       	}
    }
}
