package com.cdgk.infra.utils;

import com.cdgk.domain.utils.UtilService;
import com.cdgk.infra.config.ServiceProperties;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UtilServiceImpl implements UtilService {

    private ServiceProperties serviceProperties;

    @Override
    public Long getCurrentUserId() {
        return Utils.getCurrentUserId();
    }


    @Override
    public LocalDate getDateFromString(String date, String dateFormat) {

        String format = dateFormat == null ? serviceProperties.getDates().getDefaultDateFormat() : dateFormat;
        return Optional.ofNullable(date).map(d -> Utils.getDateFrom(date, format)).orElse(null);
    }

    @Override
    public String getStringDateFrom(LocalDate date, String dateFormat) {
        String format = dateFormat == null ? serviceProperties.getDates().getDefaultDateFormat() : dateFormat;

        return Optional.ofNullable(date).map(d -> Utils.getStringDateFrom(d, format)).orElse(null);
    }

    @Override
    public String getStringDateTimeFrom(LocalDateTime dateTime, String format) {
        String dateTimeFormat = format == null ? serviceProperties.getDates().getDefaultDateFormat() : format;

        return Optional.ofNullable(dateTime).map(d -> Utils.getStringFromDateTime(d, dateTimeFormat)).orElse(null);
    }

}
