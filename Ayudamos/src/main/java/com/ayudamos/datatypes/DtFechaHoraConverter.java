package com.ayudamos.datatypes;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Converter(autoApply = true)
public class DtFechaHoraConverter implements AttributeConverter<DtFechaHora, Timestamp> {

    @Override
    public Timestamp convertToDatabaseColumn(DtFechaHora dtFechaHora) {
        if (dtFechaHora == null) {
            return null;
        }
        LocalDateTime localDateTime = LocalDateTime.of(
            dtFechaHora.getAnio(), 
            dtFechaHora.getMes(), 
            dtFechaHora.getDia(), 
            dtFechaHora.getHora(), 
            dtFechaHora.getMinuto()
        );
        return Timestamp.valueOf(localDateTime);
    }

    @Override
    public DtFechaHora convertToEntityAttribute(Timestamp timestamp) {
        if (timestamp == null) {
            return null;
        }
        LocalDateTime localDateTime = timestamp.toLocalDateTime();
        return new DtFechaHora(
            localDateTime.getDayOfMonth(),
            localDateTime.getMonthValue(),
            localDateTime.getYear(),
            localDateTime.getHour(),
            localDateTime.getMinute()
        );
    }
}
