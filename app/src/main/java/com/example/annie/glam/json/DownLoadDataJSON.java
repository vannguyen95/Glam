package com.example.annie.glam.json;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by DH Yuka on 6/9/2016.
 */
public class DownLoadDataJSON extends AsyncTask<String, Void, String> {
    StringBuilder dulieu;

    public interface AsyncResponse {
        void processFinish(String output);
    }

    public AsyncResponse delegate = null;

    public DownLoadDataJSON(AsyncResponse delegate) {
        this.delegate = delegate;
    }

    @Override
    protected String doInBackground(String... params) {
        dulieu = new StringBuilder();
        try {
            URL url = new URL(params[0]);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.connect();

            InputStream inputStream = httpURLConnection.getInputStream();
            InputStreamReader reader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String dong = "";

            while ((dong = bufferedReader.readLine()) != null) {
                dulieu.append(dong);
            }

            bufferedReader.close();
            reader.close();
            inputStream.close();
            httpURLConnection.disconnect();


        } catch (MalformedURLException e) {

        } catch (IOException e) {
            e.printStackTrace();
        }
        return dulieu.toString();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        delegate.processFinish(s);
    }

}
