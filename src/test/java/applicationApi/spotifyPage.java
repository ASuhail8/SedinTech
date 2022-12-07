package applicationApi;

import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;

import java.util.HashMap;

import static Spec.SpecBuilder.getRequestSpec;
import static Spec.SpecBuilder.getResponseSpec;
import static Spec.spotifySpecBuilder.getSpotifyRequestSpec;
import static Spec.spotifySpecBuilder.getSpotifyResponseSpec;
import static io.restassured.RestAssured.given;

public class spotifyPage {

   String code = "AQCG_UEFpAIvIivQwWGRheNG9Cw4FrNG0AzocPhVoU-nlRYwmlEfWa28AB-w-9fzqsyTCAgc5nE4Fa5_SxwZBfMRt2ySCU_Rm8dBJfs2L4agaJVhQGK7Wb9H-WeqCm-AQBNW37HS1iYdKCof4q3YAOvRkYrgP1l-4rh4l58rskx8zxvOKqWHFMX-6nzvfWGvRlJgbHSitvmg5cZwSOq_pKQ9LBtDWmsM1hP_VdNAqg_vbKfCzidIQE7PzWoDT41jdfpGMmb0FYggAyNDrPibhRXqW9glhyPsSCMq0BiVZE2Qa9Ug5KUV5Uljt29acFxOpIEA99DDrE8IBAxvBdEh-rVR_rW-0psbp0fmoBkafiOn9ulWLDFXl_NXgdSw2zP_G0h_wRikFhnjJH2lDHxha6XkQasYYjkGBhQBNsR9g";
    public String getAccessToken()  {
        HashMap<String,String> formParams = new HashMap<>();
        formParams.put("grant_type","authorization_code");
        formParams.put("code",code);
        formParams.put("redirect_uri","https://localhost:8080");
        formParams.put("client_id","26bfaa2ea3dd45d18e669708f36520c1");
        formParams.put("client_secret","3363a55cee1848058991d8f6db839fa7");

        return given().
                spec(getSpotifyRequestSpec()).
                formParams(formParams).
        when().
                post("api/token").
        then().
                spec(getSpotifyResponseSpec()).
                extract().
                response().path("access_token");
    }


    public void getPlaylistApi(String accessToken){
        given().
                spec(getSpotifyRequestSpec()).
                header("Authorization","Bearer "+accessToken+"").
        when().
                get("v1/playlists/0r3XtEUrvQHpGulZD4FTxB").
        then().
                spec(getSpotifyResponseSpec());
    }
}
