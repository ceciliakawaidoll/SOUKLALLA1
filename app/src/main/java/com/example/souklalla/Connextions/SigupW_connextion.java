package com.example.souklalla.Connextions;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class SigupW_connextion extends AsyncTask {
    String fullname ,Email ,Phone ,Pass1,Wilaya;
    String ip;

    public SigupW_connextion (String fullname, String email, String phone, String pass1,String wilaya,String IP) {
        this.fullname = fullname;
        Email = email;
        Phone = phone;
        Pass1 = pass1;
        Wilaya = wilaya;
        ip = IP;
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

            if(Boolean.parseBoolean(msg)){

                outToServer.writeBytes("add\n");
                outToServer.writeBytes(fullname+"\n");
                outToServer.writeBytes(Email+"\n");
                outToServer.writeBytes(Phone+"\n");
                outToServer.writeBytes(Wilaya+"\n");
                outToServer.writeBytes(Pass1+"\n");
                outToServer.flush();
                Log.d("test",inFromServer.readLine());
            }else{

            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return null;
    }
}
