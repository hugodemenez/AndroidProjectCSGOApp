package api;

import com.example.csgoapp.Quote;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface APIService {
    @GET("random")
    Call<Quote> getQuote();
}