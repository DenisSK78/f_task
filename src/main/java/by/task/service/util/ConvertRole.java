package by.task.service.util;

import by.task.repository.entity.Role;

import java.util.Locale;

public class ConvertRole {
    public static Role getEnumRole(String r){
        return Role.valueOf(r.toUpperCase(Locale.ENGLISH));
    }
}
