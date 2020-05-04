package org.weijie.playspringrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.weijie.playspringrest.model.Time;
import org.weijie.playspringrest.service.TimezoneService;

import java.util.Set;

@RestController
@RequestMapping(path = "/timezone")
public class TimezoneController
{
    @Autowired
    TimezoneService service;

    @GetMapping("/show")
    public Time getTime(@RequestParam String timezone)
    {
        return service.convertTime(timezone);
    }

    @GetMapping("/all")
    public Set<String> getAllTimezones()
    {
        return service.listAllTimezone();
    }
}
