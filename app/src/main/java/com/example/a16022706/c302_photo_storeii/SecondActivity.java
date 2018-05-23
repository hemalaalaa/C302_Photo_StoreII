package com.example.a16022706.c302_photo_storeii;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ListView lv;
    TextView tvTitle;
    TextView tvDesc;
    ArrayAdapter aa;
    ArrayList<Details> alCategory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);



    }
    @Override
    protected void onResume() {
        super.onResume();

        //tvTitle = findViewById(R.id.tvTitle);
        alCategory = new ArrayList<>();
        //lv = (ListView) this.findViewById(R.id.lvModules);
        lv = (ListView)findViewById(R.id.lvDetails);


        alCategory = new ArrayList<Details>();
        aa = new DetailsAdapter(this,R.layout.row_photodetails, alCategory);

        lv.setAdapter(aa);


        Intent i = getIntent();
        int category = i.getIntExtra("category", 0);

        Log.i("category", ""+category);
        //tvTitle.setText("" + category);


        // Code for step 1 start
        HttpRequest request = new HttpRequest
                ("http://10.0.2.2/C302_P06_PhotoStoreWS/getPhotoStoreByCategory.php?category_id="+category);
        request.setOnHttpResponseListener(mHttpResponseListener);
        request.setMethod("GET");
        request.execute();
        // Code for step 1 end
    }

    // Code for step 2 start
    private HttpRequest.OnHttpResponseListener mHttpResponseListener =
            new HttpRequest.OnHttpResponseListener() {
                @Override
                public void onResponse(String response){

                    // process response here
                    try {
                        Log.i("Results: ", response);
                        JSONArray jsonArray = new JSONArray(response);

                        for (int i=0; i<jsonArray.length(); i++){
                            JSONObject jsonObj = jsonArray.getJSONObject(i);

                            int photoId = jsonObj.getInt("photo_id");
                            String title = jsonObj.getString("title");
                            String image = jsonObj.getString("image");
                            String description = jsonObj.getString("description");
                            int categoryId = jsonObj.getInt("category_id");
                            String createdBy = jsonObj.getString("created_by");



                            Details details = new Details(photoId,title,description,image,categoryId,createdBy);
                            alCategory.add(details);
                        }
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }

                    aa.notifyDataSetChanged();
                }
            };



}
