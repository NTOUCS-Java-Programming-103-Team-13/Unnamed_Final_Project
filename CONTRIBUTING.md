# 如何貢獻到本專案<br>How to contribute to this project
## 貢獻本專案內容會用到的軟體
### [LibreOffice 辦公室生產力應用套裝軟體](http://www.libreoffice.org)
用來編輯 Flat XML 格式簡報、軟體介面設計文件（副檔名為 fodp、fods）。

### [Git 版本控制系統](http://git-scm.com/)
用來進行來源程式碼的版本控制與多人異地協同開發。

另外您可以安裝它的圖形化介面的前端程式(frontend)，比方說

* [GitHub for Windows](https://windows.github.com/)
* [git-cola: The highly caffeinated Git GUI](https://git-cola.github.io/)（推荐）

### [Doxygen 程式碼文件產生器](http://www.stack.nl/~dimitri/doxygen/)（非必要）
用來產生  API 文件

## 必要技能<br>Required techniques
要貢獻本專案的內容您必須至少要有下列幾種能力：

* 基本的 Git 版本控制系統操作
	* 以 `git config` 命令設定版本提交者(committer)的稱謂跟電子郵件地址
	* 以 `git clone` 命令克隆 GitHub 上的遠端版本倉庫(repository)到本地端
	* 以 `git add` 命令將您做的修改移動到版本提交準備區域(staging area)
	* 以 `git add --patch` 命令只將同一個檔案中*一部份的修改*移動到版本提交準備區域
	* 以 `git commit` 命令將版本提交準備區域中的修改變成一個新的版本提交(commit)提交到本地端版本倉庫中
	* 以 `git push` 命令將本地端版本倉庫的新的版本提交推送到遠端版本倉庫
* Java 程式語言的使用

## 來源程式碼格式要求<br>Source code format requirement
### 字元編碼<br>Character encoding
無 byte order mark(BOM) 的 UTF-8（如果您的系統為 Microsoft Windows 預設字元編碼可能是 BIG5 要切換）

### 行結尾字元序列<br />End-of-Line(EOF) character sequence
Unix (LF)（如果您的系統為 Microsoft Windows 預設行結尾字元序列
為 CRLF 要切換）

### 縮排風格<br>Indentation style  
以 Tab 字元縮排
