package com.example.springbootdockermemorydemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MemoryController {

    private final AtomicLong idGenerator = new AtomicLong();
    private final ConcurrentHashMap<Long, byte[]> memoryMap = new ConcurrentHashMap<>();

    @GetMapping("/memory/take/{size}")
    public String takeMemory(@PathVariable long size) {
        // Generate a unique ID for this allocation
        long id = idGenerator.incrementAndGet();

        // Allocate memory
        byte[] memoryBlock = new byte[(int) size * 1024 * 1024];
        memoryMap.put(id, memoryBlock);

        return "Allocated " + size + " megabytes of memory with ID " + id;
    }

    @GetMapping("/memory/release/{id}")
    public String releaseMemory(@PathVariable  long id) {
        // Release memory associated with the given ID
        byte[] removed = memoryMap.remove(id);
        if (removed != null) {
            return "Released memory with ID " + id;
        } else {
            return "No memory block found with ID " + id;
        }
    }
}
