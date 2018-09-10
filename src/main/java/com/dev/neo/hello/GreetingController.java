package com.dev.neo.hello;

import java.util.Timer;
import java.util.TimerTask;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController extends TimerTask{

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
    	return new Greeting(message.getName(),
    			message.getComputernameInfo(),
    			message.getProcessornameInfo(),
    			message.getIpaddressInfo(),
    			message.getCurrentUserInfo(),
    			message.getPhysicalMemoryInfo(),
    			message.getFreephysicalMemoryInfo(),
    			message.getFreephysicalMemoryPercentageInfo(),
    			message.getcDriveCapacityInfo(),
    			message.getCfreePartitionSpaceInfo(),
    			message.getdDriveCapacityInfo(),
    			message.getDfreePartitionSpaceInfo(),
    			message.geteDriveCapacityInfo(),
    			message.getEfreePartitionSpaceInfo(),
    			message.getCpuUsageInfo(),
    			message.getCurrentTemperatureInfo(),
    			message.getDate()
    			);
    }

	@Override
	public void run() {
		Timer timer = new Timer();
		timer.schedule(new GreetingController(), 0, 1000);
	}
}
