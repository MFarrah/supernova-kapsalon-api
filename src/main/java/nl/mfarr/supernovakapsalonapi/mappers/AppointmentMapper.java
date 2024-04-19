package nl.mfarr.supernovakapsalonapi.mappers;

import nl.mfarr.supernovakapsalonapi.dtos.AvailabilitySlotDto;
import nl.mfarr.supernovakapsalonapi.entities.AvailabilitySlotEntity;
import org.springframework.stereotype.Component;

@Component
public class AppointmentMapper {

    public AvailabilitySlotEntity convertToEntity(AvailabilitySlotDto availabilitySlotDto) {
        AvailabilitySlotEntity availabilitySlotEntity = new AvailabilitySlotEntity();
        availabilitySlotEntity.setId(availabilitySlotDto.getId());
        availabilitySlotEntity.setDayOfWeek(availabilitySlotDto.getDayOfWeek());
        availabilitySlotEntity.setStartTime(availabilitySlotDto.getStartTime());
        availabilitySlotEntity.setEndTime(availabilitySlotDto.getEndTime());

        return availabilitySlotEntity;
    }

   public AvailabilitySlotDto convertToDto(AvailabilitySlotEntity availabilitySlot) {
        AvailabilitySlotDto availabilitySlotDto = new AvailabilitySlotDto();
        availabilitySlotDto.setId(availabilitySlot.getId());
        availabilitySlotDto.setDayOfWeek(availabilitySlot.getDayOfWeek());
        availabilitySlotDto.setStartTime(availabilitySlot.getStartTime());
        availabilitySlotDto.setEndTime(availabilitySlot.getEndTime());

        return availabilitySlotDto;
    }
}
