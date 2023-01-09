package br.com.areadigital.db.converter;

import lombok.SneakyThrows;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.text.SimpleDateFormat;
import java.util.Date;

@Converter
public class DateConverter implements AttributeConverter<String, Date> {
    /**
     * Converts the value stored in the entity attribute into the
     * data representation to be stored in the database.
     *
     * @param attribute the entity attribute value to be converted
     * @return the converted data to be stored in the database
     * column
     */
    @SneakyThrows
    @Override
    public Date convertToDatabaseColumn(String attribute) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date dateTime =   formato.parse(attribute);

        return dateTime;
    }

    /**
     * Converts the data stored in the database column into the
     * value to be stored in the entity attribute.
     * Note that it is the responsibility of the converter writer to
     * specify the correct <code>dbData</code> type for the corresponding
     * column for use by the JDBC driver: i.e., persistence providers are
     * not expected to do such type conversion.
     *
     * @param dbData the data from the database column to be
     *               converted
     * @return the converted value to be stored in the entity
     * attribute
     */
    @Override
    public String convertToEntityAttribute(Date dbData) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = formato.format(dbData);
        return formattedDate;
    }
}
