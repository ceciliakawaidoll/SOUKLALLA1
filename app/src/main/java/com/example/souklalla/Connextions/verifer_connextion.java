package com.example.souklalla.Connextions;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class verifer_connextion extends AsyncTask {
    public static interface Result {
        void getResult(String email);
    }
    verifer_connextion.Result R;
    public void set_result(verifer_connextion.Result r){
        R = r;
    }
    String e_mail;
    String ip;

    public verifer_connextion(String e_mail, String ip) {
        this.e_mail = e_mail;
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
            outToServer.writeBytes("verifer\n");
            outToServer.writeBytes(e_mail + "\n");

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
