package com.example.anshulchawla.latlong;

import android.app.DownloadManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;

public class mapImage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_image);
        Bundle bundle=getIntent().getExtras();
        String latValue=bundle.getString("latValue");
        String longValue=bundle.getString("longValue");
        Log.d("test",latValue);
       // TextView textView1=(TextView)findViewById(R.id.textView1);
        //textView1.setText(latValue+":"+longValue);

       String url ="https://maps.googleapis.com/maps/api/staticmap?center="+latValue+","+longValue+"&markers=color:red%7Clabel:%7C+"+latValue+","+longValue+"&zoom=12&size=300x500&key=AIzaSyADAm0BZEidyVOntDChnQLumuUUHflEPfw";

        new DownloadImageTask((ImageView) findViewById(R.id.imageView1)).execute(url);



    }
    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
    public  void onclick(View view){
        Intent i=new Intent(this, MainActivity.class);

        startActivity(i);
    }
}
