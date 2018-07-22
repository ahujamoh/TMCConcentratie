package concentration.tmc.ahujamoh.com.tmc_concentratie.ImageDownloader;

import concentration.tmc.ahujamoh.com.tmc_concentratie.Models.Gallery;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FlickrAPIEndpoints {

    @GET("?method=flickr.photos.search")
    Call<Gallery> getPhotosForQuery(@Query("text") String query,
                                    @Query("per_page") int perPage,
                                    @Query("page") int page);
}
