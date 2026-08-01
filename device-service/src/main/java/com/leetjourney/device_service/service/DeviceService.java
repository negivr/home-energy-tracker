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
