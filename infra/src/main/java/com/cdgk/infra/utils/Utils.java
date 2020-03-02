package com.cdgk.infra.utils;

import com.cdgk.domain.users.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public final class Utils {

    private Utils() {

    }

    public static LocalDate getDateFrom(String date, String dateFormat) {
        //TODO Change Default language
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat, Locale.FRENCH);
        return LocalDate.parse(date, formatter);
    }

    public static String getStringDateFrom(LocalDate date, String dateFormat) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat, Locale.FRENCH);
        return formatter.format(date);
    }

    public static Long getCurrentUserId() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        Long userId = null;
        if (authentication != null && authentication.getPrincipal() instanceof User) {

            User user = (User) authentication.getPrincipal();
            userId = user.getId();
        }
        return userId;
    }

    public static User getCurrentUser() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();

        if (authentication != null && authentication.getPrincipal() instanceof User) {
            return (User) authentication.getPrincipal();
        }
        return null;
    }


    public static String getStringFromDateTime(LocalDateTime dateTime, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format, Locale.FRENCH);
        return formatter.format(dateTime);
    }
}
