/** 
@file GUI.java
@brief youtube-dl-helper 圖形介面實作

本來源程式碼為「youtube-dl-helper」軟體的一部份
This source code is part of "youtube-dl-helper" software
	https://github.com/NTOUCS-Java-Programming-103-Team-13/youtube-dl-helper

@author 張仰鈞 <qqwwee2006@gmail.com>
@author 林博仁 <Henry.Lin.Taiwan@gmail.com>
@author 林夏媛 <dorislin8737@gmail.com>
@copyright 
The software has been released into public domain.
*/
package tw.edu.ntou.cs.java_programming.semester1031.team13.youtube_dl_helper;
import java.awt.*;
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

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @brief GUI class
 */
public class GUI extends JFrame implements ActionListener, ListSelectionListener{
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
	private JScrollPane 媒體支援格式清單卷軸 = new JScrollPane(媒體支援格式清單);
	private JLabel 媒體支援字幕語言清單標籤 = new JLabel("選擇字幕語言：");
	private JList<String> 媒體支援字幕語言清單 = new JList<String>();
	private JScrollPane 媒體支援字幕語言清單卷軸 = new JScrollPane(媒體支援字幕語言清單);
	private JLabel 選擇媒體保存目錄標籤 = new JLabel("保存目錄：");
	private JTextField 媒體保存目錄輸入框 = new JTextField(512);
	private JButton 選擇保存目錄按鈕 = new JButton("選擇‧‧‧‧‧");
	private JLabel 呼叫命令標籤 = new JLabel("youtube-dl 呼叫命令：");
	private JTextField 呼叫命令輸入框 = new JTextField(1024);
	private JButton 執行下載命令按鈕 = new JButton("執行");
	private JTextArea 命令執行結果 = new JTextArea();
	private JScrollPane 命令執行結果卷軸 = new JScrollPane(命令執行結果);
	private JLabel 版本圖片 = new JLabel();
	private JLabel 版本介紹 = new JLabel("又一個非官方的 youtube-dl圖形介面包裝程式");
	private JLabel 版本網址 = new JLabel("https://github.com/NTOUCS-Java-Programming-103-Team-13/youtube-dl-helper");
	private JLabel 回報問題 = new JLabel("回報問題: ");
	private JLabel 回報網址 = new JLabel("https://github.com/NTOUCS-Java-Programming-103-Team-13/youtube-dl-helper/issues");
	private JLabel wiki = new JLabel("Wiki: ");
	private JLabel wiki網址 = new JLabel("https://github.com/NTOUCS-Java-Programming-103-Team-13/youtube-dl-helper/wiki");
	private JLabel 使用說明 = new JLabel("第一次使用前請先至http://rg3.github.io/youtube-dl/download.html下載youtube-dl並將儲存位置加入系統變數Path中");
	private JLabel 使用說明1 = new JLabel("本軟體建議放大為全螢幕後使用");
	private JLabel 使用說明2 = new JLabel("操作介紹:");
	private JLabel 使用說明3 = new JLabel("請將影片網址填入媒體網址後之空格");
	private JLabel 使用說明4 = new JLabel("如果要直接下載最佳格式 請直接按下[執行]");
	private JLabel 使用說明5 = new JLabel("如需查看所有格式及字幕選項請在輸入完畢後按下Enter(或可使用下列方法取得)");
	private JLabel 使用說明6 = new JLabel("如需下載其他格式 請根據以下方式輸入所選擇的格式");
	private JLabel 使用說明7 = new JLabel("格式選擇請填入youtube-dl 呼叫命令後之空格");
	private JLabel 使用說明8 = new JLabel("-x → 只下載聲音");
	private JLabel 使用說明9 = new JLabel("--list-formats  → 列出所有影音格式");
	private JLabel 使用說明10 = new JLabel("--format  格式代碼   → 下載指定影音格式(如影像跟聲音分開 中間請用+連結)");
	private JLabel 使用說明11 = new JLabel("--list-subs  → 列出所有字幕格式");
	private JLabel 使用說明12 = new JLabel("--sub-lang  語言代碼   → 下載指定字幕");

	
	
