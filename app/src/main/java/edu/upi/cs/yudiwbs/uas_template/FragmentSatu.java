package edu.upi.cs.yudiwbs.uas_template;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;
import edu.upi.cs.yudiwbs.uas_template.databinding.FragmentSatuBinding;


public class FragmentSatu extends Fragment {

    private FragmentSatuBinding binding;

    ArrayList<Hasil> alHasil = new ArrayList<>();
    AdapterHasil adapter;
    RecyclerView.LayoutManager lm;

    public FragmentSatu() {
        // Required empty public constructor
    }

    public static FragmentSatu newInstance(String param1, String param2) {
        FragmentSatu fragment = new FragmentSatu();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSatuBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        adapter = new AdapterHasil(alHasil);
        binding.rvAdvice.setAdapter(adapter);

        lm = new LinearLayoutManager(getActivity());
        binding.rvAdvice.setLayoutManager(lm);

        //supaya ada garis antar row
        binding.rvAdvice.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.tvKeterangan.setText("Tunggu sebentar, loading advice");
                Log.d("debugyudi","onclick");
                ApiAdvice.get("advice", null, new JsonHttpResponseHandler() {
                    @Override
                    //hati2 success jsonobjek atau jsonarray
                    public void onSuccess(int statusCode,
                                          Header[] headers,
                                          JSONObject response) {
                        Log.d("debugyudi","onSuccess jsonobjek");

                        String advice="";
                        try {
                            JSONObject slip = response.getJSONObject("slip");
                            advice = (String) slip.get("advice");
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.e("debugyudi", "msg error" +":" +e.getMessage());
                        }
                        Log.d("debugyudi", "rate" +":" +advice);
                        binding.tvKeterangan.setText("Your Advice");

                        alHasil.add(new Hasil("", advice,""));
                        adapter.notifyDataSetChanged();
                    }

                    public void onSuccess(int statusCode,
                                          Header[] headers,
                                          JSONArray response) {

                        Log.d("debugyudi","onSuccess jsonarray");

                    }

                    @Override
                    public  void onFailure(int statusCode, Header[] headers, String err, Throwable throwable)  {
                        Log.e("debugyudi", "error " + ":" + statusCode +":"+ err);
                    }
                });

            }
        });

        return view;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}



