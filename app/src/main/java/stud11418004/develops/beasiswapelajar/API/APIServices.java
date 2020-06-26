package stud11418004.develops.beasiswapelajar.API;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import stud11418004.develops.beasiswapelajar.Response.AppliedResponse;
import stud11418004.develops.beasiswapelajar.Response.BeasiswaResponse;
import stud11418004.develops.beasiswapelajar.Response.DefaultResponse;
import stud11418004.develops.beasiswapelajar.Response.LoginResponse;
import stud11418004.develops.beasiswapelajar.Response.MahasiswaResponse;
import stud11418004.develops.beasiswapelajar.Response.SavedResponse;

public interface APIServices {

    @FormUrlEncoded
    @POST("login")
    Call<LoginResponse> Login(
            @Field("email") String email,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("createMahasiswa")
    Call<DefaultResponse> createMahasiswa(
            @Field("email") String email,
            @Field("nama") String nama,
            @Field("asal_univ") String asal_univ,
            @Field("jurusan") String jurusan,
            @Field("gender") String gender,
            @Field("tempat_lahir") String tempat_lahir,
            @Field("tanggal_lahir") String tanggal_lahir,
            @Field("alamat") String alamat,
            @Field("password") String password
    );

    @GET("allMahasiswa")
    Call<MahasiswaResponse> getAllMahasiswa();

    @GET("allBeasiswa")
    Call<BeasiswaResponse> getAllBeasiswa();

    @GET("allSaved")
    Call<SavedResponse> getAllSaved();

    @GET("allApplied")
    Call<AppliedResponse> getAllApplied();

}
