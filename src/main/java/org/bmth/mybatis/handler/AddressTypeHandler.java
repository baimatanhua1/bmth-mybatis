package org.bmth.mybatis.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.bmth.mybatis.entity.Address;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by pengq on 2020/1/19 19:14.
 */
@MappedJdbcTypes(JdbcType.VARCHAR)
public class AddressTypeHandler extends BaseTypeHandler<Address> {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Address address, JdbcType jdbcType) throws SQLException {
        try {
            preparedStatement.setString(i, objectMapper.writeValueAsString(address));
        } catch (JsonProcessingException e) {
            preparedStatement.setString(i, null);
        }
    }

    @Override
    public Address getNullableResult(ResultSet resultSet, String s) throws SQLException {
        try {
            String address = resultSet.getString(s);
            if (address == null){
                return null;
            }

            return objectMapper.readValue(address,Address.class);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    @Override
    public Address getNullableResult(ResultSet resultSet, int i) throws SQLException {
        try {
            return objectMapper.readValue(resultSet.getString(i),Address.class);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    @Override
    public Address getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        try {
            return objectMapper.readValue(callableStatement.getString(i),Address.class);
        } catch (JsonProcessingException e) {
            return null;
        }
    }
}
