package com.cdgk.domain.utils;

import java.util.Locale;

public interface MessageByLocaleService {

    public String getMessage(String id, Locale local);

    public String getMessage(String id, Locale local, String... args);

    public String getMessage(String id);

    public String getMessage(String id, String... args);
}
