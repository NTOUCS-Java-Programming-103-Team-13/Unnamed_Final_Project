# Build solutions/Traditional batch commands/ 
這是「傳統批次命令」軟體建構解決方案的目錄

## 本軟體建構解決方案所依賴的軟體
### GNU Bash 殼程式

### GNU CoreUtils

## 如何用此軟體建構解決方案建構軟體
1. 開啟命令列介面，將當前工作目錄(current working directory)切換到  Build solutions/Traditional batch commands/  目錄底下
2. 執行下列命令：`$ bash buildSoftware.bash.sh`

## 如何執行建構出來的軟體
1. 開啟命令列介面，將當前工作目錄(current working directory)切換到 Built software/ 目錄底下
2. 執行下列命令：`java -classpath . tw.edu.ntou.cs.java_programming.semester1031.team13.youtube_dl_helper.MainProgram`

## 如何執行打包為 Java archive（副檔名為 jar）的軟體
直接開啟該檔案即可（類 Unix 作業系統有可能需要對該檔案加上可執行(executable)檔案權限才能順利執行）

## 本目錄下的項目說明
### [建構好的軟體/<br />Built software/](Built software/)
建構出來的軟體

### [打包好的軟體/<br />Packaged software](Packaged software/)
打包好的 Java archive 檔案

### [說明文件.md<br />README.md](README.md)
本說明文件

### [建構軟體.bash 殼程式腳本程式.sh<br />buildSoftware.bash.sh](buildSoftware.bash.sh)
軟體建構 Bash 腳本程式
