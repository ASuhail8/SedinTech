package postman.tests;

import applicationApi.spotifyPage;
import org.testng.annotations.Test;

public class spotifyTests {

    String accessToken;

    @Test
    public void getPlaylistApiTest(){

        spotifyPage spotifyPage = new spotifyPage();
        accessToken = spotifyPage.getAccessToken();
        spotifyPage.getPlaylistApi(accessToken);


    }

}
