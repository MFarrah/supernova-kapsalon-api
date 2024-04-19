package nl.mfarr.supernovakapsalonapi.helpers;
import nl.mfarr.supernovakapsalonapi.dtos.SkillDto;
import nl.mfarr.supernovakapsalonapi.entities.SkillEntity;
import java.util.Set;

public class AppointmentDescriptionHelper {

    public static String generateDescription(Set<SkillEntity> skills) {
        StringBuilder descriptionBuilder = new StringBuilder();
        for (SkillEntity skill : skills) {
            descriptionBuilder.append(skill.getName()).append(", ");
        }
        return descriptionBuilder.toString().trim();
    }

    public static String generateDescriptionDto(Set<SkillDto> skills) {
        StringBuilder descriptionBuilder = new StringBuilder();
        for (SkillDto skill : skills) {
            descriptionBuilder.append(skill.getName()).append(", ");
        }
        return descriptionBuilder.toString().trim();
    }

}
