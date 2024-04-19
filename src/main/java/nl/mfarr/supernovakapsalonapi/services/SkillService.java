package nl.mfarr.supernovakapsalonapi.services;

import nl.mfarr.supernovakapsalonapi.entities.SkillEntity;
import nl.mfarr.supernovakapsalonapi.repositories.SkillRepository;
import nl.mfarr.supernovakapsalonapi.dtos.SkillDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import nl.mfarr.supernovakapsalonapi.mappers.SkillMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SkillService {

    private final SkillRepository skillRepository;
    private final SkillMapper skillMapper;

    @Autowired
    public SkillService(SkillRepository skillRepository, SkillMapper skillMapper) {
        this.skillRepository = skillRepository;
        this.skillMapper = skillMapper;

    }


    public SkillDto createSkill(SkillDto skillDto) {
        SkillEntity skillEntity = skillMapper.convertToEntity(skillDto);
        SkillEntity savedSkill = skillRepository.save(skillEntity);
        return skillMapper.convertToDto(savedSkill);
    }


    public Optional<SkillDto> getSkillById(Long id) {
        return skillRepository.findById(id).map(skillMapper::convertToDto);
    }

    public List<SkillDto> getAllSkills() {
        return skillRepository.findAll().stream()
                .map(skillMapper::convertToDto)
                .collect(Collectors.toList());
    }

    public SkillDto updateSkill(Long id, SkillDto skillDto) {
        SkillEntity skillEntity = skillMapper.convertToEntity(skillDto);
        skillEntity = skillRepository.save(skillEntity);
        return skillMapper.convertToDto(skillEntity);
    }

    public void deleteSkill(Long id) {
        skillRepository.deleteById(id);
    }
}