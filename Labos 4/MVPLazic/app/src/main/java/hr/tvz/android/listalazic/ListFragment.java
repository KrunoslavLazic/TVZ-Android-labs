package hr.tvz.android.listalazic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import hr.tvz.android.listalazic.model.GroceryItem;
import hr.tvz.android.listalazic.retrofit.GitemService;
import hr.tvz.android.listalazic.retrofit.ServiceGenerator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ListFragment extends Fragment {
    private RecyclerView recyclerView;
    private GroceryListAdapter houseAdapter;

    private static final String API_URL = "http://10.0.2.2:8080/";

    public static List<GroceryItem> gitemList = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        GitemService client = ServiceGenerator.createService(GitemService.class, API_URL);

        Call<ArrayList<GroceryItem>> gItems = client.getAll();

        gItems.enqueue(new Callback<ArrayList<GroceryItem>>() {
            @Override
            public void onResponse(Call<ArrayList<GroceryItem>> call, Response<ArrayList<GroceryItem>> response) {
                if (response.isSuccessful()) {
                    gitemList = response.body();
                    System.out.println("TESTTT" + gitemList.get(0).getName());

                    houseAdapter = new GroceryListAdapter(gitemList);
                    recyclerView.setAdapter(houseAdapter);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<GroceryItem>> call, Throwable t) {
                System.out.println("GRESKAAA");
                System.out.println(t.getMessage());
                System.out.println(t.getLocalizedMessage());
                System.out.println(t.getCause().getMessage());
            }
        });


        return view;
    }

}


