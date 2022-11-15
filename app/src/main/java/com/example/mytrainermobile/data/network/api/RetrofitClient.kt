package ar.edu.itba.example.api.data.network.api

import android.content.Context
import com.example.mytrainermobile.BuildConfig
import com.example.mytrainermobile.data.network.api.*
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

object RetrofitClient {

    @Volatile
    private var instance: Retrofit? = null

    private fun getInstance(context: Context) : Retrofit =
        instance ?: synchronized(this) {
            instance ?: buildRetrofit(context).also { instance = it}
        }

    private fun buildRetrofit(context: Context) : Retrofit {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(AuthInterceptor(context))
            .addInterceptor(httpLoggingInterceptor)
            .build()

        val gson = GsonBuilder()
            .registerTypeAdapter(Date::class.java, ApiDateTypeAdapter())
            .create()

        return Retrofit.Builder()
            .baseUrl(BuildConfig.API_BASE_URL)
            //.baseUrl("http://192.168.0.239:8080/api/") TODO NO BORRAR ESTA LINEA LA USA RANA PARA DEBUGEAR
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()
    }

    fun getApiUserService(context: Context) : ApiUserService {
        return getInstance(context).create(ApiUserService::class.java)
    }

    fun getApiSportService(context: Context) : ApiSportService {
        return getInstance(context).create(ApiSportService::class.java)
    }

    fun getApiRoutineService(context: Context) : ApiRoutineService {
        return getInstance(context).create(ApiRoutineService::class.java)
    }

    fun getApiFavouriteService(context: Context): ApiFavouriteService {
        return getInstance(context).create(ApiFavouriteService::class.java)
    }
}