	////////////////////////////檔案儲存///////////////////
	private JFileChooser savePathChooser = null;
	////////////////////////////////////////////////////////
	
	private HashMap<String, String> supported_formats = new HashMap<String, String>();
	private ArrayList<String> supported_sub_languages = new ArrayList<String>();
	
		GUI(){
			super("youtube-dl-helper");//標題
			
			/* 設定軟體圖示 */
			ImageIcon img = new ImageIcon(getClass().getResource("/Resources/Pictures/icon_design.png"));
			ImageIcon img2 = new ImageIcon(getClass().getResource("/Resources/Pictures/splash_design.png"));
			frame.setIconImage(img.getImage());
			版本圖片= new JLabel(img2);
			this.setLayout(new BorderLayout()); 
			this.add(版本圖片, BorderLayout.CENTER); 
			
			JPanel jpCenter = new JPanel();//創立主畫面容器
			JPanel jpCenter2 = new JPanel();//創立介紹容器
			JPanel jpCenter3 = new JPanel();//使用說明容器
			jpCenter.setLayout(null);
			jpCenter2.setLayout(null);
			jpCenter3.setLayout(null);
			
			///////////////////////////加入頁籤///////////////////////////
			view.addTab("下載媒體",jpCenter);
			view.addTab("關於本軟體",jpCenter2);
			view.addTab("使用說明",jpCenter3);
			
			/////////////////設定大小跟位置//////////////////////////
			媒體網址輸入框標籤.setSize(new Dimension(200,30));
			媒體網址輸入框標籤.setLocation(30, 0);
			媒體網址輸入框.setSize(new Dimension(800,30));
			媒體網址輸入框.setLocation(100,0);
			網址分析結果標籤.setSize(new Dimension(200,30));
			網址分析結果標籤.setLocation(30,30);
			媒體支援格式清單標籤.setSize(new Dimension(200,30));
			媒體支援格式清單標籤.setLocation(30,60);
			媒體支援格式清單卷軸.setSize(new Dimension(200,150));
			媒體支援格式清單卷軸.setLocation(30,90);
			媒體支援格式清單卷軸.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			媒體支援字幕語言清單標籤.setSize(new Dimension(200,30));
			媒體支援字幕語言清單標籤.setLocation(240,60);
			媒體支援字幕語言清單卷軸.setSize(new Dimension(200,150));
			媒體支援字幕語言清單卷軸.setLocation(240,90);
			媒體支援字幕語言清單卷軸.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			選擇媒體保存目錄標籤.setSize(new Dimension(200,30));
			選擇媒體保存目錄標籤.setLocation(30,260);
			媒體保存目錄輸入框.setSize(new Dimension(600, 30));
			媒體保存目錄輸入框.setLocation(97, 260);
			try {
				媒體保存目錄輸入框.setText(URLDecoder.decode(GUI.class.getProtectionDomain().getCodeSource().getLocation().getPath().toString(), "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO 自動產生的 catch 區塊
				e.printStackTrace();
			}
			選擇保存目錄按鈕.setSize(new Dimension(125,30));
			選擇保存目錄按鈕.setLocation(770, 260);
			呼叫命令標籤.setSize(new Dimension(200,30));
			呼叫命令標籤.setLocation(30,310);
			呼叫命令輸入框.setSize(new Dimension(600,30));
			呼叫命令輸入框.setLocation(160,310);
			執行下載命令按鈕.setSize(new Dimension(75,30));
			執行下載命令按鈕.setLocation(820, 310);
			命令執行結果卷軸.setSize(new Dimension(865,200));
			命令執行結果卷軸.setLocation(30, 360);
			命令執行結果卷軸.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			版本圖片.setSize(new Dimension(500,200));
			版本圖片.setLocation(30,20);
			版本介紹.setSize(new Dimension(500,30));
			版本介紹.setLocation(30,230);
			版本網址.setSize(new Dimension(500,30));
			版本網址.setLocation(30,260);
			回報問題.setSize(new Dimension(500,30));
			回報問題.setLocation(30,290);
			回報網址.setSize(new Dimension(500,30));
			回報網址.setLocation(30,320);
			wiki.setSize(new Dimension(500,30));
			wiki.setLocation(30,350);
			wiki網址.setSize(new Dimension(500,30));
			wiki網址.setLocation(30,380);
			使用說明.setSize(new Dimension(700,30));
			使用說明.setLocation(30,0);
			使用說明1.setSize(new Dimension(500,30));
			使用說明1.setLocation(30,30);
			使用說明2.setSize(new Dimension(500,30));
			使用說明2.setLocation(30,60);
			使用說明3.setSize(new Dimension(500,30));
			使用說明3.setLocation(30,90);
			使用說明4.setSize(new Dimension(500,30));
			使用說明4.setLocation(30,120);
			使用說明5.setSize(new Dimension(500,30));
			使用說明5.setLocation(30,150);
			使用說明6.setSize(new Dimension(500,30));
			使用說明6.setLocation(30,180);
			使用說明7.setSize(new Dimension(500,30));
			使用說明7.setLocation(30,210);
			使用說明8.setSize(new Dimension(500,30));
			使用說明8.setLocation(30,240);
			使用說明9.setSize(new Dimension(500,30));
			使用說明9.setLocation(30,270);
			使用說明10.setSize(new Dimension(500,30));
			使用說明10.setLocation(30,300);
			使用說明11.setSize(new Dimension(500,30));
			使用說明11.setLocation(30,330);
			使用說明12.setSize(new Dimension(500,30));
			使用說明12.setLocation(30,360);

			/////////////////加入元件//////////////////////
			jpCenter.add(媒體網址輸入框標籤); //將元件加入JPanel子容器
			jpCenter.add(媒體網址輸入框);
			jpCenter.add(網址分析結果標籤);
			jpCenter.add(媒體支援格式清單標籤);
			jpCenter.add(媒體支援格式清單卷軸);
			jpCenter.add(媒體支援字幕語言清單標籤);
			jpCenter.add(媒體支援字幕語言清單卷軸);
			jpCenter.add(選擇媒體保存目錄標籤);
			jpCenter.add(媒體保存目錄輸入框);
			jpCenter.add(呼叫命令標籤);
			jpCenter.add(選擇保存目錄按鈕);
			jpCenter.add(執行下載命令按鈕);
			jpCenter.add(呼叫命令輸入框);
			jpCenter.add(命令執行結果卷軸);
			jpCenter2.add(版本圖片);
			jpCenter2.add(版本介紹);
			jpCenter2.add(版本網址);
			jpCenter2.add(回報問題);
			jpCenter2.add(回報網址);
			jpCenter2.add(wiki);
			jpCenter2.add(wiki網址);
			jpCenter3.add(使用說明);
			jpCenter3.add(使用說明1);
			jpCenter3.add(使用說明2);
			jpCenter3.add(使用說明3);
			jpCenter3.add(使用說明4);
			jpCenter3.add(使用說明5);
			jpCenter3.add(使用說明6);
			jpCenter3.add(使用說明7);
			jpCenter3.add(使用說明8);
			jpCenter3.add(使用說明9);
			jpCenter3.add(使用說明10);
			jpCenter3.add(使用說明11);
			jpCenter3.add(使用說明12);

			
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
			媒體支援格式清單.addListSelectionListener((ListSelectionListener) this);
			
			supported_sub_languages = YoutubeDlParser.getMediaSupportedSubtitles(媒體網址輸入框.getText());
			DefaultListModel<String> sublistModel = new DefaultListModel<String>();
			for(Iterator i = supported_sub_languages.iterator(); i.hasNext(); ){
				sublistModel.addElement((String)i.next());
			}
			媒體支援字幕語言清單.setModel(sublistModel);
			媒體支援字幕語言清單.setVisible(true);
			媒體支援字幕語言清單.addListSelectionListener((ListSelectionListener) this);
			
			呼叫命令輸入框.setText("youtube-dl " + 媒體網址輸入框.getText());
			
		}

  		if(event.getActionCommand().equals("執行")){
  			Process youtube_dl_process;
  			try {
  				youtube_dl_process = Runtime.getRuntime().exec(呼叫命令輸入框.getText());
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
	
	public void valueChanged(ListSelectionEvent event){
		System.out.println(event.toString());
		return;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

} // end class TextFieldFrame
