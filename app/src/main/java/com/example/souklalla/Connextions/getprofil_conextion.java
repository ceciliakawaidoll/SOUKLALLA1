package com.example.souklalla.Connextions;

import android.os.AsyncTask;

import com.example.souklalla.women.WOMENLOGIN;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.List;

import test.Profile;

public class getprofil_conextion  extends AsyncTask {

    public static interface Result_prof {
        void getprofile(Profile profile);
    }
    getprofil_conextion.Result_prof R;
    public void set_result(getprofil_conextion.Result_prof r){
        R = r;
    }

    String ip,Email;

    public getprofil_conextion( String ip,String email) {

        this.ip = ip;
        Email = email;
    }
    @Override
    protected Object doInBackground(Object[] objects) {
        Object msg;

        Socket clientSocket = null;
        try {


            clientSocket = new Socket(ip, 6789);
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());



            outToServer.writeBytes("getprofile\n");
            outToServer.writeBytes(Email+"\n");
            outToServer.flush();
            ObjectInputStream inFromServer = new ObjectInputStream (clientSocket.getInputStream());

            msg = inFromServer.readObject();
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
            R.getprofile((List<Profile>) results);
        }
    }
}
