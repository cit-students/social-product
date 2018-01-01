package com.cit.productsocial;

import com.cit.productsocial.utils.social.facebook.FacebookClient;
import junit.framework.TestCase;

public class TestAccessToken extends TestCase {

    public TestAccessToken(String name) {
        super(name);
    }

    public void testCase_1() {
        System.out.println("Test with invalid access_token");
        String accessToken = "";
        FacebookClient client = new FacebookClient(accessToken);
        boolean expected = false;
        boolean actual = client.isTokenValid();
        assertEquals("Null access_token should return false", expected, actual);
        System.out.println("End test_case 1");
    }

    public void testCase_2() {
        System.out.println("Test with expired access_token");
        String accessToken = "EAACx7xEGZBokBAE9tAilXcol8dCC8HogbJWHmAIjxegdP7DflUALa9Bfu07JA" +
                "xmSHv6Guq75c5ANmzzZAj2Wbj3QtxtIG2yF6ue7cm0yXS3KeE6ZAwvpalpCpVpQV7LSb3D40afH" +
                "8AHsgHuZCfG4nhiOEKDf9ZCHFZClw0X1ZCWHZBcaZC1y1XkrPhv7uNzQOcEQjyJfgX1hGbgbdVV" +
                "dZCnql7F2WAJ1rtHo0QCW3RyqxMTG9D5DADZBFEVX";
        FacebookClient client = new FacebookClient(accessToken);
        boolean expected = false;
        boolean actual = client.isTokenValid();
        assertEquals("Expired access_token should return false", expected, actual);
        System.out.println("End test_case 2");
    }

    public void testCase_3() {
        System.out.println("Test with valid access_token");
        String accessToken = "EAACx7xEGZBokBAH47BrgZBWXfyZAYLDoiVS8CLAcQkbEqZBfhlHx17cqODPTa" +
                "RcZBXWguLAam7ZBH8gLZAlcsV75vRV8u7h30ODWvjTVWEZB5lATe4jZAOyPThDes5oqPjlKumlJ" +
                "QIIfBta8ZCQoT85srK2fFROkTEpfiAucPcpAfs04BdxZANZALZBhe9T8D7aHm084q9YtjKLyvgX" +
                "5fD0KKcHv9DSMfyLQPfjT3tySmfhJhDlDNg6IOLL2i";
        FacebookClient client = new FacebookClient(accessToken);
        boolean expected = true;
        boolean actual = client.isTokenValid();
        assertEquals("Right access_token should return true", expected, actual);
        System.out.println("End test_case 3");
    }
}
