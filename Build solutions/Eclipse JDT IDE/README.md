#  軟體建構解決方案/Eclipse JDT 整合式開發環境/<br />Build solutions/Eclipse JDT IDE/
此為「Eclipse JDT 整合式開發環境」軟體建構解決方案的目錄

## 本軟體建構解決方案所依賴的額外軟體<br />Additional software dependencies of this build solution
### 包含 [Java Development Tools(JDT) 外掛工具](https://eclipse.org/jdt/)的 [Eclipse 整合式開發環境](http://www.eclipse.org/)

### [GNU CoreUtils](https://www.gnu.org/software/coreutils/)
主要使用了該軟體提供的 `cp`、`chmod` 命令，用於軟體建構程序

於類 Unix 作業系統中毋需另外安裝本軟體，於其他作業系統中請安裝其移植版本：

* Microsoft Windows
	* [CoreUtils for Windows](http://gnuwin32.sourceforge.net/packages/coreutils.htm)

請確定這些命令位於系統的可執行檔搜尋路徑序列中（即 PATH 環境變數）

## 目錄內項目說明
### [.settings/](.settings/)

### [.externalToolBuilders/](.externalToolBuilders/)
Eclipse 外部程式建構器設定的目錄

### [建構出來的軟體/<br />Built software/](Built software/)
放置建構出來的軟體的目錄

### [打包好的軟體/<br />Packaged software/](Packaged software/)
打包成 Java archive 的軟體

### [說明文件.md<br />README.md](README.md)
本說明文件

### [啟動設定檔/<br />Launch configurations/](Launch configurations/)

### [.project](.project)
Eclipse 專案檔案

### [.classpath](.classpath)
