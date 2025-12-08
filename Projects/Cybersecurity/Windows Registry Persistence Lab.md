# Windows Registry Persistence Investigation Lab

## Objective

The **Windows Registry Persistence Investigation Lab** focused on identifying, analyzing, and removing malicious persistence mechanisms established through **autorun Windows Registry keys**. The goal was to understand the end-to-end process of detecting unauthorized startup programs, verifying digital signatures, creating baselines, comparing snapshots, and safely remediating suspicious entries. This project strengthened practical knowledge in host-based malware detection, persistence hunting, PowerShell-based forensics, and system remediation.


### Skills Learned

- Hands-on experience examining **Windows Registry autorun locations** commonly used by malware to maintain persistence.  
- Using **AutoRuns PowerShell module** to inspect, validate, and remove malicious registry entries and associated payloads.  
- Identifying malicious registry values by analyzing **file paths, signatures, timestamps, and naming anomalies**.  
- Detecting persistence techniques involving **unsigned executables**, hidden directories, and masquerading behavior.  

### Tools Used

- **Autoruns PowerShell Module** (including `Get-PSAutorun`, `New-PSAutorunBaseline`, and signature validation functions) for detecting, baselining, and analyzing autorun persistence locations.  
- **Windows Registry Editor** for manually validating suspicious autorun keys and confirming persistence paths.
- **File Explorer** for navigating hidden directories and inspecting malicious executable payloads.  

## Linux VM Configuration

### Steps
#### 1. Manual Inspection of Autorun Registry Keys
Manually examined common registry locations in Registry Editor that attackers frequently use to force malicious executables to run at system startup or user logon. Found evidence of suspicious key labeled "(Default)".  
<img width="918" height="184" alt="image" src="https://github.com/user-attachments/assets/aa11acd7-9835-425a-a1d4-62bb24db6959" />


#### 2. Enumerating Autoruns with AutoRuns PowerShell Module
Loaded the **AutoRuns module** in PowerShell and listed all autorun entries using the command `Get-PSAutorun | Out-GridView`. This allowed me to inspect the entries more thoroughly and focus on suspicious programs that might not match legitimate software configurations.
<img width="1420" height="624" alt="image" src="https://github.com/user-attachments/assets/2da52c5d-feba-484e-9082-2c2564f378f7" />


#### 3. Filtering for Unsigned Autorun Entries 
This filtered the results to show only unsigned binaries, which are often indicative of malware. I cross-referenced the unsigned entries with previously identified suspicious registry keys and system directories. Any entry located in temporary or hidden folders was marked for further investigation.
<img width="1009" height="690" alt="image" src="https://github.com/user-attachments/assets/28a98b0c-5e6b-495e-81de-8e7bbd5ae283" />
With GridView:
<img width="1783" height="248" alt="image" src="https://github.com/user-attachments/assets/8dc4f43b-939a-455c-8855-692a1434b235" />

#### 4. Comparing Baseline with Post-Compromise Autoruns
Created current baseline which captured all current autorun entries, their paths, and metadata.
<img width="1545" height="163" alt="image" src="https://github.com/user-attachments/assets/f4402623-f0f7-4349-8c30-6ed97d8c74a2" />
<img width="1140" height="405" alt="image" src="https://github.com/user-attachments/assets/16d31b77-4be6-4e59-aa86-dfdec6763f0e" />

Compared current baseline with past “known-good” baselinethat would allow me to identify additions or modifications introduced by malicious activity.
<img width="1502" height="370" alt="image" src="https://github.com/user-attachments/assets/e24c9dea-2394-48ea-8101-3075f7b43805" />
This comparison highlighted entries that had been added or modified since the baseline, one of which matched the suspicious entry from my initial investigation.

#### 5. Removing the Malicious Autorun Entry
I verified that the corresponding executable file was deleted or quarantined and confirmed that the registry key no longer existed. 
<img width="1149" height="306" alt="image" src="https://github.com/user-attachments/assets/03371be0-8003-43e1-9c93-6250886ac3dc" />

After removal, I reran 'Get-PSAutorun' and filtered for unsigned binaries to ensure no additional malicious entries remained. I also monitored system startup to confirm that the persistence mechanism was fully disabled. This validated that the system returned to a clean state.


## Outcome

- Successfully identified and removed a **malicious autorun registry entry** that was maintaining persistence on the Windows host.  
- Verified the executable file was deleted or quarantined and confirmed the registry key no longer existed.  
- Created and compared **baseline snapshots** of autorun entries to accurately detect unauthorized changes.  
- Reconstructed the timeline of the malware’s persistence and applied remediation steps, demonstrating practical skills in **host-based malware analysis, persistence hunting, and PowerShell remediation**.
  
Overall, completing this lab demonstrated the end-to-end process of detecting, analyzing, and removing malware persistence via Windows Registry autorun keys, reinforcing real-world skills in **malware triage, system forensics, and incident response**.
