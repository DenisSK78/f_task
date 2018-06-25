package by.task.service.util;

import by.task.repository.entity.Status;

import java.util.Locale;

public class ConvertStatus {
    public static Status getEnumStatus(String r){
        return Status.valueOf(r.toUpperCase(Locale.ENGLISH));
    }
}
