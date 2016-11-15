package com.hakiki95.simpelvolleyrequest;

import android.nfc.Tag;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.hakiki95.simpelvolleyrequest.Helper.RecyclerOnTouchListener;
import com.hakiki95.simpelvolleyrequest.adapter.AdapterMahasiswa;
import com.hakiki95.simpelvolleyrequest.app.AppController;
import com.hakiki95.simpelvolleyrequest.model.Model_Mhs;
import com.hakiki95.simpelvolleyrequest.util.RecyclerClickListener;
import com.hakiki95.simpelvolleyrequest.util.ServerWeb;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLmanager;

    private List<Model_Mhs> mListMhs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerviewTEMP);
        mListMhs = new ArrayList<Model_Mhs>();

        callVolle();

        actionClickRecycler();

        mAdapter = new AdapterMahasiswa(MainActivity.this,mListMhs);
        mRecyclerView.setAdapter(mAdapter);
        mLmanager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(mLmanager);

    }




    public  void actionClickRecycler()
    {
        mRecyclerView.addOnItemTouchListener(new RecyclerOnTouchListener(getApplicationContext(), mRecyclerView, new RecyclerClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(MainActivity.this, "Action Clik Listener Recycler", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {
                Toast.makeText(MainActivity.this, "Action long Click Listener", Toast.LENGTH_SHORT).show();
            }
        }));
    }




    public void callVolle()
    {
        JsonObjectRequest requestObject = new JsonObjectRequest(Request.Method.POST, ServerWeb.url_getMhs,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("VOLLER REQUEST", "response = " + response.toString());


                        try {
                            JSONArray arrayMhs = response.getJSONArray("mahasiswa");

                            for(int i=0 ; i < arrayMhs.length() ; i++)
                            {
                                JSONObject data = arrayMhs.getJSONObject(i);
                                Model_Mhs mm = new Model_Mhs();
                                mm.setImageUrl(data.getString("img_profil"));
                                mm.setNpm(data.getString("npm"));
                                mm.setNama(data.getString("nama"));
                                mm.setProdi(data.getString("prodi"));
                                mm.setFakultas(data.getString("fakultas"));

                                mListMhs.add(mm);
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("JSON REQUEST", "error : " + error.getMessage());
                    }
                });

        AppController.getInstance().addToRequestQueue(requestObject);
    }
}
