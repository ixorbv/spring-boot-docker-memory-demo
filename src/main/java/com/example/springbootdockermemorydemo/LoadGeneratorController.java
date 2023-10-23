package com.example.springbootdockermemorydemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class LoadGeneratorController {

    @GetMapping("/generate-load/{megaByte}")
    public String generateLoad(@PathVariable int megaByte) throws InterruptedException {
        if (megaByte <= 0) {
            return "Invalid input. Please specify a positive integer for memory size.";
        }

        long bytesToAllocate = (long) megaByte * 1024 * 1024;
        byte[] memoryConsumption = new byte[(int) bytesToAllocate];
        Thread.sleep(TimeUnit.MINUTES.toMillis(1));
        return "Generated " + megaByte + " MB of memory.";
    }
}
