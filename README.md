# youtube-dl-helper，又一個非官方的 youtube-dl 圖形介面包裝程式
<https://github.com/NTOUCS-Java-Programming-103-Team-13/youtube-dl-helper>  

## youtube-dl-helper 是什麼？
youtube-dl-helper 為使用 Java 程式語言設計的 youtube-dl 圖形介面包裝程式(wrapper)，企圖讓 youtube-dl 的操作對使用者更加友善。

## youtube-dl 是什麼？
[youtube-dl](http://rg3.github.io/youtube-dl/) 為下載 [Youtube](http://youtube.com) 與[更多線上影音網站](http://rg3.github.io/youtube-dl/supportedsites.html)多媒體的命令列介面下載程式，可以下載不同的畫質的影片與其字幕。

youtube-dl 為 GitHub Git 版本倉庫托管網站上 7029 人 star（類似加入我的最愛）， 1355 人建立分支(fork)，218 個貢獻者（有更改過代碼），6238 個版本提交，於[<del>潮到出水</del>人氣版本倉庫排名](https://github.com/trending)中的總排名第五名，於 [Python 程式語言的版本倉庫中](https://github.com/trending?l=python)排名第一（資料擷取於 2014/11/27），是一個非常有名的釋出到公眾領域(Public Domain)的自由軟體專案。

## 作者<br>Authors
國立台灣海洋大學資訊工程學系 103 學年度《Java 程式設計》課程期末專案第 13 組組員：

* [林夏媛](http://www.github.com/dorislin8737)
* [張仰鈞](http://www.github.com/stevekevin1005)
* [林博仁](http://www.github.com/Vdragon)
* [曾鐙毅](http://www.github.com/kshs31711)
* [朱運輝](http://www.github.com/Manuscr1pt)
* [許咏順]

其他專案貢獻者請參考本專案 [Git 版本倉庫的版本提交紀錄](https://github.com/NTOUCS-Java-Programming-103-Team-13/youtube-dl-helper/commits)。

## 智慧財產授權條款
本智慧財產以 [WTFPL 授權條款](http://www.wtfpl.net/)釋出：

```
        DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE 
                    Version 2, December 2004 

 Copyright (C) 2004 Sam Hocevar <sam@hocevar.net> 

 Everyone is permitted to copy and distribute verbatim or modified 
 copies of this license document, and changing it is allowed as long 
 as the name is changed. 

            DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE 
   TERMS AND CONDITIONS FOR COPYING, DISTRIBUTION AND MODIFICATION 

  0. You just DO WHAT THE FUCK YOU WANT TO.
```

## 類似性質的專案
* [jakeogh/youtube-dl-wrapper](https://github.com/jakeogh/youtube-dl-wrapper)
	* 命令列介面的包裝程式，支援下載失敗重試
* [fredyw/win-youtube-dl](https://github.com/fredyw/win-youtube-dl)
	* 根據開發者說明理論上 Mac、GNU/Linux 平台也能執行，但是目前只有提供 Windows 平台的程式
* [3D Youtube Downloader](http://yd.3dyd.com/)
	* 專有軟體，似乎不是基於 youtube-dl
* [MrS0m30n3/youtube-dl-gui](https://github.com/MrS0m30n3/youtube-dl-gui)
	* 基於 youtube-dl ，以 wxPython 圖形介面函式庫設計的前端(frontend)軟體

## 軟體開發目標
### 支援國際化(I18N)
### 針對不同網站來源提供操作（最初只支援 Youtube）
### 支援 Travis CI Continous Integration
### 以 Git 版本控制系統作為有效的版本控制與異地協同合作
### 跨平台運行
雖然對 Java SE 執行環境(runtime environment)而言本身就跨多個人電腦平台，我們要確認在任何主要平台上都能正常運作

### 支援一種以上的跨平台軟體建構解決方案

## 如何參與本專案<br>How to involve?
### 回報軟體問題與建議  
到本專案的[議題追蹤系統](https://github.com/NTOUCS-Java-Programming-103-Team-13/youtube-dl-wrapper/issues)[建檔](https://github.com/NTOUCS-Java-Programming-103-Team-13/youtube-dl-helper/issues/new)回報（沒有 GitHub 帳號可以於 [Join GitHub · GitHub](https://github.com/join) 註冊）

### 翻譯軟體介面
本專案尚未實作國際化支援，如想要貢獻軟體介面翻譯請至[議題追蹤系統](https://github.com/NTOUCS-Java-Programming-103-Team-13/youtube-dl-wrapper/issues)建檔議題看看我們能幫您做什麼。

### 撰寫軟體的使用手冊
協助我們建立可讀性佳，對使用者友善的使用手冊

### 協助程式開發
[建立本版本倉庫的分支](https://github.com/NTOUCS-Java-Programming-103-Team-13/youtube-dl-helper/fork)加入自己的修改後跟我們[提交合併請求(pull request)](https://github.com/NTOUCS-Java-Programming-103-Team-13/youtube-dl-helper/pull/new)

## 本目錄下的項目說明
### [來源程式碼/<br />Source code/](Source code/)
本軟體的來源程式碼

### [軟體建構解決方案/<br />Build solutions/](Build solutions/)
軟體解決方案目錄

### [軟體介面設計/<br>UI design/](UI design/)
本軟體的軟體介面設計

### [軟體打包用資料/<br />Packaging data/](Packaging data/)

### [第三方軟體/<br />3rd party software/](3rd party software/)
專案所使用的第三方軟體

### [專案會用到的工具/<br />Tools/](Tools/)

### [說明文件/<br />Documentation/](Documentation/)

### [專案說明文件.md<br />README.md](README.md)
本專案的說明文件

### [期中提案.fodp](期中提案.fodp)

### [期末報告.fodp](期末報告.fodp)

### [.gitignore](.gitignore)
Git 版本控制系統版本追蹤忽略規則

### [.travis.yml](.travis.yml)
[Travis-CI Continuous Integration 服務](http://travis-ci.org)設定檔

## 如何建構軟體／如何執行建構出來的軟體
請參考 [軟體建構解決方案/](Build solutions/) 目錄下各軟體建構解決方案的說明文件。

## 建構本軟體需要用到的軟體
### GNU Bash 殼程式
用於第三方軟體的建構程式

### Java 開發環境<br />Java development environment(JDK)

其他需要的軟體請參考各[軟體建構解決方案/](Build solutions/)的說明文件。

## 執行本軟體需要用到的軟體
### Java 執行時期環境<br />Java runtime environment(JRE)

### 安裝到系統搜尋可執行檔路徑中的 youtube-dl 程式

## Continuous Integration 狀態
[![Build Status](https://travis-ci.org/NTOUCS-Java-Programming-103-Team-13/youtube-dl-helper.svg)](https://travis-ci.org/NTOUCS-Java-Programming-103-Team-13/youtube-dl-helper)
