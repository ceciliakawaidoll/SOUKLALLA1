package com.example.souklalla.Connextions;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.Socket;
import java.net.URL;

public class Signup_connextion extends AsyncTask {
    String fullname ,Email ,Phone ,Pass1,Wilaya, Type;
    String ip;

    public Signup_connextion(String fullname, String email, String phone, String pass1,String wilaya,String IP, String type) {
        this.fullname = fullname;
        Email = email;
        Phone = phone;
        Pass1 = pass1;
        Wilaya = wilaya;
        ip = IP;
        Type = type;
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        String sentence;
        String msg;

        Socket clientSocket = null;
        try {

            clientSocket = new Socket(ip, 6789);
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

            outToServer.writeBytes("check\n");
            outToServer.writeBytes(Email+"\n");

            outToServer.flush();

            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            msg = inFromServer.readLine();

            outToServer.close();
            inFromServer.close();
            if(Boolean.parseBoolean(msg)){
                clientSocket = new Socket(ip, 6789);
                outToServer = new DataOutputStream(clientSocket.getOutputStream());
                inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                outToServer.writeBytes("add\n");
                outToServer.writeBytes(fullname+"\n");
                outToServer.writeBytes(Email+"\n");
                outToServer.writeBytes(Phone+"\n");
                outToServer.writeBytes(Wilaya+"\n");
                outToServer.writeBytes(Pass1+"\n");
                outToServer.writeBytes(Type+"\n");
                outToServer.flush();
                Log.d("test",inFromServer.readLine());
            }else{

            }

            outToServer.close();
            inFromServer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;

    }
}
