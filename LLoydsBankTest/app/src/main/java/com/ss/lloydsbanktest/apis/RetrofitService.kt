import com.ss.lloydsbanktest.model.Books
import com.ss.lloydsbanktest.model.Spells
import com.ss.lloydsbanktest.model.Weasley
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {

    @GET("en/books")
    suspend fun getBooks() : Response<List<Books>>

    @GET("es/spells")
    suspend fun getSpells() : Response<Spells>

    @GET("es/characters?search=Weasley")
    suspend fun getWeasley() : Response<Weasley>

    companion object {
        var retrofitService: RetrofitService? = null
        fun getInstance() : RetrofitService {
            if (retrofitService == null) {

                val logging = HttpLoggingInterceptor()
                logging.setLevel(HttpLoggingInterceptor.Level.BODY)

                val okhttpClient = OkHttpClient.Builder()
                okhttpClient.addInterceptor(logging)

                val retrofit = Retrofit.Builder()
                    .baseUrl("https://potterapi-fedeperin.vercel.app/")
                    .client(okhttpClient.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }

    }
}