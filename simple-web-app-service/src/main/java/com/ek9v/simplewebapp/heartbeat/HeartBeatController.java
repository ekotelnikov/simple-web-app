package com.ek9v.simplewebapp.heartbeat;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.management.ManagementFactory;
import java.time.Duration;

@RestController
public class HeartBeatController {

    @RequestMapping("/v1/heartbeat")
    public String heartbeat() {
        Duration uptime = Duration.ofMillis(ManagementFactory.getRuntimeMXBean().getUptime());
        long days = uptime.toDays();
        long hours = uptime.minusDays(days).toHours();
        long minutes = uptime.minusDays(days).minusHours(hours).toMinutes();
        long seconds = uptime.minusDays(days).minusHours(hours).minusMinutes(minutes).toMillis() / 1000;
        return String.format("Application is up and running %dd %02dh %02dm %02ds", days, hours, minutes, seconds);
    }
}
