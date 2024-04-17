package nl.mfarr.supernovakapsalonapi.controllers;

import nl.mfarr.supernovakapsalonapi.dtos.SkillDto;
import nl.mfarr.supernovakapsalonapi.services.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<Optional<SkillDto>> getSkillById(@PathVariable Long id) {
        Optional<SkillDto> skillDto = skillService.getSkillById(id);
        return ResponseEntity.ok(skillDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SkillDto> updateSkill(@PathVariable Long id, @RequestBody SkillDto skillDto) {
        SkillDto updatedSkill = skillService.updateSkill(id, skillDto);
        return ResponseEntity.ok(updatedSkill);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSkill(@PathVariable Long id) {
        skillService.deleteSkill(id);
        return ResponseEntity.noContent().build();
    }
}