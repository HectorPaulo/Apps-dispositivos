package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.controller;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.Device;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.repository.DeviceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/devices")
public class DeviceController {

    @Autowired
    private DeviceRepository deviceRepository;

    @PostMapping
    public Device createDevice(@RequestBody Device device) {
        return deviceRepository.save(device);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Device> updateDevice(@PathVariable Long id, @RequestBody Device deviceDetails) {
        Device device = deviceRepository.findById(id).orElseThrow();
        device.setModelo(deviceDetails.getModelo());
        device.setManufacturero(deviceDetails.getManufacturero());
        device.setAno(deviceDetails.getAno());
        device.setSo(deviceDetails.getSo());
        device.setEsRoot(deviceDetails.EsRoot());
        final Device updatedDevice = deviceRepository.save(device);
        return ResponseEntity.ok(updatedDevice);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDevice(@PathVariable Long id) {
        Device device = deviceRepository.findById(id).orElseThrow();
        deviceRepository.delete(device);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Device> getDeviceById(@PathVariable Long id) {
        Device device = deviceRepository.findById(id).orElseThrow();
        return ResponseEntity.ok(device);
    }

    @GetMapping
    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }
}
