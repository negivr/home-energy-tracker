package com.leetjourney.device_service.service;

import com.leetjourney.device_service.dto.DeviceDto;
import com.leetjourney.device_service.entity.Device;
import com.leetjourney.device_service.repository.DeviceRepository;
import org.springframework.stereotype.Service;


@Service
public class DeviceService {

    private final DeviceRepository deviceRepository;

    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public DeviceDto getDeviceById(Long id) {
        Device device = deviceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Device not found with the id :" + id));
        return mapToDto(device);
    }

    public DeviceDto createDevice(DeviceDto deviceDto) {
        Device device = new Device();
        device.setName(deviceDto.getName());
        device.setType(deviceDto.getType());
        device.setLocation(deviceDto.getLocation());
        device.setUserId(deviceDto.getUserId());

        final Device savedDevice = deviceRepository.save(device);
        return mapToDto(savedDevice);
    }

    public DeviceDto updateDevice(Long id, DeviceDto deviceDto) {
        Device existing = deviceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Device not found with the id :" + id));
        existing.setName(deviceDto.getName());
        existing.setType(deviceDto.getType());
        existing.setLocation(deviceDto.getLocation());
        existing.setUserId(deviceDto.getUserId());

        final Device updatedDevice = deviceRepository.save(existing);
        return mapToDto(updatedDevice);
    }

    public void deleteDevice(Long id) {
        if (!deviceRepository.existsById(id)) {
            throw new IllegalArgumentException("Device not found with the id :" + id);
        }
        deviceRepository.deleteById(id);
    }

    private DeviceDto mapToDto(Device device) {
        DeviceDto deviceDto = new DeviceDto();
        deviceDto.setId(device.getId());
        deviceDto.setName(device.getName());
        deviceDto.setType(device.getType());
        deviceDto.setLocation(device.getLocation());
        deviceDto.setUserId(device.getUserId());
        return deviceDto;
    }
}
