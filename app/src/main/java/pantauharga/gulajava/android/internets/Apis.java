package pantauharga.gulajava.android.internets;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;

import java.util.List;
import java.util.Map;

import pantauharga.gulajava.android.Konstan;
import pantauharga.gulajava.android.modelgson.HargaKomoditasItem;
import pantauharga.gulajava.android.modelgson.HargaKomoditasLapor;
import pantauharga.gulajava.android.modelgson.Logins;
import pantauharga.gulajava.android.modelgson.Registrasis;

/**
 * Created by Gulajava Ministudio on 11/6/15.
 */
public class Apis {

    public static int JUMLAH_TIMEOUT = 2500;
    public static int JUMLAH_COBA = 2;
    public static float PENGALI_TIMEOUT = 1;

    public Apis() {
    }


    /**
     * AMBIL LINK
     **/

    //AMBIL HARGA KOMODITAS TERDEKAT
    ///Api/hargaall.json
    public static String getLinkHargaKomoditas() {
        return Konstan.ALAMATSERVER + "/Api/hargaall.json";
    }


    //LAPORKAN HARGA KOMODITAS
    ///Api/input.json
    public static String getLinkLaporHargaKomoditas() {
        return Konstan.ALAMATSERVER + "/Api/input.json";
    }
    //Laporkan Pesan Komoditas
    public static String getLinkPesanKomoditas() {
        return Konstan.ALAMATSERVER + "/Api/inputRequest.json";
    }
    //AMBIL DAFTAR KOMODITAS
    ///Api/comodityall.json
    public static String getLinkDaftarKomoditas() {
        return Konstan.ALAMATSERVER + "/Api/comodityall.json";
    }

    //REGISTER PENGGUNA
    ///Api/register.json
    public static String getLinkRegisterPengguna() {
        return Konstan.ALAMATSERVER + "/Api/register.json";
    }

    //LOGIN PENGGUNA
    ///Api/login.json
    public static String getLinkLoginPengguna() {
        return Konstan.ALAMATSERVER + "/Api/login.json";
    }


    private static DefaultRetryPolicy getRetryPolicy() {

        return new DefaultRetryPolicy(JUMLAH_TIMEOUT, JUMLAH_COBA, PENGALI_TIMEOUT);
    }


    /**
     * AMBIL REQUEST VOLLEY UNTUK KIRIM KE SERVERS
     **/

    //AMBIL HARGA KOMODITAS TERDEKAT
    public static JacksonRequestArray<HargaKomoditasItem> postRequestHargaKomoditasSekitars(
            String urls,
            Map<String, String> headers,
            Map<String, String> params,
            String jsonbodystr,
            Response.Listener<List<HargaKomoditasItem>> listenerok,
            Response.ErrorListener listenergagal
    ) {

        headers.put(Konstan.TAG_HEADERCONTENTIPE, Konstan.HEADER_JSONTYPE);

        JacksonRequestArray<HargaKomoditasItem> jacksonRequestArray = new JacksonRequestArray<>(
                Request.Method.POST,
                urls,
                HargaKomoditasItem.class,
                headers,
                params,
                jsonbodystr,
                listenerok,
                listenergagal
        );

        jacksonRequestArray.setRetryPolicy(getRetryPolicy());

        return jacksonRequestArray;
    }


    //LAPORKAN HARGA KOMODITAS
    public static JacksonRequest<HargaKomoditasLapor> postRequestHargaLapor(
            String urls,
            Map<String, String> headers,
            Map<String, String> params,
            String jsonbodystr,
            Response.Listener<HargaKomoditasLapor> listenerok,
            Response.ErrorListener listenergagal
    ) {

        headers.put(Konstan.TAG_HEADERCONTENTIPE, Konstan.HEADER_JSONTYPE);

        JacksonRequest<HargaKomoditasLapor> jacksonRequest = new JacksonRequest<>(
                Request.Method.POST,
                urls,
                HargaKomoditasLapor.class,
                headers,
                params,
                jsonbodystr,
                listenerok,
                listenergagal
        );

        jacksonRequest.setRetryPolicy(getRetryPolicy());

        return jacksonRequest;
    }


    //AMBIL DAFTAR KOMODITAS
    public static StrRekuestGet getRequestDaftarKomoditas(String urls, Response.Listener<String> listenerok,
                                                          Response.ErrorListener listenergagal) {

        StrRekuestGet strRekuestGet = new StrRekuestGet(
                Request.Method.GET,
                urls,
                null,
                listenerok,
                listenergagal
        );

        strRekuestGet.setRetryPolicy(getRetryPolicy());

        return strRekuestGet;
    }


    //REGISTER PENGGUNA
    public static JacksonRequest<Registrasis> postRequestRegistrasi(
            String urls,
            Map<String, String> headers,
            Map<String, String> params,
            String jsonbodystr,
            Response.Listener<Registrasis> listenerok,
            Response.ErrorListener listenergagal
    ) {

        headers.put(Konstan.TAG_HEADERCONTENTIPE, Konstan.HEADER_JSONTYPE);

        JacksonRequest<Registrasis> jacksonRequest = new JacksonRequest<>(
                Request.Method.POST,
                urls,
                Registrasis.class,
                headers,
                params,
                jsonbodystr,
                listenerok,
                listenergagal
        );

        jacksonRequest.setRetryPolicy(getRetryPolicy());

        return jacksonRequest;
    }


    //LOGIN PENGGUNA
    public static JacksonRequest<Logins> postRequestLogin(
            String urls,
            Map<String, String> headers,
            Map<String, String> params,
            String jsonbodystr,
            Response.Listener<Logins> listenerok,
            Response.ErrorListener listenergagal
    ) {

        headers.put(Konstan.TAG_HEADERCONTENTIPE, Konstan.HEADER_JSONTYPE);

        JacksonRequest<Logins> jacksonRequest = new JacksonRequest<>(
                Request.Method.POST,
                urls,
                Logins.class,
                headers,
                params,
                jsonbodystr,
                listenerok,
                listenergagal
        );

        jacksonRequest.setRetryPolicy(getRetryPolicy());

        return jacksonRequest;
    }


}
