package com.du.serialnumber.domain;

import lombok.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class SerialNumber {
    private String serialNumber;
    private String name;
    private Date date;

}
