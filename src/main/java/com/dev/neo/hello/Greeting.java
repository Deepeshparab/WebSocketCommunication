package com.dev.neo.hello;

import java.util.Date;

public class Greeting {
	private String content;
    private String computernameInfo;
    private String processornameInfo;
    private String ipaddressInfo;
    private String currentUserInfo;
	private long physicalMemoryInfo;
	private long freephysicalMemoryInfo;
	private double freephysicalMemoryPercentageInfo;
	private long cDriveCapacityInfo;
	private double cfreePartitionSpaceInfo;
	private long dDriveCapacityInfo;
	private double dfreePartitionSpaceInfo;
	private long eDriveCapacityInfo;
	private double efreePartitionSpaceInfo;
	private int cpuUsageInfo;
	private float currentTemperatureInfo;
	private Date date;
    
    public Greeting() {
    }

    public Greeting(String content,String computernameInfo,String processornameInfo,String ipaddressInfo,String currentUserInfo,long physicalMemoryInfo,long freephysicalMemoryInfo,double freephysicalMemoryPercentageInfo,long cDriveCapacityInfo,
    		double cfreePartitionSpaceInfo,long dDriveCapacityInfo,double dfreePartitionSpaceInfo,long eDriveCapacityInfo,double efreePartitionSpaceInfo,int cpuUsageInfo,float currentTemperatureInfo,Date date) {
        this.content = content;
        this.computernameInfo = computernameInfo;
        this.processornameInfo = processornameInfo;
        this.ipaddressInfo = ipaddressInfo;
        this.currentUserInfo = currentUserInfo;
        this.physicalMemoryInfo = physicalMemoryInfo;
        this.freephysicalMemoryInfo = freephysicalMemoryInfo;
        this.freephysicalMemoryPercentageInfo = freephysicalMemoryPercentageInfo;
        this.cDriveCapacityInfo = cDriveCapacityInfo;
        this.cfreePartitionSpaceInfo = cfreePartitionSpaceInfo;
        this.dDriveCapacityInfo = dDriveCapacityInfo;
        this.dfreePartitionSpaceInfo = dfreePartitionSpaceInfo;
        this.eDriveCapacityInfo = eDriveCapacityInfo;
        this.efreePartitionSpaceInfo = efreePartitionSpaceInfo;
        this.cpuUsageInfo = cpuUsageInfo;
        this.currentTemperatureInfo = currentTemperatureInfo;
        this.date = date;
    }

    public String getContent() {
        return content;
    }

	public String getComputernameInfo() {
		return computernameInfo;
	}
	
	public String getProcessornameInfo() {
		return processornameInfo;
	}

	public String getIpaddressInfo() {
		return ipaddressInfo;
	}

	public String getCurrentUserInfo() {
		return currentUserInfo;
	}

	public long getPhysicalMemoryInfo() {
		return physicalMemoryInfo;
	}

	public long getFreephysicalMemoryInfo() {
		return freephysicalMemoryInfo;
	}

	public double getFreephysicalMemoryPercentageInfo() {
		return freephysicalMemoryPercentageInfo;
	}

	public long getcDriveCapacityInfo() {
		return cDriveCapacityInfo;
	}

	public double getCfreePartitionSpaceInfo() {
		return cfreePartitionSpaceInfo;
	}

	public long getdDriveCapacityInfo() {
		return dDriveCapacityInfo;
	}

	public double getDfreePartitionSpaceInfo() {
		return dfreePartitionSpaceInfo;
	}

	public long geteDriveCapacityInfo() {
		return eDriveCapacityInfo;
	}

	public double getEfreePartitionSpaceInfo() {
		return efreePartitionSpaceInfo;
	}

	public int getCpuUsageInfo() {
		return cpuUsageInfo;
	}
	
	public float getCurrentTemperatureInfo() {
		return currentTemperatureInfo;
	}
	
	public Date getDate() {
		return date;
	}
}

