package com.leetjourney.device_service.controller;

import com.leetjourney.device_service.dto.DeviceDto;
import com.leetjourney.device_service.service.DeviceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/device")
public class DeviceController {

    private final DeviceService deviceService;

    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping("{id}")
    public ResponseEntity<DeviceDto> getDeviceById(@PathVariable Long id) {
        DeviceDto deviceDto = deviceService.getDeviceById(id);
        return ResponseEntity.ok(deviceDto);
    }


    @PostMapping("/create")
    public ResponseEntity<DeviceDto> createDevice() {
        return null;
    }
}
