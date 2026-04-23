package com.example.mcpserver;

import com.ethlo.time.DateTime;
import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class generalTools {
    @McpTool(name = "getCurrentTime", description = "return the current time")
    public LocalDateTime getCurrentTime(){
        return LocalDateTime.now();
    }
}
