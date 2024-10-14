package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.serviceImplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.Device;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.repository.DeviceRepository;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.DeviceService;

@Service
public class DeviceServiceImplements implements DeviceService {
    @Autowired
    private DeviceRepository deviceRepository;

    @Override
    public Device createDevice(Device device) {
        return deviceRepository.save(device);
    }

    @Override
    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    @Override
    public Device getDeviceById(Long id) {
        return deviceRepository.findById(id).orElseThrow(() -> new RuntimeException("Device not found"));
    }

    @Override
    public Device updateDevice(Device device, Long id) {
        device.setId(id);
        return deviceRepository.save(device);
    }

    @Override
    public void deleteDevice(Long id) {
        deviceRepository.deleteById(id);
    }

    @Override
    public void deleteAllDevices() {
        deviceRepository.deleteAll();
    }
}
