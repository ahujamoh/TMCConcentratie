package concentration.tmc.ahujamoh.com.tmc_concentratie.ImageDownloader;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitFlickrAPIClient {
    private static final String TAG = RetrofitFlickrAPIClient.class.getSimpleName();
    private static String API_KEY = "eec93a2b3390c8735ab2e6671612de59";
    public static final String BASE_URL = "https://api.flickr.com/services/rest/";
    // https://api.flickr.com/services/rest/?method=flickr.photos.search

    private static Retrofit retrofit = null;

    public static <T> T call(Class<T> serviceClass) {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();


        httpClientBuilder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                HttpUrl httpUrl = request.url().newBuilder()
                        // &api_key=<APIKEY>&extras=url_s&format=json&nojsoncallback=1
                        .addQueryParameter("api_key", API_KEY)
                        .addQueryParameter("format", "json")
                        .addQueryParameter("nojsoncallback", "1")
                        .addQueryParameter("extras", "url_s")
                        .build();
                request = request.newBuilder().url(httpUrl).build();
                return chain.proceed(request);
            }
        });

        httpClientBuilder.addInterceptor(interceptor);
        OkHttpClient client = httpClientBuilder.build();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).client(client).build();

        return retrofit.create(serviceClass);
    }

}
