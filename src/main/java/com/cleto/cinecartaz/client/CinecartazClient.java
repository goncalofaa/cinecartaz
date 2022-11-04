package com.cleto.cinecartaz.client;

import com.cleto.cinecartaz.model.Movie;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CinecartazClient {
    private static List<String> movies_endpoints;

    private static Map<String, Movie> movies_map;
    private static String uri = "https://cinecartaz.publico.pt";

    public static void main(String[] args) throws IOException, InterruptedException {
        movies_map = new HashMap<>();
        movies_endpoints = new ArrayList<>();

        Document document = Jsoup.connect(uri).get();

        Elements movies_elements = document.getElementsByClass("collection__item");

        for (Element e: movies_elements) {

            String movie_endpoint= e.getElementsByClass("block-link").attr("href");

            movies_endpoints.add(movie_endpoint);
        }
        Integer n = 0;
        for (String endpoint: movies_endpoints){
            n++;
            System.out.println(n+"---"+uri+endpoint);
            document = Jsoup.connect(uri+endpoint).get();
            String title = document.getElementsByClass("movie-detail__title").text();
            String original_title = document.getElementsByClass("movie-detail__section-wrapper movie-detail__section-wrapper-halves").get(0).getElementsByTag("p").text();
            List<String> genre= List.of(document.getElementsByClass("movie-detail__info").get(0).getElementsByClass("movie-detail__info-item").get(0).text().split(","));
            String duration = document.getElementsByClass("movie-detail__info").get(0).getElementsByClass("movie-detail__info-item").get(1).text().replace("min","");
            System.out.println(title);
            System.out.println(original_title);
            System.out.println(genre);
            System.out.println(duration);
            System.out.println("------------------------------");
            Movie movie = new Movie(title,original_title,genre,duration,endpoint);
            movies_map.put(original_title,movie);
        }

    }
}
