package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.controller;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.App;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.repository.AppRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apps")
public class AppController {

    @Autowired
    private AppRepository appRepository;

    @PostMapping
    public App createApp(@RequestBody App app) {
        return appRepository.save(app);
    }

    @PutMapping("/{id}")
    public ResponseEntity<App> updateApp(@PathVariable Long id, @RequestBody App appDetails) {
        App app = appRepository.findById(id).orElseThrow();
        app.setNombre(appDetails.getNombre());
        app.setVersion(appDetails.getVersion());
        app.setDevices(appDetails.getDevices());
        app.setIsActive(appDetails.isActivo());
        app.setRating(appDetails.getRating());
        final App updatedApp = appRepository.save(app);
        return ResponseEntity.ok(updatedApp);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApp(@PathVariable Long id) {
        App app = appRepository.findById(id).orElseThrow();
        appRepository.delete(app);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<App> getAppById(@PathVariable Long id) {
        App app = appRepository.findById(id).orElseThrow();
        return ResponseEntity.ok(app);
    }

    @GetMapping
    public List<App> getAllApps() {
        return appRepository.findAll();
    }
}
