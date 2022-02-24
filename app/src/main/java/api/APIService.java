package api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface APIService {
    @GET("{random}")
    Call<String> getQuote(@Path("random") String random);
}