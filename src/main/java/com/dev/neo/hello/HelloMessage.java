package com.dev.neo.hello;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

public class HelloMessage {
    private String name;
    private String computernameInfo;
    private String processornameInfo;
    private String ipaddressInfo;
    private String currentUserInfo;
	private long physicalMemoryInfo;
	private long freephysicalMemoryInfo;
	private double freephysicalMemoryPercentageInfo;
	private long cDriveCapacityInfo;
	private long cfreePartitionSpaceInfo;
	private long dDriveCapacityInfo;
	private long dfreePartitionSpaceInfo;
	private long eDriveCapacityInfo;
	private long efreePartitionSpaceInfo;
	private int cpuUsageInfo;
	private float currentTemperatureInfo;
	private Date date;

    public HelloMessage() {
    }

    public HelloMessage(String name,String computernameInfo,String processornameInfo,String ipaddressInfo,String currentUserInfo,long physicalMemoryInfo,long freephysicalMemoryInfo,double freephysicalMemoryPercentageInfo,long cDriveCapacityInfo,
    		long cfreePartitionSpaceInfo,long dDriveCapacityInfo,long dfreePartitionSpaceInfo,long eDriveCapacityInfo,long efreePartitionSpaceInfo,int cpuUsageInfo,float currentTemperatureInfo,Date date) 
    {
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public String getComputernameInfo() throws UnknownHostException {
		computernameInfo=InetAddress.getLocalHost().getHostName();
		return computernameInfo;
	}

	public void setComputernameInfo(String computernameInfo) {
		this.computernameInfo = computernameInfo;
	}
	
	public String getProcessornameInfo() throws IOException {
		String command = "powershell.exe  Get-WmiObject win32_processor | select -Expandproperty Name";
		Process powerShellProcess = Runtime.getRuntime().exec(command);
		powerShellProcess.getOutputStream().close();
		String processornameInfo;
		InputStreamReader input = new InputStreamReader(powerShellProcess.getInputStream());
		BufferedReader stdout = new BufferedReader(input);
		processornameInfo = stdout.readLine();
		stdout.close();
		return processornameInfo;
	}

	public void setProcessornameInfo(String processornameInfo) {
		this.processornameInfo = processornameInfo;
	}

	public String getIpaddressInfo() throws IOException {
		String command = "powershell.exe  Get-WmiObject Win32_NetworkAdapterConfiguration | Where-Object { $_.IPAddress -ne $Null } | Select-Object -ExpandProperty IPAddress";
		Process powerShellProcess = Runtime.getRuntime().exec(command);
		powerShellProcess.getOutputStream().close();
		String ipaddressInfo;
		InputStreamReader input = new InputStreamReader(powerShellProcess.getInputStream());
		BufferedReader stdout = new BufferedReader(input);
		ipaddressInfo = stdout.readLine();
		stdout.close();
		return ipaddressInfo;
	}

	public void setIpaddressInfo(String ipaddressInfo) {
		this.ipaddressInfo = ipaddressInfo;
	}

	public String getCurrentUserInfo() {
		com.sun.security.auth.module.NTSystem NTSystem = new com.sun.security.auth.module.NTSystem();
		String currentUserInfo = NTSystem.getName();
		return currentUserInfo;
	}

	public void setCurrentUserInfo(String currentUserInfo) {
		this.currentUserInfo = currentUserInfo;
	}

	int mb = 1024*1024;
    int gb = 1024*1024*1024;
    com.sun.management.OperatingSystemMXBean operatingSystemMXBean = (com.sun.management.OperatingSystemMXBean)ManagementFactory.getOperatingSystemMXBean();
    com.sun.management.OperatingSystemMXBean os = (com.sun.management.OperatingSystemMXBean)	
    java.lang.management.ManagementFactory.getOperatingSystemMXBean();
    
	public long getPhysicalMemoryInfo() {
	    long physicalMemorySize = os.getTotalPhysicalMemorySize();
	    long physicalMemoryInfo=physicalMemorySize / mb;
		return physicalMemoryInfo;
	}

	public void setPhysicalMemoryInfo(long physicalMemoryInfo) {
		this.physicalMemoryInfo = physicalMemoryInfo;
	}

	public long getFreephysicalMemoryInfo() {
		long physicalfreeMemorySize = os.getFreePhysicalMemorySize();
	    long freephysicalMemoryInfo=physicalfreeMemorySize / mb;
		return freephysicalMemoryInfo;
	}

	public void setFreephysicalMemoryInfo(long freephysicalMemoryInfo) {
		this.freephysicalMemoryInfo = freephysicalMemoryInfo;
	}

	public double getFreephysicalMemoryPercentageInfo() {
		double freephysicalMemoryPercentageInfo = getFreephysicalMemoryInfo() * 100 / getPhysicalMemoryInfo() ;
		return freephysicalMemoryPercentageInfo;
	}

	public void setFreephysicalMemoryPercentageInfo(double freephysicalMemoryPercentageInfo) {
		this.freephysicalMemoryPercentageInfo = freephysicalMemoryPercentageInfo;
	}

	File diskPartition = new File("C:");
	File diskPartition1 = new File("D:");
    File diskPartition2 = new File("E:");
    
	public long getcDriveCapacityInfo() {
	    long cDriveCapacityInfo = diskPartition.getTotalSpace() / gb;
		return cDriveCapacityInfo;
	}

	public void setcDriveCapacityInfo(long cDriveCapacityInfo) {
		this.cDriveCapacityInfo = cDriveCapacityInfo;
	}

	public double getCfreePartitionSpaceInfo() {
		double cfreePartitionSpaceInfo = diskPartition.getFreeSpace() / gb;
		return cfreePartitionSpaceInfo;
	}

	public void setCfreePartitionSpaceInfo(long cfreePartitionSpaceInfo) {
		this.cfreePartitionSpaceInfo = cfreePartitionSpaceInfo;
	}

	public long getdDriveCapacityInfo() {
	    long dDriveCapacityInfo = diskPartition1.getTotalSpace() / gb;
		return dDriveCapacityInfo;
	}

	public void setdDriveCapacityInfo(long dDriveCapacityInfo) {
		this.dDriveCapacityInfo = dDriveCapacityInfo;
	}

	public double getDfreePartitionSpaceInfo() {
		 double dfreePartitionSpaceInfo = diskPartition1.getFreeSpace() / gb;
		return dfreePartitionSpaceInfo;
	}

	public void setDfreePartitionSpaceInfo(long dfreePartitionSpaceInfo) {
		this.dfreePartitionSpaceInfo = dfreePartitionSpaceInfo;
	}

	public long geteDriveCapacityInfo() {
		long eDriveCapacityInfo = diskPartition2.getTotalSpace() / gb;
		return eDriveCapacityInfo;
	}

	public void seteDriveCapacityInfo(long eDriveCapacityInfo) {
		this.eDriveCapacityInfo = eDriveCapacityInfo;
	}

	public double getEfreePartitionSpaceInfo() {
		double efreePartitionSpaceInfo = diskPartition2.getFreeSpace() / gb;
		return efreePartitionSpaceInfo;
	}

	public void setEfreePartitionSpaceInfo(long efreePartitionSpaceInfo) {
		this.efreePartitionSpaceInfo = efreePartitionSpaceInfo;
	}

	public int getCpuUsageInfo() throws IOException {
		String command = "powershell.exe  Get-WmiObject win32_processor | select -expand LoadPercentage";
		Process powerShellProcess = Runtime.getRuntime().exec(command);
		powerShellProcess.getOutputStream().close();
		String cpuUsage;
		InputStreamReader input = new InputStreamReader(powerShellProcess.getInputStream());
		BufferedReader stdout = new BufferedReader(input);
		cpuUsage = stdout.readLine();
		int cpuUsageInfo = Integer.parseInt(cpuUsage);
		stdout.close();
		return cpuUsageInfo;
	}

	public void setCpuUsageInfo(int cpuUsageInfo) throws IOException {
		this.cpuUsageInfo = cpuUsageInfo;
	}

	public float getCurrentTemperatureInfo() throws IOException {
//		String command = "powershell.exe get-wmiobject MSAcpi_ThermalZoneTemperature -namespace 'root/wmi' | select -Expandproperty currentTemperature";
//		Process powerShellProcess = Runtime.getRuntime().exec(command);
//		powerShellProcess.getOutputStream().close();
//		String currentTemperatureinKelvin;
//		InputStreamReader input = new InputStreamReader(powerShellProcess.getInputStream());
//		BufferedReader stdout = new BufferedReader(input);
//		currentTemperatureinKelvin = stdout.readLine();
//		float currentTemperatureinKelvinInfo = Float.parseFloat(currentTemperatureinKelvin);
//		stdout.close();
//		currentTemperatureInfo = (float) ((currentTemperatureinKelvinInfo / 10) - 273.15);
		currentTemperatureInfo = 0;
		return currentTemperatureInfo;
	}

	public void setCurrentTemperatureInfo(float currentTemperatureInfo) {
		this.currentTemperatureInfo = currentTemperatureInfo;
	}
	
	 public Date getDate() {
		 Date date= new Date();
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
