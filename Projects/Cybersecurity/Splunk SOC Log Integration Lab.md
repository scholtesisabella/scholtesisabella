# Splunk SOC Log Integration Lab

## Objective

The **Splunk SOC Log Integration Lab** focused on deploying **Splunk Enterprise** on both Linux and Windows virtual machines and configuring them as data sources that forward logs into a centralized **Splunk SIEM**. The goal was to understand the end-to-end process of data ingestion, index management, and log forwarding using Splunk Universal Forwarders. This project strengthened practical knowledge in SIEM architecture, endpoint integration, and multi-platform log management for security monitoring.

### Skills Learned

- Expertise in installing, configuring, and managing **Splunk Enterprise** across Linux and Windows environments.  
- Hands-on experience deploying and integrating **Splunk Universal Forwarders** for secure, real-time data forwarding.  
- Configuring **inputs, outputs, and indexes** for log routing, filtering, and storage optimization.  
- Collecting and monitoring **Windows Event Logs**, **user activity logs**, and **web server logs (IIS)** for comprehensive endpoint visibility.  

### Tools Used

- **Splunk Enterprise** (SIEM Platform)  
- **Splunk Universal Forwarder** (Linux & Windows agents)  
- **Ubuntu Server** for Linux log forwarding  
- **Windows Server** for Event Log and IIS Web Log forwarding  
- **Syslog**, **Windows Event Viewer**, and **logger utility** for log generation and verification  


## Linux VM Configuration

### Steps
#### 1. Installing Splunk Enterprise on Ubuntu Server
Verified and installed Splunk Enterprise on the Linux VM.  
<img width="426" height="285" alt="image" src="https://github.com/user-attachments/assets/22fbc6c3-a312-4965-99f0-3fa693cc4d9a" />


#### 2. Moving and Starting Splunk
Moved Splunk binaries to the `/opt/splunk` directory and started the Splunk service.  
<img width="603" height="79" alt="image" src="https://github.com/user-attachments/assets/87579f65-81eb-4ecb-8fc2-f77d60216887" />


#### 3. Configuring Data Ingestion
Downloaded and installed the **Splunk Universal Forwarder** on the Linux endpoint.  
<img width="557" height="74" alt="image" src="https://github.com/user-attachments/assets/3a491b03-7c55-4080-b583-994984d3664a" />


#### 4. Installing and Moving Forwarder Files
Extracted and moved `splunkforwarder` files to `/opt/` directory.  
<img width="797" height="72" alt="image" src="https://github.com/user-attachments/assets/cfc5f442-99c4-4d79-991a-779449f9fe9f" />


#### 5. Defining the Forward Server
Configured the Universal Forwarder to send logs to the Splunk Indexer on **port 9997**.  
<img width="1075" height="33" alt="Screenshot 2025-10-21 105910" src="https://github.com/user-attachments/assets/a6c95754-3b8c-43b8-856f-c924cbeec6c8" />

Verified that Splunk Enterprise was set to listen on TCP **9997**.  
<img width="618" height="522" alt="image" src="https://github.com/user-attachments/assets/58b3f1c7-8ed5-4efb-a71b-53abee121ca6" />


#### 6. Index Creation
Created a dedicated index to store Linux syslog data.  
<img width="309" height="174" alt="image" src="https://github.com/user-attachments/assets/ad1671da-e747-4fbf-9de4-3a0b48d94036" />


#### 7. Configuring Forwarder Monitoring
Added the Linux host as a forwarder to Splunk and configured it to monitor `/var/log/syslog` and store the data in "Linux_host" index.  
<img width="664" height="173" alt="image" src="https://github.com/user-attachments/assets/f273ced3-62a3-4a2a-9425-872b252273bb" />


#### 8. Testing Data Flow
Confirmed correct forwarding configuration and active connection between the forwarder and Splunk Indexer.  
<img width="681" height="93" alt="image" src="https://github.com/user-attachments/assets/5160af5d-d25b-497e-b9eb-8933cd82aa66" />

