#!/bin/bash
# 	宣告執行 script 程式用的殼程式(shell)
################## Header block ##################
# Script程式名稱
# Script Name
# 	自動準備專案所需的函式庫的程式
# 著作權宣告
# Copyright Declaration
# 	Ｖ字龍(Vdragon) <Vdragon.Taiwan@gmail.com> (c) 2014
# 授權條款宣告
# License Declaration
# 	請參閱「通用軟體專案範本」的授權條款
# 傳回值定義
# Return Value Definition
# 	0
# 		正常結束
# 已知問題
# Known Issues
# 	Known issues is now tracked on GitHub
# 	
# 修訂紀錄
# Changelog
# 	Changelog is now tracked using Git repostiory commit log
# 	
############## Header block ended ##############

######## File scope variable definitions ########
# idea from http://www.kfirlavi.com/blog/2012/11/14/defensive-bash-programming/
readonly PROGRAM_NAME="$(basename $0)"
readonly PROGRAM_DIRECTORY="$(readlink -m $(dirname $0))"
readonly PROGRAM_ARGUMENT_ORIGINAL_LIST="$@"
readonly PROGRAM_ARGUMENT_ORIGINAL_NUMBER=$#
readonly project_root_path="${PROGRAM_DIRECTORY}/.."

######## File scope variable definitions ended ########

######## Included files ########
source "${project_root_path}/Tools/checkIllegalUsage.bash.source.sh"
######## Included files ended ########

######## Program ########
# main function, program entry point
# idea from http://www.kfirlavi.com/blog/2012/11/14/defensive-bash-programming/
main() {
	set -x
	
	checkIllegalUsage
	
	mkdir --parent "3rd party software"
	cd "3rd party software"

	git submodule init
	git submodule update

	cd JSON-java/
	mkdir --parents build/org/json
	find . -name build -prune -o -name "*.java" -exec cp --parents {} build/org/json ";"
	cd build/
	find . -name "*.java" -exec javac {} ";"
	jar vcf "${project_root_path}/Libraries/org.json.jar" org/
	
	# clean up
	cd "${project_root_path}"
	rm --recursive --force "3rd party software/JSON-java/build"
	
	## 正常結束 script 程式
	exit 0
	set +x
}
main