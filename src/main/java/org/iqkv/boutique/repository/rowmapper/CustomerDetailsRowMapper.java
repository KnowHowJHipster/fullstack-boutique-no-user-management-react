package org.iqkv.boutique.repository.rowmapper;

import io.r2dbc.spi.Row;
import java.util.function.BiFunction;
import org.iqkv.boutique.domain.CustomerDetails;
import org.iqkv.boutique.domain.enumeration.Gender;
import org.springframework.stereotype.Service;

/**
 * Converter between {@link Row} to {@link CustomerDetails}, with proper type conversions.
 */
@Service
public class CustomerDetailsRowMapper implements BiFunction<Row, String, CustomerDetails> {

    private final ColumnConverter converter;

    public CustomerDetailsRowMapper(ColumnConverter converter) {
        this.converter = converter;
    }

    /**
     * Take a {@link Row} and a column prefix, and extract all the fields.
     * @return the {@link CustomerDetails} stored in the database.
     */
    @Override
    public CustomerDetails apply(Row row, String prefix) {
        CustomerDetails entity = new CustomerDetails();
        entity.setId(converter.fromRow(row, prefix + "_id", Long.class));
        entity.setGender(converter.fromRow(row, prefix + "_gender", Gender.class));
        entity.setPhone(converter.fromRow(row, prefix + "_phone", String.class));
        entity.setAddressLine1(converter.fromRow(row, prefix + "_address_line_1", String.class));
        entity.setAddressLine2(converter.fromRow(row, prefix + "_address_line_2", String.class));
        entity.setCity(converter.fromRow(row, prefix + "_city", String.class));
        entity.setCountry(converter.fromRow(row, prefix + "_country", String.class));
        return entity;
    }
}
