package com.example.demo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;

public class KeelungSightsCrawler {
    public static Sight[] getItems(String zone){

        ArrayList<Sight> arrL = new ArrayList<Sight>();
        String url = "https://www.travelking.com.tw/tourguide/taiwan/keelungcity/";
        String []links =new String[20];
        String []names =new String[20];
        int now = 1;//紀錄目前是哪個景點
        try {
            Document doc = Jsoup.connect(url).get();
            Elements e = doc.select("#guide-point > div");
            int idx=2;
            for(int i=idx;i<=15;){
                Elements es=e.select("> h4:nth-child("+i+")");
                //System.out.println(es.text());
                if(es.text().equals(zone+"區")) {
                    idx = i;
                    break;
                }
                i+=2;
                if(i>15)
                    idx=0;//偵錯
            }
            idx++;
            Elements es=e.select(" > ul:nth-child("+idx+")");
            while(true){
                Elements u=es.select("> li:nth-child("+now+") > a");
                String link=u.attr("abs:href");
                if(link.equals(""))
                    break;
                links[now]=link;
                names[now]=u.attr("title");
                now++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(int i=1;i<now;i++){
            Sight sight=new Sight();
            sightcrawler sc=new sightcrawler();
            sight=sc.getItems(links[i]);
            sight.setSightName(names[i]);
            sight.setZone(zone+"區");
            arrL.add(sight);
        }
        Sight[] sights = new Sight[arrL.size()];
        sights = arrL.toArray(sights);
        return sights;
    }
}
