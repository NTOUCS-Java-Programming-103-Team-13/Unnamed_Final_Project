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
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JFileChooser;
import javax.swing.ScrollPaneConstants;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @brief GUI class
 */
public class GUI extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	private JFrame frame = new JFrame();
	/////////////////頁籤///////////////////////////
	private JTabbedPane view = new JTabbedPane (JTabbedPane.TOP);
	/////////////////主畫面元件///////////////////////////
	private JLabel 媒體網址輸入框標籤 = new JLabel("媒體網址 ：");
	private JTextField 媒體網址輸入框 = new JTextField(100);
	private JLabel 網址分析結果標籤 = new JLabel("網址分析結果：");
	private JLabel 媒體支援格式清單標籤 = new JLabel("選擇下載格式：");
	private JList<String> 媒體支援格式清單 = new JList<String>();
	private JLabel 媒體支援字幕語言清單標籤 = new JLabel("選擇字幕語言：");
	private JList<String> 媒體支援字幕語言清單 = new JList<String>();
	private JLabel 選擇媒體保存目錄標籤 = new JLabel("保存目錄：");
	private JTextField 媒體保存目錄輸入框 = new JTextField(512);
	private JButton 選擇保存目錄按鈕 = new JButton("選擇‧‧‧‧‧");
	private JLabel 呼叫命令標籤 = new JLabel("youtube-dl 呼叫命令：");
	private JTextField 呼叫命令輸入框 = new JTextField(1024);
	private JButton 執行下載命令按鈕 = new JButton("執行");
	private JTextArea 命令執行結果 = new JTextArea();
	private JLabel 命令執行結果標籤 = new JLabel("下載結果：");
	////////////////////////////檔案儲存///////////////////
	private JFileChooser savePathChooser = null;
	////////////////////////////////////////////////////////
	
	private HashMap<String, String> supported_formats = new HashMap<String, String>();
	private ArrayList<String> supported_sub_languages = new ArrayList<String>();
	
		GUI(){
			super("youtube-dl-helper");//標題
			
			/* 設定軟體圖示 */
			ImageIcon img = new ImageIcon(getClass().getResource("/Resources/Pictures/icon_design.png"));
			frame.setIconImage(img.getImage());
			
			JPanel jpCenter = new JPanel();//創立主畫面容器
			JPanel jpCenter2 = new JPanel();//創立介紹容器
			jpCenter.setLayout(null);
			
			///////////////////////////加入頁籤///////////////////////////
			view.addTab("下載媒體",jpCenter);
			view.addTab("關於本軟體",jpCenter2);
			
			/////////////////設定大小跟位置//////////////////////////
			媒體網址輸入框標籤.setSize(new Dimension(200,30));
			媒體網址輸入框標籤.setLocation(30, 0);
			媒體網址輸入框.setSize(new Dimension(800,30));
			媒體網址輸入框.setLocation(95,0);
			網址分析結果標籤.setSize(new Dimension(200,30));
			網址分析結果標籤.setLocation(30,120);
			媒體支援格式清單標籤.setSize(new Dimension(200,30));
			媒體支援格式清單標籤.setLocation(30,150);
			媒體支援格式清單.setSize(new Dimension(200,150));
			媒體支援格式清單.setLocation(30,180);
			媒體支援字幕語言清單標籤.setSize(new Dimension(200,30));
			媒體支援字幕語言清單標籤.setLocation(240,150);
			媒體支援字幕語言清單.setSize(new Dimension(200,150));
			媒體支援字幕語言清單.setLocation(240,180);
			選擇媒體保存目錄標籤.setSize(new Dimension(200,30));
			選擇媒體保存目錄標籤.setLocation(30,350);
			媒體保存目錄輸入框.setSize(new Dimension(600, 30));
			媒體保存目錄輸入框.setLocation(120, 350);
			try {
				媒體保存目錄輸入框.setText(URLDecoder.decode(GUI.class.getProtectionDomain().getCodeSource().getLocation().getPath().toString(), "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO 自動產生的 catch 區塊
				e.printStackTrace();
			}
			選擇保存目錄按鈕.setSize(new Dimension(125,30));
			選擇保存目錄按鈕.setLocation(770, 350);
			呼叫命令標籤.setSize(new Dimension(200,30));
			呼叫命令標籤.setLocation(30,400);
			呼叫命令輸入框.setSize(new Dimension(600,30));
			呼叫命令輸入框.setLocation(150,400);
			執行下載命令按鈕.setSize(new Dimension(75,30));
			執行下載命令按鈕.setLocation(820, 400);
			命令執行結果.setSize(new Dimension(865,200));
			命令執行結果.setLocation(30, 450);
			命令執行結果標籤.setSize(new Dimension(200,30));
			命令執行結果標籤.setLocation(30,650);

			/////////////////加入元件//////////////////////
			jpCenter.add(媒體網址輸入框標籤); //將元件加入JPanel子容器
			jpCenter.add(媒體網址輸入框);
			jpCenter.add(網址分析結果標籤);
			jpCenter.add(媒體支援格式清單標籤);
			jpCenter.add(媒體支援格式清單);
			jpCenter.add(媒體支援字幕語言清單標籤);
			jpCenter.add(媒體支援字幕語言清單);
			jpCenter.add(選擇媒體保存目錄標籤);
			jpCenter.add(媒體保存目錄輸入框);
			jpCenter.add(呼叫命令標籤);
			jpCenter.add(選擇保存目錄按鈕);
			jpCenter.add(執行下載命令按鈕);
			jpCenter.add(命令執行結果標籤);
			jpCenter.add(呼叫命令輸入框);
			jpCenter.add(命令執行結果);

			
			媒體網址輸入框.addActionListener((ActionListener) this);
			
			///////////////////////////存檔功能//////////////////////////
			選擇保存目錄按鈕.addActionListener((ActionListener) this);
			savePathChooser = new JFileChooser();
			savePathChooser.setCurrentDirectory(new java.io.File("."));
			savePathChooser.setDialogTitle("選擇保存目錄");
			savePathChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			savePathChooser.setAcceptAllFileFilterUsed(false);
			
			執行下載命令按鈕.addActionListener((ActionListener) this);
			
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

	public void actionPerformed(ActionEvent event){//選擇影片保存的目錄（youtube-dl 下載命令的當前工作目錄）
		if(event.getActionCommand().equals("選擇‧‧‧‧‧")){
			int result = savePathChooser.showSaveDialog(frame);

			if(result==JFileChooser.APPROVE_OPTION){
				媒體保存目錄輸入框.setText(savePathChooser.getSelectedFile().getAbsolutePath());
				媒體保存目錄輸入框.setToolTipText(媒體保存目錄輸入框.getText());
			}
		}
		
  		if(event.getSource() == 媒體網址輸入框){
			supported_formats = YoutubeDlParser.getMediaSupportedFormats(媒體網址輸入框.getText());
			媒體支援格式清單.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			DefaultListModel<String> formatlistModel = new DefaultListModel<String>();
			for(Iterator i = supported_formats.entrySet().iterator(); i.hasNext(); ){
				formatlistModel.addElement(((Map.Entry<String, String>)i.next()).getValue());
			}
			媒體支援格式清單.setModel(formatlistModel);
			媒體支援格式清單.setVisible(true);
			
			supported_sub_languages = YoutubeDlParser.getMediaSupportedSubtitles(媒體網址輸入框.getText());
			DefaultListModel<String> sublistModel = new DefaultListModel<String>();
			for(Iterator i = supported_sub_languages.iterator(); i.hasNext(); ){
				sublistModel.addElement((String)i.next());
			}
			媒體支援字幕語言清單.setModel(sublistModel);
			媒體支援字幕語言清單.setVisible(true);
		}

  		if(event.getActionCommand().equals("執行")){
  			Process youtube_dl_process;
  			try {
  				youtube_dl_process = Runtime.getRuntime().exec("youtube-dl " + 媒體網址輸入框.getText());
  				String line;
  				InputStream youtube_dl_process_standard_output = youtube_dl_process.getInputStream();
  				BufferedReader youtube_dl_output_reader = new BufferedReader (new InputStreamReader(youtube_dl_process_standard_output));
  				while((line = youtube_dl_output_reader.readLine()) != null){
  					命令執行結果.setText(命令執行結果.getText() + "\n" + line);
  				}
  				youtube_dl_output_reader.close();

  				youtube_dl_process.waitFor();
  			} catch (IOException | InterruptedException e) {
  				// TODO 自動產生的 catch 區塊
  				e.printStackTrace();
  			}
  		}


	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

} // end class TextFieldFrame
