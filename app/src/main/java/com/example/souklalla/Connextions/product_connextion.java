package com.example.souklalla.Connextions;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class product_connextion extends AsyncTask {
    String pro_n, Prod_desc, Price, pro_type, Email;
    String ip;

    public product_connextion(String pro_n, String prod_desc, String price, String pro_type, String email, String ip) {
        this.pro_n = pro_n;
        Prod_desc = prod_desc;
        Price = price;
        this.pro_type = pro_type;
        Email = email;
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
            outToServer.writeBytes("addprod\n");
            outToServer.writeBytes(pro_n + "\n");
            outToServer.writeBytes(Prod_desc + "\n");
            outToServer.writeBytes(Price + "\n");
            outToServer.writeBytes(pro_type + "\n");

            outToServer.writeBytes(Email + "\n");
            outToServer.flush();

            Log.d("test", inFromServer.readLine());

            outToServer.close();
            inFromServer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;

    }
}



