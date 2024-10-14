package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.Device;

@Service
public interface DeviceService {
    public Device createDevice(Device device);

    public List<Device> getAllDevices();

    public Device getDeviceById(Long id);

    public Device updateDevice(Device device, Long id);

    public void deleteDevice(Long id);

    public void deleteAllDevices();
}
