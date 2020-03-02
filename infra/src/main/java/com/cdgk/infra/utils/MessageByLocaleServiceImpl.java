package com.cdgk.infra.utils;

import com.cdgk.domain.utils.MessageByLocaleService;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Locale;


@Component
@AllArgsConstructor
public class MessageByLocaleServiceImpl implements MessageByLocaleService {

    private MessageSource messageSource;

    @Override
    public String getMessage(String id, Locale locale) {
        return messageSource.getMessage(id, null, locale);
    }

    @Override
    public String getMessage(String id) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(id, null, locale);
    }

    @Override
    public String getMessage(String id, Locale locale, String... args) {
        return messageSource.getMessage(id, args, locale);
    }

    @Override
    public String getMessage(String id, String... args) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(id, args, locale);
    }
}
