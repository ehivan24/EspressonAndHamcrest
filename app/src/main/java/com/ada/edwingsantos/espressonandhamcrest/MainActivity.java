package com.ada.edwingsantos.espressonandhamcrest;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * @author Edwing Santos
 * This class demostrates how to download information from intertnet
 * using a AsyntTask and posting the Results to a TextView
 *
 * @file MainActivity.java
 *
 * @brief      A downloader with AsyncTask.
 * @details    .java
 *
 * @date       April 4, 2016
 * @version    0.2.0.1 (alpha)
 */

public class MainActivity extends AppCompatActivity {
    public String TAG = "Result";

    /**
     * A dependency Injections using ButterKnife
     */

    @Bind(R.id.textView)TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        /**
         * We run the the class and execute the download
         * @params use string to download the website
         * @code
         *    Window win = new Window(parent);
         *    win.show();
         * @endcode
         */

        DownloadTask downloadTask = new DownloadTask();
        downloadTask.execute("http://www.edwingsantos.netne.net");


    }


    private class DownloadTask extends AsyncTask<String, Void, String> {
        DownloadUrl htmlStr = new DownloadUrl();

        @Override
        protected String doInBackground(String... urls) {
            try {
                return htmlStr.loadFromNetwork(urls[0]);
            } catch (IOException e) {
                return getString(R.string.error_connection);
            }
        }

        /**
         * Uses the logging framework to display the output of the fetch
         * operation in the log fragment.
         */

        @Override
        protected void onPostExecute(String result) {
            Log.i("Result", result);



            textView.setText(result);




        }
    }

    public class DownloadUrl {

        public String loadFromNetwork(String urlString) throws IOException {
            InputStream stream = null;
            String str ="";

            try {
                stream = downloadUrl(urlString);
                str = readIt(stream, 600);
            } finally {
                if (stream != null) {
                    stream.close();
                }
            }
            return str;
        }




        public InputStream downloadUrl(String urlString) throws IOException {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000 /* milliseconds */);
            conn.setConnectTimeout(15000 /* milliseconds */);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            conn.connect();
            InputStream stream = conn.getInputStream();
            return stream;
        }

        public String readIt(InputStream stream, int len) throws IOException, UnsupportedEncodingException {
            Reader reader = null;
            reader = new InputStreamReader(stream, "UTF-8");
            char[] buffer = new char[len];
            reader.read(buffer);
            return new String(buffer);
        }
    }
}

/**
 * @brief      Short method description.
 *
 * @details    Verbose description of method
 *             (or function) details.
 *
 * @param
 *
 * @return     The status of the program.
 *
 * @retval     status   The program status.
 *                      <ul>
 *                         <li> 0 = Failure
 *                         <li> 1 = Success
 *                      </ul>
 *
 * @todo       Make it do something.
 *
 * @bug        To be Microsoft Certified,
 *             must never deallocate memory.
 *
 * @exception
 *
 *
 * @see
 * @see
 */


