# Log Analysis Lab

## Objective

This lab focused on analyzing and extracting key information from web server access logs using a combination of Unix command-line tools, regular expressions, and CyberChef. The objective was to efficiently identify IP addresses, analyze HTTP responses, detect anomalies, and decode hidden data within logs. This hands-on exercise built practical experience in log triage, text parsing, and early-stage threat investigation techniques.

### Skills Learned

- Practical use of Unix command-line tools to inspect and follow logs in real time.
- Extracting, sorting, and counting IP addresses to identify high-volume clients and potential scanners.
- Filtering by HTTP response codes and specific URLs to find errors and targeted access attempts.
- Applying regular expressions to extract structured fields from unstructured log lines.
- Using CyberChef to decode, transform, and extract hidden artifacts (e.g., MAC addresses) from encoded payloads.

### Tools Used

- **Unix command-line tools**: awk, grep, cut, sort, uniq, wc, and sed for log filtering, extraction, and analysis.
- **RegExr** for testing and validating regular expression patterns before deployment.
- **CyberChef** for decoding, transforming, and extracting structured or hidden data from log files.
  
## Section 1: Command Line Log Analysis

### Objective
Leverage Unix command-line utilities to sort, filter, and analyze web server logs for insight into activity patterns and errors.

### Steps
#### 1. Inspect and follow logs in real time:
<img width="750" height="372" alt="image" src="https://github.com/user-attachments/assets/ff410208-7b21-459c-849c-bb1714306f55" />  

- Displayed the last five entries and followed new incoming logs live.

#### 2. Display file statistics:
<img width="573" height="43" alt="image" src="https://github.com/user-attachments/assets/657120b9-cd7d-4851-a733-e75edabd918d" /> 

-  file contains 70 lines, 1562 individual words (separated by whitespace), and 14305 individual characters.

#### 3. Extracting IP addresses
<img width="612" height="187" alt="image" src="https://github.com/user-attachments/assets/cd44c7cf-a1c7-47cb-bb7d-50c4e2331c65" />  

- Captured all IP addresses from the first field of each log entry.

#### 4. Sorting IPs:
<img width="727" height="242" alt="image" src="https://github.com/user-attachments/assets/dc1acc2b-4517-474d-af18-371b7e909882" />  

- Sorted IP addresses numerically, removing any duplicates, and visualizing amount of occurences per IP address to track addresses with unusually high traffic.

#### 5. Retrieving specific log entries
<img width="1198" height="66" alt="image" src="https://github.com/user-attachments/assets/be820d01-0e7e-40e5-ad1c-89351b25f497" />  

Found where IP 110.122.65.76 accessed the /login.php endpoint, indicating a potential brute-force attempt.

## Section 2: Regular Expressions (RegExr and Command Line) & CyberChef

### Objectives
Apply regular expressions (regex) to extract structured data and specific patterns from unstructured log entries.
Use CyberChef to decode, extract, and analyze structured or encoded data within log files.

### Steps
#### 1. Using extended regex in command line
- **grep -E 'post=1[0-9]' apache-ex.log** : Matched entries with post IDs 10–19 in the “post” database.
- **grep -oE '\b([0-9]{1,3}\.){3}[0-9]{1,3}\b' apache.log > regex_ips.txt** : Extracted all IPv4 addresses directly from raw log entries.
#### 2. Extracting log files for CyberChef
<img width="631" height="248" alt="image" src="https://github.com/user-attachments/assets/8a33af8a-cf64-42e5-8054-67589b08fd2b" /> 

#### 2. Extracting IP addresses in CyberChef with regex
- Unzipped and loaded the access log file into CyberChef.
<img width="631" height="248" alt="image" src="https://github.com/user-attachments/assets/8a33af8a-cf64-42e5-8054-67589b08fd2b" /> 

- Using regex pattern “**\b([0-9]{1,3}\.){3}[0-9]{1,3}\b**” to output a list of all IP addresses in extracted access log file
<img width="1918" height="775" alt="image" src="https://github.com/user-attachments/assets/9d3ecbff-0b02-403d-aac8-9588b0ff5f52" />

#### 3. Decoding encoded or encrypted data with CyberChef recipes
- Applied the ‘From Base64’ recipe to decode encrypted file contents, followed by the ‘Extract MAC Addresses’ recipe to generate a clean, structured list of decoded MAC addresses.
 <img width="1918" height="742" alt="image" src="https://github.com/user-attachments/assets/a9f06a29-7bb7-462e-b5c9-5ad7cade0942" />
 
## Outcome
This lab demonstrated a complete, multi-tool workflow for log analysis, combining the speed of Unix command-line tools, the precision of regular expressions, and the decoding power of CyberChef. By the end of this project, I was able to:
- Rapidly parse and aggregate large volumes of unstructured log data.
- Extract and correlate critical indicators such as IP addresses, HTTP errors, and suspicious activity.
- Decode and analyze hidden or encoded artifacts, enhancing visibility into potentially malicious behavior.
- Build a repeatable, efficient workflow suitable for real-world SOC operations and forensic investigations.

Overall, this lab reinforced practical skills in threat hunting, anomaly detection, and incident response, while demonstrating the ability to leverage multiple tools in a cohesive log analysis process. It provides a foundation for scalable, high-fidelity log monitoring and proactive cybersecurity investigation.
