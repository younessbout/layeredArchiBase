package com.cdgk.domain.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface UtilService {

    Long getCurrentUserId();

    LocalDate getDateFromString(String date, String dateFormat);

    String getStringDateFrom(LocalDate date, String dateFormat);

    String getStringDateTimeFrom(LocalDateTime dateTime, String format);
}
