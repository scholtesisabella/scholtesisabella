# Log Collection Lab

## Objective

The Rsyslog lab project aimed to implement a scalable and high-performance log collection and management system on Linux. The primary focus was to segregate SSH logs from general system logs, automate log rotation with verification, and consolidate logs from multiple sources for streamlined analysis. This hands-on project deepened understanding of Linux logging, log management best practices, and preliminary SIEM integration techniques in cybersecurity operations.

### Skills Learned

- Advanced expertise in log aggregation, segregation, and high-throughput processing using Rsyslog, including secure log management and Linux system logging practices.
- Proficiency in automating log rotation, compression, and integrity verification with Logrotate, ensuring retention, tamper-evidence, and operational continuity.
- Skilled in parsing, normalizing, and consolidating unstructured log data using Unix command-line tools (awk, sed, grep, sort) and applying analytical methods to detect anomalies and potential security incidents.

### Tools Used

- **Rsyslog** for directing and segregating logs into dedicated files.
- **Logrotate** for automated log rotation, compression, and hash verification.
- Unix command-line tools: awk, sed, grep, sort, uniq, sha256sum for log parsing and consolidation.
- **Systemctl** for managing the Rsyslog service.
- Browser-based **LogViewer** for immediate log inspection.

## Steps
Full path to log file : /var/;pg/gitlab/nginx/access.log
- access.log inspection (logs are in Unstructured NCSA Combined Log Format (Combined))
<img width="741" height="162" alt="image" src="https://github.com/user-attachments/assets/bd7ea8cb-b1e4-458e-9864-2ae33b0db99d" />

### 1. Rsyslog Installation and Configuration
- Verified Rsyslog installation on Linux:
<img width="656" height="257" alt="image" src="https://github.com/user-attachments/assets/76ce54c7-b5f3-42db-9d44-7393a49b5f72" />

- Created /etc/rsyslog.d/98-websrv-02-sshd.conf to route all SSH logs to /var/log/websrv-02/rsyslog_sshd.log and ensured properly set directory permissions for secure logging.
<img width="546" height="58" alt="image" src="https://github.com/user-attachments/assets/3c00cdbb-93e8-4463-8ff5-3c7c817bfa71" />

- Restarted Rsyslog and confirmed configuration using systemctl and live log testing
  <img width="972" height="431" alt="image" src="https://github.com/user-attachments/assets/457d5c06-d834-42db-88ee-fb2029e146a0" />
  Resulting rsyslog_sshd.log file:
  <img width="1807" height="281" alt="image" src="https://github.com/user-attachments/assets/82ce35dd-ecb4-4626-9135-6c55687025f4" />
  - We can see multiple failed login/brite force attempts from user "stansimon"

### 2. Logrotate Configuration
- Created /etc/logrotate.d/98-websrv-02_sshd.conf to automate log rotation and compression using command **sudo vim /etc/logrotate.d/98-websrv-02_sshd.conf**.
- Defined log settings:
  
  <img width="456" height="372" alt="image" src="https://github.com/user-attachments/assets/23cd45ad-7f61-40c4-af6e-d2d972fdb1b4" />

  - 24 versions of of old compressed log file copies will be kept
  - log rotation frequency = hourly, retention = 30 rotations
    
### 3. Log Parsing and Consolidation
- Developed scripts to normalize and consolidate logs from multiple sources (access.log, rsyslog_cron.log, rsyslog_sshd.log, and api_json.log) into a single timeline.
- Utilized awk, sed, grep, and sort to filter, timestamp, and de-duplicate log entries.
  -awk -F'[][]' '{print "[" $2 "]", "--- /var/log/gitlab/nginx/access.log ---", "\"" $0 "\""}' /var/log/gitlab/nginx/access.log  | sed "s/ +0000//g" > /tmp/parsed_consolidated.log
  - **Process rsyslog_cron.log** : awk '{ original_line = $0; gsub(/ /, "/", $1); printf "[%s/%s/2023:%s] --- /var/log/websrv-02/rsyslog_cron.log --- \"%s\"\n", $2, $1, $3, original_line }' /var/log/websrv-02/rsyslog_cron.log >> /tmp/parsed_consolidated.log
  - **Process rsyslog_sshd.log** :
awk '{ original_line = $0; gsub(/ /, "/", $1); printf "[%s/%s/2023:%s] --- /var/log/websrv-02/rsyslog_sshd.log --- \"%s\"\n", $2, $1, $3, original_line }' /var/log/websrv-02/rsyslog_sshd.log >> /tmp/parsed_consolidated.log
  - **Process gitlab-rails/api_json.log** : 
awk -F'"' '{timestamp = $4; converted = strftime("[%d/%b/%Y:%H:%M:%S]", mktime(substr(timestamp, 1, 4) " " substr(timestamp, 6, 2) " " substr(timestamp, 9, 2) " " substr(timestamp, 12, 2) " " **substr(timestamp, 15, 2) " " substr(timestamp, 18, 2) " 0 0")); print converted, "--- /var/log/gitlab/gitlab-rails/api_json.log ---", "\""$0"\""}' /var/log/gitlab/gitlab-rails/api_json.log >> /tmp/parsed_consolidated.log
  - **Filtering specific entries** : grep "34.253.159.159" /tmp/parsed_consolidated.log > /tmp/filtered_consolidated.log 
  - **Sorting log entries by date and time** :
sort /tmp/parsed_consolidated.log > /tmp/sort_parsed_consolidated.log
  - **removing duplicate entries** : 
sort /tmp/parsed_consolidated.log > /tmp/sort_parsed_consolidated.log

## Outcome
- Unparsed raw data logs from LogViewer in browser (http://10.201.40.239:8111/log?log=%2Fvar%2Flog%2Fgitlab%2Fnginx%2Faccess.log&log=%2Fvar%2Flog%2Fwebsrv-02%2Frsyslog_cron.log&log=%2Fvar%2Flog%2Fwebsrv-02%2Frsyslog_sshd.log&log=%2Fvar%2Flog%2Fgitlab%2Fgitlab-rails%2Fapi_json.log)
  <img width="1810" height="626" alt="image" src="https://github.com/user-attachments/assets/daf981db-f0f3-435d-8eb6-77fa01105494" />
  
- Parsed/consolidated logs using Unix tools (http://10.201.40.239:8111/log?path=%2Ftmp%2Funiq_sort_parsed_consolidated.log):
    <img width="1823" height="685" alt="image" src="https://github.com/user-attachments/assets/0882d6af-47e6-4b8e-8187-b1a94c351942" />
  - Observed multiple failed SSH login attempts and suspicious cron job activity indicating potential compromise.
  - Validated log rotation and hash verification for integrity of historical log files.
