package nl.mfarr.supernovakapsalonapi.services;

import nl.mfarr.supernovakapsalonapi.entities.AvailabilitySlotEntity;
import nl.mfarr.supernovakapsalonapi.repositories.AvailabilitySlotRepository;
import nl.mfarr.supernovakapsalonapi.dtos.AvailabilitySlotDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AvailabilitySlotService {


    private final AvailabilitySlotRepository availabilitySlotRepository;

    public AvailabilitySlotService(AvailabilitySlotRepository availabilitySlotRepository) {
        this.availabilitySlotRepository = availabilitySlotRepository;
    }

    public AvailabilitySlotDto createAvailabilitySlot(AvailabilitySlotDto availabilitySlotDto) {
        AvailabilitySlotEntity availabilitySlot = convertToEntity(availabilitySlotDto);
        AvailabilitySlotEntity savedAvailabilitySlot = availabilitySlotRepository.save(availabilitySlot);
        return convertToDto(savedAvailabilitySlot);
    }

    public Optional<AvailabilitySlotDto> getAvailabilitySlotById(Long id) {
        return availabilitySlotRepository.findById(id).map(this::convertToDto);
    }

    public List<AvailabilitySlotDto> getAllAvailabilitySlots() {
        return availabilitySlotRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public AvailabilitySlotDto updateAvailabilitySlot(Long id, AvailabilitySlotDto availabilitySlotDto) {
        AvailabilitySlotEntity availabilitySlot = convertToEntity(availabilitySlotDto);
        availabilitySlot = availabilitySlotRepository.save(availabilitySlot);
        return convertToDto(availabilitySlot);
    }

    public void deleteAvailabilitySlot(Long id) {
        availabilitySlotRepository.deleteById(id);
    }

    private AvailabilitySlotEntity convertToEntity(AvailabilitySlotDto availabilitySlotDto) {
        AvailabilitySlotEntity availabilitySlot = new AvailabilitySlotEntity();
        availabilitySlot.setDayOfWeek(availabilitySlotDto.getDayOfWeek());
        availabilitySlot.setStartTime(availabilitySlotDto.getStartTime());
        availabilitySlot.setEndTime(availabilitySlotDto.getEndTime());
        return availabilitySlot;
    }

    private AvailabilitySlotDto convertToDto(AvailabilitySlotEntity availabilitySlot) {
        AvailabilitySlotDto availabilitySlotDto = new AvailabilitySlotDto();
        availabilitySlotDto.setId(availabilitySlot.getId());
        availabilitySlotDto.setDayOfWeek(availabilitySlot.getDayOfWeek());
        availabilitySlotDto.setStartTime(availabilitySlot.getStartTime());
        availabilitySlotDto.setEndTime(availabilitySlot.getEndTime());
        return availabilitySlotDto;
    }
}