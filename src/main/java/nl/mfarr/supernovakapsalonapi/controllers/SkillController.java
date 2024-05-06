package nl.mfarr.supernovakapsalonapi.controllers;

import nl.mfarr.supernovakapsalonapi.dtos.SkillDto;
import nl.mfarr.supernovakapsalonapi.services.SkillService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/skills")
public class SkillController {


    private final SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @PostMapping
    public ResponseEntity<SkillDto> createSkill(@RequestBody SkillDto skillDto) {
        SkillDto createdSkill = skillService.createSkill(skillDto);
        return new ResponseEntity<>(createdSkill, HttpStatus.CREATED);
    }

    @PostMapping("/batch")
    public ResponseEntity<List<SkillDto>> createSkills(@RequestBody List <SkillDto> skillDtos) {
        return ResponseEntity.ok(skillService.createSkills(skillDtos));
    }

    @GetMapping
    public ResponseEntity<Object> getAllSkills() {
        return ResponseEntity.ok(skillService.getAllSkills());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<SkillDto>> getSkillById(@PathVariable Long id) {
        Optional<SkillDto> skillDto = skillService.getSkillById(id);
        return ResponseEntity.ok(skillDto);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<SkillDto> patchSkill(@PathVariable Long id, @RequestBody SkillDto skillDto) {
        SkillDto patchedSkill = skillService.patchSkill(id, skillDto);
        return ResponseEntity.ok(patchedSkill);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSkill(@PathVariable Long id) {
        skillService.deleteSkill(id);
        return ResponseEntity.noContent().build();
    }
}
