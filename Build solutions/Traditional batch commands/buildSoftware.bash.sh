#!/bin/bash
# 前一行為 shebang ，用來指定執行此腳本(script)程式的直譯器（如此例為 GNU bash 殼程式直譯器）
# 以井字符號(#)開頭但非 shebang 的文字列是不會被執行的註解文字

# buildSoftware.bash.sh - 軟體建構程式
# 此程式會建構本軟體
# 使用方式：
# 	在命令列介面中切換當前工作目錄(current working directory)到本軟體建構解決方案根目錄下，然後執行下列命令：
# 	$ bash buildSoftware.bash.sh

global_project_root_directory=../..

# 啟用 bash 殼程式直譯器的偵錯功能，方便看到腳本程式呼叫了什麼命令
set -x

# 呼叫 Java 編譯器(javac)將 Java 來源程式碼編譯為 Java 虛擬機器能載入執行的 bytecode
# FIXME: 用於 -classpath 參數的路徑分隔符（半形冒號(:)）目前僅相容類 Unix 作業系統，Microsoft Windows 上需手動改為半形分號(;)）
javac -classpath "${global_project_root_directory}/Source code":"${global_project_root_directory}/Libraries/org.json.jar" -d "Built software/" "${global_project_root_directory}/Source code/tw/edu/ntou/cs/java_programming/semester1031/team13/youtube_dl_helper/MainProgram.java" "${global_project_root_directory}/Source code/tw/edu/ntou/cs/java_programming/semester1031/team13/youtube_dl_helper/GUI.java" "${global_project_root_directory}/Source code/tw/edu/ntou/cs/java_programming/semester1031/team13/youtube_dl_helper/YoutubeDlParser.java"

# 將 Java archive 複製到建構好的軟體目錄
cp --force --recursive "${global_project_root_directory}/Libraries" "Built software/"

# 打包軟體
# FIXME: 此步驟會包進實際上無法使用到的 org.json Java archive
jar vcfm "Packaged software/youtube-dl-helper.jar" "${global_project_root_directory}/Packaging data/Java archive/Java archive manifest.mf" -C "Built software/" .

# 將 Java archive 複製到打包好的軟體目錄
cp --force --recursive "${global_project_root_directory}/Libraries" "Packaged software/"

chmod a+x "Packaged software/youtube-dl-helper.jar"

# 回傳 0 結束狀態代碼， 0 代表正常結束程式
exit 0