package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service("Sight")
public class SightSevice {

        @Autowired
        private SightRepository repository;

        public  Object[] getAllSight(){
                return repository.findAll().toArray();
        }

        public List<Sight> getZone(String zone) {
              return repository.findSightByZoneLike(zone);

        }
        public Sight createSight(Sight request) {
                Sight sight = new Sight();
                sight.setSightName(request.getSightName());
                sight.setAddress(request.getAddress());
                sight.setPhotoURL(request.getPhotoURL());
                sight.setZone(request.getZone());
                sight.setCategory(request.getCategory());
                sight.setDescription(request.getDescription());
                return repository.insert(sight);
        }
        public void deleteAllSight() {
                repository.deleteAll();
        }

}
