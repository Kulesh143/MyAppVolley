package com.kulesh.myappvolley;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONObject;
import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void hiVolley(View view) {
        String namii=((EditText) findViewById(R.id.etxt)).getText().toString();
        String  url = String.format("http://youripaddresshere/volley/vuser.php?naga="+namii);
        TextView tx=findViewById(R.id.txt);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                response -> {
                    int count=0;
                    while (count<response.length()){
                        try {
                            JSONObject jsonObject=response.getJSONObject(count);
                            tx.setText(jsonObject.getString("name")+" "+jsonObject.getString("email")+
                                    " "+jsonObject.getString("mobile")+" "+jsonObject.getString("password"));
                            count++;


                        }catch (Exception e){

                        }
                    }

                },
                error -> Log.i("rrrrr",error.getMessage())
        );MySingleton.getInstance(getApplicationContext()).addToRequestQueue(jsonArrayRequest);
    }
}