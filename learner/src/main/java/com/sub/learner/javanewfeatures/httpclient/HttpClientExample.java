package com.sub.learner.javanewfeatures.httpclient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class HttpClientExample {

    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {

        // sync request
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://www.ldapsoft.com")).build();
        // HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // System.out.println(response.body());

        System.out.println("---------------------------------------------------------");
        // async request
        CompletableFuture<Void> resultFuture = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body).thenAccept(System.out::println);
        resultFuture.get();

    }

}
