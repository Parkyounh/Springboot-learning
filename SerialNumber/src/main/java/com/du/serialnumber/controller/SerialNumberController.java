package com.du.serialnumber.controller;

import com.du.serialnumber.service.SerialNumberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class SerialNumberController {

    private final SerialNumberService serialNumberService;

    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("list",  serialNumberService.selectAll());
        return "list";
    }

    @PostMapping("/new")
    public String insert(String name) {
        serialNumberService.insert(name);
        return "redirect:/";
    }

    @GetMapping("/detail/{serialNumber}")
    public String detail(@PathVariable("serialNumber") String serialNumber, Model model) {
        model.addAttribute("one", serialNumberService.selectBySerialNumber(serialNumber));
        return "detail";
    }

    @PostMapping("/delete")
    public String delte(@RequestParam("serialNumber") String serialNumber) {
        serialNumberService.delete(serialNumber);
        return "redirect:/";
    }
}
