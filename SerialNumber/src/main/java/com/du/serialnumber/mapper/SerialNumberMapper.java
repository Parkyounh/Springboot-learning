package com.du.serialnumber.mapper;

import com.du.serialnumber.domain.SerialNumber;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SerialNumberMapper {

    @Select("select * from serial_number")
    List<SerialNumber> selectAll();

    @Select("select * from serial_number where serial_number = #{serialNumber}")
    SerialNumber selectBySerialNumber(String serialNumber);

    @Insert("insert into serial_number (serial_number,name) values (#{serialNumber},#{name})")
    void insert(SerialNumber serialNumber);

//    @Update("update serial_number set ")

    @Delete("delete from serial_number where serial_number= #{serialNumber}")
    void delete(String serialNumber);

}
