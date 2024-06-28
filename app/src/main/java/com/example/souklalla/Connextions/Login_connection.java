package com.example.souklalla.Connextions;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Login_connection extends AsyncTask {
    public static interface Result {
        void getResult(String email);
    }
    Result R;
    public void set_result(Result r){
        R = r;
    }
    String Name, Pass;
    String ip;

    public Login_connection(String name, String pass, String ip) {
        Name = name;
        Pass = pass;
        this.ip = ip;
    }

    @Override
    protected Object doInBackground(Object[] objects) {


        String msg;

        Socket clientSocket = null;
        try {


            clientSocket = new Socket(ip, 6789);
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());


            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            outToServer.writeBytes("login\n");
            outToServer.writeBytes(Name + "\n");
            outToServer.writeBytes(Pass + "\n");

            outToServer.flush();

            msg = inFromServer.readLine();

            outToServer.close();
            inFromServer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return msg;
    }
    protected void onPostExecute(Object results)
    {
        if(results != null)
        {
            R.getResult(String.valueOf(results));
        }

    }
}
