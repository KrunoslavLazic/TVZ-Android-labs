package hr.tvz.android.listalazic.retrofit;

import java.util.ArrayList;

import hr.tvz.android.listalazic.model.GroceryItem;
import retrofit2.Call;
import retrofit2.http.GET;

public interface GitemService {

    @GET("gitems")
    Call<ArrayList<GroceryItem>> getAll();

}
