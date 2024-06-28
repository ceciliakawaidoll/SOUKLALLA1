package com.example.souklalla.Connextions;

import android.os.AsyncTask;

import com.example.souklalla.structure.Product_elem;
import com.example.souklalla.women.WOMENLOGIN;


import java.io.DataOutputStream;
import java.io.IOException;

import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.List;



public class get_products extends AsyncTask {
    public static interface Result_prod {
        void getproducts(List<Product_elem> products);
    }
    Result_prod R;
    public void set_result(Result_prod r){
        R = r;
    }

    String ip;

    public get_products( String ip) {

        this.ip = ip;
    }

    @Override
    protected Object doInBackground(Object[] objects) {


        Product_elem msg;

        Socket clientSocket = null;
        try {


            clientSocket = new Socket(ip, 6789);
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());



            outToServer.writeBytes("getprodW\n");
            outToServer.writeBytes(WOMENLOGIN.Email+"\n");
            outToServer.flush();
            ObjectInputStream  inFromServer = new ObjectInputStream (clientSocket.getInputStream());

            msg =  (Product_elem) inFromServer.readObject();
            inFromServer.close();






            outToServer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return msg;
    }
    protected void onPostExecute(Object results)
    {
        if(results != null)
        {
            R.getproducts((List<Product_elem>) results);
        }

    }
}
