package project;

import java.io.IOException;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class project {
	public static void main(String[] args) {
		JFrame f= new JFrame("Search");
		
		f.setLocation(500, 400);
		f.setPreferredSize(new Dimension(300, 200));
		Container contentPane = f.getContentPane();
		contentPane.setLayout(new GridLayout(5, 1));
		JTextField text = new JTextField();
		JButton Google_Button = new JButton("Google");
		JButton Naver_Button = new JButton("Naver");
		JButton Youtube_Button = new JButton("Youtube");
		JLabel label = new JLabel("Test");
		
		contentPane.add(text);
		contentPane.add(Google_Button);
		contentPane.add(Naver_Button);
		contentPane.add(Youtube_Button);
		contentPane.add(label);

		ActionListener listener = new ConfirmActionListener(text,label);
		Google_Button.addActionListener(listener);
		Naver_Button.addActionListener(listener);
		Youtube_Button.addActionListener(listener);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setVisible(true);
	}
}
class ConfirmActionListener implements ActionListener {
	JTextField text;
	JLabel label;
	
	ConfirmActionListener(JTextField text, JLabel label){
		this.text=text;
		this.label=label;
	}
	public void actionPerformed(ActionEvent arg0) {
			JButton button = (JButton)arg0.getSource();
			String name = text.getText();
			if(button.getText().equals("Google")) {
				String address1 = "https://www.google.co.kr/search?q=" + name;
				String[] cmd = new String[] {"rundll32", "url.dll", "FileProtocolHandler", address1};
				try {
					Process process = new ProcessBuilder(cmd).start();
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(button.getText().equals("Naver")) {
				String address2 = "https://search.naver.com/search.naver?where=nexearch&query=" + name;
				String[] cmd = new String[] {"rundll32", "url.dll", "FileProtocolHandler", address2};
				try {
					Process process = new ProcessBuilder(cmd).start();
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(button.getText().equals("Youtube")) {
				String address3 = "https://www.youtube.com/results?search_query=" + name;
				String[] cmd = new String[] {"rundll32", "url.dll", "FileProtocolHandler", address3};
				try {
					Process process = new ProcessBuilder(cmd).start();
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}