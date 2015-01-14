/** 
@file GUI.java
@brief youtube-dl-helper 圖形介面實作

本來源程式碼為「youtube-dl-helper」軟體的一部份
This source code is part of "youtube-dl-helper" software
	https://github.com/NTOUCS-Java-Programming-103-Team-13/youtube-dl-helper

@author 張仰鈞 <qqwwee2006@gmail.com>
@copyright 
The software has been released into public domain.
*/
package tw.edu.ntou.cs.java_programming.semester1031.team13.youtube_dl_helper;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.*;

/**
 * @brief GUI class
 */
public class GUI extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	private JFrame frame = new JFrame();
	/////////////////頁籤///////////////////////////
	private JTabbedPane view = new JTabbedPane (JTabbedPane.TOP);
	/////////////////主畫面元件///////////////////////////
	private	JLabel 媒體網址輸入框標籤 = new JLabel("媒體網址 :");
	private	JTextField 媒體網址輸入框 = new JTextField(100);
	private	JLabel 網址分析結果標籤 = new JLabel("網址分析結果:");
	private	JLabel 媒體支援格式清單標籤 = new JLabel("選擇下載格式:");
	private	JTextField 媒體支援格式清單 = new JTextField(100);
	private	JLabel 媒體支援字幕語言清單標籤 = new JLabel("選擇字幕語言:");
	private	JTextField 媒體支援字幕語言清單 = new JTextField(100);
	private	JLabel 選擇媒體保存目錄標籤 = new JLabel("保存目錄:");
	private JLabel 呼叫命令標籤 = new JLabel("youtube-dl 呼叫命令:");
	private	JTextField 呼叫命令輸入框 = new JTextField(100);
	private	JScrollPane 命令執行結果 = new JScrollPane();
	private JButton 選擇保存目錄按鈕 = new JButton("選擇‧‧‧‧‧");
	private JButton 執行下載命令按鈕 = new JButton("執行");
	private JLabel 命令執行結果標籤 = new JLabel("下載結果:");
	////////////////////////////檔案儲存///////////////////
	private JFileChooser fileChooser = null;
	JTextArea textarea = null;
	////////////////////////////////////////////////////////
		GUI(){
			super("youtube-dl-helper");//標題
			JPanel jpCenter = new JPanel();//創立主畫面容器
			JPanel jpCenter2 = new JPanel();//創立介紹容器
			jpCenter.setLayout(null);
			/////////////////大小區//////////////////////////
			呼叫命令標籤.setSize(new Dimension(200,30));
			呼叫命令輸入框.setSize(new Dimension(600,30));
			選擇媒體保存目錄標籤.setSize(new Dimension(800,30));
			執行下載命令按鈕.setSize(new Dimension(75,30));
			選擇保存目錄按鈕.setSize(new Dimension(125,30));
			命令執行結果.setSize(new Dimension(865,200));
			命令執行結果標籤.setSize(new Dimension(200,30));
			媒體支援格式清單.setSize(new Dimension(200,150));
			媒體支援字幕語言清單.setSize(new Dimension(200,150));
			媒體支援格式清單標籤.setSize(new Dimension(200,30));
			媒體支援字幕語言清單標籤.setSize(new Dimension(200,30));
			網址分析結果標籤.setSize(new Dimension(200,30));
			媒體網址輸入框標籤.setSize(new Dimension(200,30));
			媒體網址輸入框.setSize(new Dimension(800,30));
			//////////////////位置區/////////////////////////
			選擇媒體保存目錄標籤.setLocation(30,350);
			呼叫命令標籤.setLocation(30,400);
			呼叫命令輸入框.setLocation(150,400);
			選擇保存目錄按鈕.setLocation(770, 350);
			執行下載命令按鈕.setLocation(820, 400);
			命令執行結果.setLocation(30, 450);
			命令執行結果標籤.setLocation(30,650);
			媒體支援格式清單.setLocation(30,180);
			媒體支援字幕語言清單.setLocation(240,180);
			媒體支援字幕語言清單標籤.setLocation(240,150);
			媒體支援格式清單標籤.setLocation(30,150);
			網址分析結果標籤.setLocation(30,120);
			媒體網址輸入框標籤.setLocation(30, 0);
			媒體網址輸入框.setLocation(95,0);
			/////////////////加入元件//////////////////////
			jpCenter.add(媒體網址輸入框標籤); //將元件加入JPanel子容器
			jpCenter.add(媒體網址輸入框);
			jpCenter.add(網址分析結果標籤);
			jpCenter.add(媒體支援格式清單標籤);
			jpCenter.add(媒體支援格式清單);
			jpCenter.add(媒體支援字幕語言清單標籤);
			jpCenter.add(媒體支援字幕語言清單);
			jpCenter.add(選擇媒體保存目錄標籤);
			jpCenter.add(呼叫命令標籤);
			jpCenter.add(選擇保存目錄按鈕);
			jpCenter.add(執行下載命令按鈕);
			jpCenter.add(命令執行結果標籤);
			jpCenter.add(呼叫命令輸入框);
			jpCenter.add(命令執行結果);
			///////////////////////////加入頁籤///////////////////////////
			view.addTab("下載媒體",jpCenter);
			view.addTab("關於本軟體",jpCenter2);
			///////////////////////////存檔功能//////////////////////////
			選擇保存目錄按鈕.addActionListener((ActionListener) this);
			fileChooser = new JFileChooser();
			//////////////////////////////////////////////////////////
			Container cp = getContentPane(); //取得內容面版
			BorderLayout bl = (BorderLayout)cp.getLayout();
			//取得佈局管理員
			bl.setVgap(30); //設定垂直間距為10
			cp.add(view); //將元件加入面版
			Dimension dim = getToolkit().getScreenSize(); //取得螢幕大小
			setSize((int)dim.getWidth()/2, ((int)dim.getHeight()/3)*2); //設定視窗畫面的大小
			setLocation(dim.width/2 - getWidth()/2, dim.height/2 - getHeight()/2);//設定視窗顯示在螢幕的中央
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//設定按下視窗右上角關閉按鈕將關閉視窗並結束應用程式的執行
			setVisible(true); //顯示視窗
	}
	
	public void actionPerformed(ActionEvent event){//選擇檔案存檔
		File file=null;
		int result;
		if(event.getActionCommand().equals("選擇‧‧‧‧‧")){
			result = fileChooser.showSaveDialog(frame);
			file = null;
			if(result==JFileChooser.APPROVE_OPTION){
				file = fileChooser.getSelectedFile();
				選擇媒體保存目錄標籤.setText("保存目錄:"+fileChooser.getSelectedFile());
			}
			else if(result==JFileChooser.CANCEL_OPTION){
				選擇媒體保存目錄標籤.setText("保存目錄:");
			}
			
			FileOutputStream fileOutStream = null;
			
			if(file != null){
				try{
					fileOutStream = new FileOutputStream(file);
				}catch(FileNotFoundException fe){
					選擇媒體保存目錄標籤.setText("找不到檔案");
					return;
				}
				
			String content = textarea.getText();
			
			try{
				fileOutStream.write(content.getBytes());
			}catch(IOException ioe){
				選擇媒體保存目錄標籤.setText("寫入檔案錯誤");
			}
			finally{
				try{
					if(fileOutStream != null)fileOutStream.close();
				}catch(IOException ioe2){
				}
			}
			}
		}
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}