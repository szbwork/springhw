package ua.epam.spring.hometask.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author Barna_Szoke
 */
public class LocalDateTimeFactory implements FactoryBean<LocalDateTime>, Comparable<LocalDateTimeFactory>{

    private String localDateTimeString;
    private DateTimeFormatter dateTimeFormatter;

    public LocalDateTimeFactory(DateTimeFormatter dateTimeFormatter) {
        this.dateTimeFormatter = dateTimeFormatter;
    }

    public void setLocalDateTimeString(String localDateTimeString) {
        this.localDateTimeString = localDateTimeString;
    }

    public String getLocalDateTimeString() {
        return localDateTimeString;
    }

    private LocalDateTime toLocaleDateTime(String localDateTimeString) {
        return LocalDateTime.parse(localDateTimeString, dateTimeFormatter);
    }

    @Override
    public int compareTo(LocalDateTimeFactory localDateTimeFactory) {
        LocalDateTime localDateTime = null;
        LocalDateTime localDateTimeParam = null;
        try {
            localDateTime = toLocaleDateTime(localDateTimeString);
            localDateTimeParam = localDateTimeFactory.getObject();
            return toLocaleDateTime(localDateTimeString).compareTo(localDateTimeFactory.getObject());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return localDateTime.compareTo(localDateTimeParam);
    }

    @Override
    public LocalDateTime getObject(){
        return LocalDateTime.parse(localDateTimeString, dateTimeFormatter);
    }

//    @Override
//    public LocalDateTime getObject(String localDateTimeString){
//        return LocalDateTime.parse(localDateTimeString, dateTimeFormatter);
//    }

    @Override
    public Class<?> getObjectType() {
        return LocalDateTime.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
