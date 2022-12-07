package com.example.obi_warenkorb;

import org.apache.hc.client5.http.classic.methods.HttpDelete;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPut;
import org.apache.hc.client5.http.classic.methods.HttpUriRequest;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.HttpResponse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
class ObiWarenkorbApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testRequests() throws IOException {

        HttpResponse response;

        HttpUriRequest requestAddSuccess = new HttpPut( "http://localhost:8080/addArtikel?id=001&amount=10");
        HttpUriRequest requestAddFail = new HttpPut( "http://localhost:8080/addArtikel?id=001&amount=3" );
        HttpUriRequest requestAddElse = new HttpPut( "http://localhost:8080/addArtikel?id=002&amount=10" );
        HttpUriRequest requestGetCart = new HttpGet( "http://localhost:8080/getWarenkorb" );
        HttpUriRequest requestDeleteItem = new HttpDelete( "http://localhost:8080/removeArtikel?id=001" );
        HttpUriRequest requestClear = new HttpDelete( "http://localhost:8080/clearWarenkorb" );

        HttpClientBuilder.create().build().execute( requestAddSuccess );
        HttpClientBuilder.create().build().execute( requestAddFail );
        HttpClientBuilder.create().build().execute( requestAddElse );
        HttpClientBuilder.create().build().execute( requestGetCart );
        HttpClientBuilder.create().build().execute( requestAddFail );
        HttpClientBuilder.create().build().execute( requestDeleteItem );
        HttpClientBuilder.create().build().execute( requestClear );
        response = HttpClientBuilder.create().build().execute( requestGetCart );

        //TODO: Write actual tests!
        assertTrue(true);

    }

}
