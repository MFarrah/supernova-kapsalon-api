package nl.mfarr.supernovakapsalonapi.mappers;

import nl.mfarr.supernovakapsalonapi.dtos.SkillDto;
import nl.mfarr.supernovakapsalonapi.entities.SkillEntity;
import org.springframework.stereotype.Component;


@Component
public class SkillMapper {

    public SkillEntity convertToEntity(SkillDto skillDto) {
        SkillEntity skillEntity = new SkillEntity();
        skillEntity.setId(skillDto.getId());
        skillEntity.setName(skillDto.getName());
        skillEntity.setDescription(skillDto.getDescription());
        skillEntity.setPrice(skillDto.getPrice());
        skillEntity.setDuration(skillDto.getDuration());

        return skillEntity;
    }

    public SkillDto convertToDto(SkillEntity skillEntity) {
        SkillDto skillDto = new SkillDto();
        skillDto.setId(skillEntity.getId());
        skillDto.setName(skillEntity.getName());
        skillDto.setDescription(skillEntity.getDescription());
        skillDto.setPrice(skillEntity.getPrice());
        skillDto.setDuration(skillEntity.getDuration());


        return skillDto;
    }
}

