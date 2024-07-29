package com.example.assessment.powerplant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/batteries")
public class BatteryController {

    @Autowired
    private BatteryService batteryService;

    @PostMapping
    public ResponseEntity<List<Battery>> addBatteries(@RequestBody List<Battery> batteries) {
        List<Battery> savedBatteries = batteryService.saveBatteries(batteries);
        return ResponseEntity.ok(savedBatteries);
    }

    @GetMapping("postcode")
    public Map<String, Object> getBatteriesByPostCodeRange(@RequestParam String startPostCode, @RequestParam String endPostCode) {
        return batteryService.getBatteriesByPostCodeRange(startPostCode, endPostCode);
    }
}
