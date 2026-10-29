#!/bin/bash
# System monitoring report - Zhansaya Kalymova
STUDENT="Zhansaya Kalymova"
BASE_DIR="$(cd "$(dirname "$0")/.." && pwd)"
LOG_FILE="$BASE_DIR/logs/Kalymova_Zhansaya_system_report.log"

{
    echo "========== SYSTEM REPORT =========="
    echo "Student:        $STUDENT"
    echo "Date and time:  $(date '+%Y-%m-%d %H:%M:%S')"
    echo "Username:       $(whoami)"
    echo "OS:             $(grep PRETTY_NAME /etc/os-release | cut -d= -f2 | tr -d '\"')"
    echo "Kernel:         $(uname -r)"
    echo "---------- CPU ----------"
    lscpu | grep -E 'Model name|^CPU\(s\)'
    echo "---------- Memory ----------"
    free -h
    echo "---------- Disk usage ----------"
    df -h /
    echo "Available disk space on /: $(df -h / | awk 'NR==2 {print $4}')"
    echo "Report finished for $STUDENT"
    echo
} | tee -a "$LOG_FILE"
