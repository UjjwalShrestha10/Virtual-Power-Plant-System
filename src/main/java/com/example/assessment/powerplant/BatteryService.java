package com.example.assessment.powerplant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BatteryService {

    @Autowired
    private BatteryRepository batteryRepository;

    public List<Battery> saveBatteries(List<Battery> batteries) {
        return batteryRepository.saveAll(batteries);
    }

    public Map<String, Object> getBatteriesByPostCodeRange(String startPostCode, String endPostCode) {
        List<Battery> batteries = batteryRepository.findByPostcodeBetweenOrderByNameAsc(startPostCode, endPostCode);

        int totalWattCapacity = batteries.stream().mapToInt(Battery::getWattCapacity).sum();
        double averageCapacity = batteries.stream()
                .mapToInt(Battery::getWattCapacity)
                .average()
                .orElse(0);

        return Map.of("batteries", batteries, "totalWattCapacity", totalWattCapacity,
                "averageWattCapacity", averageCapacity);
    }
}
