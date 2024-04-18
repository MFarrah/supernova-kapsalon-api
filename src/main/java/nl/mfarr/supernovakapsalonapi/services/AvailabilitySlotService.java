package nl.mfarr.supernovakapsalonapi.services;

import nl.mfarr.supernovakapsalonapi.entities.AvailabilitySlotEntity;
import nl.mfarr.supernovakapsalonapi.mappers.AvailabilitySlotMapper;
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
    private final AvailabilitySlotMapper availabilitySlotMapper;

    @Autowired
    public AvailabilitySlotService(AvailabilitySlotRepository availabilitySlotRepository, AvailabilitySlotMapper availabilitySlotMapper) {
        this.availabilitySlotRepository = availabilitySlotRepository;
        this.availabilitySlotMapper = availabilitySlotMapper;
    }

    public AvailabilitySlotDto createAvailabilitySlot(AvailabilitySlotDto availabilitySlotDto) {
        AvailabilitySlotEntity availabilitySlotEntity = availabilitySlotMapper.convertToEntity(availabilitySlotDto);
        AvailabilitySlotEntity savedAvailabilitySlot = availabilitySlotRepository.save(availabilitySlotEntity);
        return availabilitySlotMapper.convertToDto(savedAvailabilitySlot);
    }

    public Optional<AvailabilitySlotDto> getAvailabilitySlotById(Long id) {
        return availabilitySlotRepository.findById(id).map(availabilitySlotMapper::convertToDto);
    }

    public List<AvailabilitySlotDto> getAllAvailabilitySlots() {
        return availabilitySlotRepository.findAll().stream()
                .map(availabilitySlotMapper::convertToDto)
                .collect(Collectors.toList());
    }

    public AvailabilitySlotDto updateAvailabilitySlot(Long id, AvailabilitySlotDto availabilitySlotDto) {
        AvailabilitySlotEntity availabilitySlotEntity = availabilitySlotMapper.convertToEntity(availabilitySlotDto);
        availabilitySlotEntity = availabilitySlotRepository.save(availabilitySlotEntity);
        return availabilitySlotMapper.convertToDto(availabilitySlotEntity);
    }

    public void deleteAvailabilitySlot(Long id) {
        availabilitySlotRepository.deleteById(id);
    }
}