Generated a test log using the **logger** command and verified ingestion in Splunk.  
<img width="748" height="71" alt="image" src="https://github.com/user-attachments/assets/5af8c7c1-ed92-4397-ac0e-4e5956e40a02" />

Verified indexed log data:  
<img width="755" height="469" alt="image" src="https://github.com/user-attachments/assets/51166fdd-eb3b-4ba2-896d-e3f54dcbacd1" />


#### 9. User Management
Created a new Splunk user and confirmed system log updates in `/etc/group`.  
<img width="308" height="439" alt="image" src="https://github.com/user-attachments/assets/944ae87b-0254-45f5-af17-3faf42381514" />

<img width="915" height="708" alt="image" src="https://github.com/user-attachments/assets/88547558-1455-43f9-9b2c-c292ecc6e68e" />


## Windows VM Configuration

### Steps
#### 1. Installing Splunk Enterprise
Installed Splunk on Windows Server and configured the **admin** account.  
<img width="525" height="366" alt="image" src="https://github.com/user-attachments/assets/e4710a17-f0d2-4405-b564-adc9a482bd36" />

<img width="454" height="472" alt="image" src="https://github.com/user-attachments/assets/94277beb-df3f-4639-bbda-3c3fc4f870a9" />


#### 2. Enabling the Receiver
Enabled the **Splunk listener** on TCP port **9997** to accept data from Universal Forwarders. 

<img width="367" height="338" alt="image" src="https://github.com/user-attachments/assets/7ab8341a-776f-4d3a-9c45-6bfccdbe0c51" />


#### 3. Installing and Configuring the Universal Forwarder
Installed Splunk Universal Forwarder on the Windows endpoint.  
<img width="525" height="366" alt="image" src="https://github.com/user-attachments/assets/73853c2b-2d65-405d-92cb-b855c1cf61a7" />

Configured the receiver IP and port for forwarding to the Splunk Indexer.  
<img width="367" height="338" alt="image" src="https://github.com/user-attachments/assets/42f8805c-412e-4a01-a484-ac77bbf9c3e5" />

<img width="474" height="521" alt="image" src="https://github.com/user-attachments/assets/29059901-96cc-4576-99fe-1ff754923f97" />


Linked the forwarder to a **deployment server** for remote configuration management.  
<img width="840" height="153" alt="image" src="https://github.com/user-attachments/assets/3ffdac33-b0d1-497e-93de-d0d3af186de3" />


#### 4. Forwarding Windows Event Logs
Added **Windows Event Logs** (Application, Security, System) as data sources.  
<img width="572" height="580" alt="image" src="https://github.com/user-attachments/assets/c59e74fe-1772-4582-96d2-f7a2e2a53570" />
  
Selected **specific event channels** for monitoring critical user and system activities.  
<img width="560" height="496" alt="image" src="https://github.com/user-attachments/assets/7e56a5c1-eb40-4fb8-8bfb-9971c9aab670" />
 
Created a dedicated index (`win_logs`) for Windows event data.  
<img width="597" height="296" alt="image" src="https://github.com/user-attachments/assets/b37595fd-f23d-44d4-8a00-ad71b66805fa" />
 
Verified event ingestion and reviewed real-time dashboard updates.  
<img width="728" height="853" alt="image" src="https://github.com/user-attachments/assets/5a85dec6-d483-47e6-b984-540757e0941d" />


## Outcome

- Successfully deployed **Splunk Enterprise** and configured **Linux and Windows Universal Forwarders** for multi-source log ingestion.  
- Verified connectivity, data flow, and indexing on both platforms.  
- Collected and visualized **system**, **security**, and **web application logs** in Splunk dashboards.  
- Achieved a functional multi-platform SIEM environment, demonstrating real-world skills in **log management**, **data normalization**, and **endpoint integration**.
  
Overall, completing this lab demonstrated the end-to-end process of configuring and integrating Linux and Windows systems into a centralized Splunk environment for security monitoring.
