package nl.mfarr.supernovakapsalonapi.controllers;

import nl.mfarr.supernovakapsalonapi.dtos.AvailabilitySlotDto;
import nl.mfarr.supernovakapsalonapi.services.AvailabilitySlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/availabilityslots")
public class AvailabilitySlotController {

    @Autowired
    private AvailabilitySlotService availabilitySlotService;

    @PostMapping
    public ResponseEntity<AvailabilitySlotDto> createAvailabilitySlot(@RequestBody AvailabilitySlotDto availabilitySlotDto) {
        AvailabilitySlotDto createdAvailabilitySlot = availabilitySlotService.createAvailabilitySlot(availabilitySlotDto);
        return new ResponseEntity<>(createdAvailabilitySlot, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AvailabilitySlotDto> getAvailabilitySlotById(@PathVariable Long id) {
        AvailabilitySlotDto availabilitySlotDto = availabilitySlotService.getAvailabilitySlotById(id);
        return ResponseEntity.ok(availabilitySlotDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AvailabilitySlotDto> updateAvailabilitySlot(@PathVariable Long id, @RequestBody AvailabilitySlotDto availabilitySlotDto) {
        AvailabilitySlotDto updatedAvailabilitySlot = availabilitySlotService.updateAvailabilitySlot(id, availabilitySlotDto);
        return ResponseEntity.ok(updatedAvailabilitySlot);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAvailabilitySlot(@PathVariable Long id) {
        availabilitySlotService.deleteAvailabilitySlot(id);
        return ResponseEntity.noContent().build();
    }
}

