package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins="*",allowedHeaders = "*")
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@SpringBootApplication
public class DemoApplication {
	@Autowired
	private SightSevice sightSevice;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args).start();
	}
	@EventListener(ContextStartedEvent.class)
	private void initDB(ContextStartedEvent e) {
		sightSevice.deleteAllSight();
		KeelungSightsCrawler crawler = new KeelungSightsCrawler();
		Sight[] sights = crawler.getItems("七堵");
		List<Sight> sightList=new ArrayList<Sight>(sights.length);
		for (Sight sight:sights)
			sightSevice.createSight(sight);
		sights=crawler.getItems("中正");
		for (Sight sight:sights)
			sightSevice.createSight(sight);
		sights=crawler.getItems("中山");
		for (Sight sight:sights)
			sightSevice.createSight(sight);
		sights=crawler.getItems("暖暖");
		for (Sight sight:sights)
			sightSevice.createSight(sight);
		sights=crawler.getItems("信義");
		for (Sight sight:sights)
			sightSevice.createSight(sight);
		sights=crawler.getItems("安樂");
		for (Sight sight:sights)
			sightSevice.createSight(sight);
		sights=crawler.getItems("仁愛");
		for (Sight sight:sights)
			sightSevice.createSight(sight);
		System.out.println("done");
	}
	@GetMapping("/AllSightAPI")
	public Object[] getAllSight() {
		return sightSevice.getAllSight();
	}
	@GetMapping("/SightAPI")
	public List<Sight> getSight(@RequestParam(value = "zone", defaultValue = "") String name) {
		return sightSevice.getZone(name);
	}

}
