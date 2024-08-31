package com.ayudamos.datatypes;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Converter(autoApply = true)
public class DtFechaConverter implements AttributeConverter<DtFecha, Date> {

    @Override
    public Date convertToDatabaseColumn(DtFecha attribute) {
        if (attribute == null) {
            return null;
        }
        
        Calendar calendar = new GregorianCalendar();
        calendar.set(attribute.getAnio(), attribute.getMes() - 1, attribute.getDia(), 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0); 
        return calendar.getTime();
    }

    @Override
    public DtFecha convertToEntityAttribute(Date dbData) {
        if (dbData == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dbData);
        return new DtFecha(calendar.get(Calendar.DAY_OF_MONTH),
                           calendar.get(Calendar.MONTH) + 1,
                           calendar.get(Calendar.YEAR));
    }
}
