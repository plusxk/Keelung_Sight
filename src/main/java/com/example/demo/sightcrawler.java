package com.example.demo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.IOException;

public class sightcrawler {
    public static Sight getItems(String link){
        Sight sight=new Sight();
        try {
            Document doc = Jsoup.connect(link).get();
            Elements e =doc.select("#point_area > cite > span.point_type > span:nth-child(2) > strong");
            sight.setCategory(e.text());
            sight.setDescription(doc.select("#point_area > div.text ").first().ownText());
            sight.setAddress(doc.select("#point_data > div.address > p > a > span").text());
            Elements es=doc.select(("#galleria"));
            if(!es.isEmpty()){
                sight.setPhotoURL(doc.select("#galleria > div.g_main > div.swiper-container > div.swiper-wrapper > div.swiper-slide > div.gpic > img").attr("data-src"));
            }
            else{
                sight.setPhotoURL("noimg");
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return sight;
    }
}