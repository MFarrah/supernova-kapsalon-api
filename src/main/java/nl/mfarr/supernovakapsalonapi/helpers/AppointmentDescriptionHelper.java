package nl.mfarr.supernovakapsalonapi.helpers;

import nl.mfarr.supernovakapsalonapi.entities.SkillEntity;
import java.util.Set;

public class AppointmentDescriptionHelper {

    public static String generateDescription(Set<SkillEntity> skills) {
        StringBuilder descriptionBuilder = new StringBuilder();
        descriptionBuilder.append("");
        for (SkillEntity skill : skills) {
            descriptionBuilder.append(skill.getName()).append("");
        }
        return descriptionBuilder.toString();
    }
}