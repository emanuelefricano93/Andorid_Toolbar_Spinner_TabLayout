package com.example.efricano.myapplication;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * Created by e.fricano on 13/03/2017.
 */

public class ScritturaLettura_Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letturascrittura);

        // catches IOException below
        final String TESTSTRING = new String("Hello Android");

       /* We have to use the openFileOutput()-method
       * the ActivityContext provides, to
       * protect your file from others and
       * This is done for security-reasons.
       * We chose MODE_WORLD_READABLE, because
       *  we have nothing to hide in our file */
        FileOutputStream fOut = null;
        try {
            fOut = openFileOutput("samplefile.txt",
                    MODE_APPEND);

        OutputStreamWriter osw = new OutputStreamWriter(fOut);
        osw.write(TESTSTRING);
        osw.flush();
        osw.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileInputStream fIn = null;
        try {
            fIn = openFileInput("samplefile.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        InputStreamReader isr = new InputStreamReader(fIn);

        /* Prepare a char-Array that will
         * hold the chars we read back in. */
        char[] inputBuffer = new char[TESTSTRING.length()];

        // Fill the Buffer with data from the file
        try {
            isr.read(inputBuffer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Transform the chars to a String
        String readString = new String(inputBuffer);

        // Check if we read back the same chars that we had written out
        boolean isTheSame = TESTSTRING.equals(readString);

        Log.d("File Reading stuff", "success = " + isTheSame);


        TextView tv= (TextView) findViewById(R.id.textView_lettura_scrittura);
        tv.setText("is the Same:"+isTheSame);

        String state = Environment.getExternalStorageState();
        TextView tv2= (TextView) findViewById(R.id.textView_lettura_scrittura);
        tv2.setText("Lo stato per la scrittura dei file esterni e':"+state);

        File root = android.os.Environment.getExternalStorageDirectory();
        tv2.append("\nExternal file system root: "+root);

        File dir = new File (root.getAbsolutePath() + "/download");
        dir.mkdirs();
        File file = new File(dir, "myData.txt");

        try {
            FileOutputStream f = new FileOutputStream(file);
            PrintWriter pw = new PrintWriter(f);
            pw.println("Hi , How are you");
            pw.println("Hello");
            pw.flush();
            pw.close();
            f.close();
            tv.append("\n\nScritto e chiuso"+file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Log.i("MyAPP", "******* File not found. Did you" +
                    " add a WRITE_EXTERNAL_STORAGE permission to the   manifest?");
        } catch (IOException e) {
            e.printStackTrace();



        }
        tv.append("\n\nFile written to "+file);

        tv.append("\n\n "+file.getAbsolutePath());



        tv.append("\n\n sono qui adesso");

        final File file2 = new File(Environment.getExternalStorageDirectory()
                .getAbsolutePath()+"/download", file.getName());

        try {
            FileInputStream fis = new FileInputStream (file2);  // 2nd line
            char[] inputBuffer2 = new char[TESTSTRING.length()];

            // Fill the Buffer with data from the file
            try {
                isr.read(inputBuffer2);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Transform the chars to a String
            String readString2 = new String(inputBuffer);
            tv.append("\n\nciaone:"+readString2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }





    }
}
