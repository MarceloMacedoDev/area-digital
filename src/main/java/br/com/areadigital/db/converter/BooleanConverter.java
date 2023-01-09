package br.com.areadigital.db.converter;

import br.com.areadigital.db.enums.BooleanEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;


@Converter
public class BooleanConverter implements AttributeConverter<Boolean, Integer> {

    public Integer convertToDatabaseColumn(Boolean attribute) {
        return BooleanEnum.returnId(attribute);
    }

    public Boolean convertToEntityAttribute(Integer dbData) {
        return BooleanEnum.returnName(dbData);
    }

}
