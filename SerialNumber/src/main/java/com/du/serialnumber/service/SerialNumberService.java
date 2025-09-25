package com.du.serialnumber.service;


import com.du.serialnumber.domain.SerialNumber;
import com.du.serialnumber.mapper.SerialNumberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SerialNumberService {

    private final SerialNumberMapper serialNumberMapper;

    public List<SerialNumber> selectAll() {
        return serialNumberMapper.selectAll();
    }

    public SerialNumber selectBySerialNumber(String serialNumber) {
        return serialNumberMapper.selectBySerialNumber(serialNumber);
    }

    public void insert(String name) {
        SerialGenerator sg = new SerialGenerator();
        String serialNumber = sg.generate8();
        if(selectBySerialNumber(serialNumber)==null){

        }

        SerialNumber sn = new SerialNumber();
        sn.setSerialNumber(serialNumber);
        sn.setName(name);
        sn.setDate(null);
        serialNumberMapper.insert(sn);
    }

    public void update(SerialNumber serialNumber) {

    }

    public void delete(String serialNumber) {
        serialNumberMapper.delete(serialNumber);
    }



}
