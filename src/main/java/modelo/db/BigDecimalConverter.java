package modelo.db;

import java.math.BigDecimal;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class BigDecimalConverter implements
		AttributeConverter<BigDecimal, String> {

	@Override
	public String convertToDatabaseColumn(BigDecimal bigDecimal) {
		return bigDecimal.toString();
	}

	@Override
	public BigDecimal convertToEntityAttribute(String string) {
		return new BigDecimal(string);
	}
}