package nl.mfarr.supernovakapsalonapi.services;

import nl.mfarr.supernovakapsalonapi.entities.SkillEntity;
import nl.mfarr.supernovakapsalonapi.repositories.SkillRepository;
import nl.mfarr.supernovakapsalonapi.dtos.SkillDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SkillService {


    private final SkillRepository skillRepository;

    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public SkillDto createSkill(SkillDto skillDto) {
        SkillEntity skill = convertToEntity(skillDto);
        SkillEntity savedSkill = skillRepository.save(skill);
        return convertToDto(savedSkill);
    }

    public Optional<SkillDto> getSkillById(Long id) {
        return skillRepository.findById(id).map(this::convertToDto);
    }

    public List<SkillDto> getAllSkills() {
        return skillRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public SkillDto updateSkill(Long id, SkillDto skillDto) {
        SkillEntity skill = convertToEntity(skillDto);
        skill = skillRepository.save(skill);
        return convertToDto(skill);
    }

    public void deleteSkill(Long id) {
        skillRepository.deleteById(id);
    }

    private SkillEntity convertToEntity(SkillDto skillDto) {
        SkillEntity skill = new SkillEntity();
        skill.setName(skillDto.getName());
        skill.setDescription(skillDto.getDescription());
        skill.setPrice(skillDto.getPrice());
        return skill;
    }

    private SkillDto convertToDto(SkillEntity skill) {
        SkillDto skillDto = new SkillDto();
        skillDto.setId(skill.getId());
        skillDto.setName(skill.getName());
        skillDto.setDescription(skill.getDescription());
        skillDto.setPrice(skill.getPrice());
        return skillDto;
    }
}