import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.BevelBorder;


public class MessagingApp extends AppDefault {
	private String[] contactNames = {"Ahornam", "Nii", "Titus", "Francisca", "Ella", "Adjoa"};
	
	
	JPanel recentMessagedpanel = new JPanel();
	
	JLabel[] topMessageLabel = new JLabel[100];
	JLabel[] messageTimeLabel = new JLabel[100];
	JLabel[] messageImg = new JLabel[100];
	JLabel[] messageContactName = new JLabel[100];
	JLabel[] message = new JLabel[100];
	Random random = new Random();
	
	JPanel sendPanel,recievePanel;
	JLabel sendLabel;
	int start = 0;
	int tester = 0;
	
	String Name;
	public MessagingApp() {
		setLayout(null);
		
		
		recentMessagedpanel.setForeground(new Color(248, 248, 255));
		recentMessagedpanel.setBackground(new Color(33, 55, 77));
		recentMessagedpanel.setBounds(0, 0, 290, 570);
		add(recentMessagedpanel);
		recentMessagedpanel.setLayout(null);
		showAllMessages();
		
		
	}
	
	public void showAllMessages() {
		recentMessagedpanel.removeAll();
		recentMessagedpanel.revalidate();
		recentMessagedpanel.repaint();
		JLabel topMessageLabel = new JLabel("Messages");
		topMessageLabel.setFont(new Font("Arial", Font.PLAIN, 23));
		topMessageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		topMessageLabel.setForeground(UIManager.getColor("CheckBox.light"));
		topMessageLabel.setBounds(45, 5, 200, 35);
		recentMessagedpanel.add(topMessageLabel);
		
		start = 40;
		for(int a = 0; a < 4 ;a++) {
		
			messageTimeLabel[a] = new JLabel("4:50");
			messageTimeLabel[a].setFont(new Font("Tahoma", Font.PLAIN, 13));
			messageTimeLabel[a].setHorizontalAlignment(SwingConstants.TRAILING);
			messageTimeLabel[a].setForeground(UIManager.getColor("CheckBox.light"));
			messageTimeLabel[a].setBounds(222, start, 56, 16);
			recentMessagedpanel.add(messageTimeLabel[a]);
			
			int imgNum =random.nextInt(4) + 1 ;
			messageImg[a] = new JLabel("New label");
			messageImg[a].setIcon(new ImageIcon(MessagingApp.class.getResource("/asset/img/icon/conImg"+ imgNum +".png")));
			messageImg[a].setBounds(12, start + 13, 34, 34);
			recentMessagedpanel.add(messageImg[a]);
			
			messageContactName[a] = new JLabel(contactNames[a]);
			messageContactName[a].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					JLabel src = (JLabel) arg0.getSource();
					Name = src.getText();
					showMessageDetail(0,Name,"",false);
					
				}
			});
			messageContactName[a].setForeground(Color.WHITE);
			messageContactName[a].setFont(new Font("Arial", Font.PLAIN, 16));
			messageContactName[a].setBounds(55,start + 13, 223, 23);
			recentMessagedpanel.add(messageContactName[a]);
			
			message[a] = new JLabel("Hey\r\n");
			message[a].setForeground(Color.WHITE);
			message[a].setFont(new Font("Arial", Font.PLAIN, 16));
			message[a].setBounds(55, start + 37, 223, 35);
			recentMessagedpanel.add(message[a]);
			
			start += 70;
			
		}
		
		JLabel startNewMessageImg = new JLabel("");
		startNewMessageImg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				newMessage();
			}
		});
		
		startNewMessageImg.setBounds(196, 481, 64, 57);
		recentMessagedpanel.add(startNewMessageImg);
		startNewMessageImg.setForeground(Color.LIGHT_GRAY);
		startNewMessageImg.setIcon(new ImageIcon(MessagingApp.class.getResource("/asset/img/icon/icons8-messaging-64.png")));
		
		
	}
	
	public void newMessage() {
		recentMessagedpanel.removeAll();
		recentMessagedpanel.revalidate();
		recentMessagedpanel.repaint();
		JLabel lblNewLabel = new JLabel("TO :\r\n");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 19));
		lblNewLabel.setBounds(12, 38, 45, 35);
		recentMessagedpanel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(55, 38, 190, 35);
		recentMessagedpanel.add(textField);
		textField.setColumns(10);
		
		messageTextField = new JTextField();
		messageTextField.setBackground(new Color(192, 192, 192));
		messageTextField.setBounds(12, 521, 210, 36);
		recentMessagedpanel.add(messageTextField);
		messageTextField.setColumns(10);
		
		JLabel sendMessageLabel = new JLabel("New label");
		sendMessageLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String newMessage = messageTextField.getText();	
				showMessageDetail(1,textField.getText(),newMessage,true);
				
				
			}
		});
		sendMessageLabel.setIcon(new ImageIcon(MessagingApp.class.getResource("/asset/img/icon/icons8-email-send-40.png")));
		sendMessageLabel.setBounds(234, 521, 44, 36);
		recentMessagedpanel.add(sendMessageLabel);
		


	}
	
	
	
	
	public void showMessageDetail(int tester,String conName, String newMessage,boolean newContact) {
		
		recentMessagedpanel.removeAll();
		recentMessagedpanel.revalidate();
		recentMessagedpanel.repaint();
		   
		messageTextField = new JTextField();
		messageTextField.setBackground(new Color(192, 192, 192));
		messageTextField.setBounds(12, 521, 210, 36);
		recentMessagedpanel.add(messageTextField);
		messageTextField.setColumns(10);
		
		JLabel sendMessageLabel = new JLabel("New label");
		sendMessageLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String newMessage = messageTextField.getText();	
				showMessageDetail(1,Name,newMessage,false);
				
				
				
			}
		});
		sendMessageLabel.setIcon(new ImageIcon(MessagingApp.class.getResource("/asset/img/icon/icons8-email-send-40.png")));
		sendMessageLabel.setBounds(234, 521, 44, 36);
		recentMessagedpanel.add(sendMessageLabel);
		
		JLabel backLabel = new JLabel("New label");
		backLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showAllMessages();
			}
		});
		backLabel.setIcon(new ImageIcon(MessagingApp.class.getResource("/asset/img/icon/icons8-left-40.png")));
		backLabel.setBounds(12, 13, 51, 36);
		recentMessagedpanel.add(backLabel);
		
		JLabel messageConName = new JLabel(conName);
		messageConName.setFont(new Font("Arial", Font.PLAIN, 20));
		messageConName.setForeground(new Color(255, 255, 255));
		messageConName.setBounds(86, 13, 176, 36);
		recentMessagedpanel.add(messageConName);
		
		
		    start = 459;
			if(tester == 1) {
				
				sendPanel = new JPanel();
				sendPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
				sendPanel.setBackground(new Color(106, 90, 205));
				sendPanel.setBounds(137, start, 141, 36);
				recentMessagedpanel.add(sendPanel);
				sendPanel.setLayout(null);
				
				sendLabel = new JLabel(newMessage);
				sendLabel.setForeground(Color.WHITE);
				sendLabel.setFont(new Font("Arial", Font.PLAIN, 15));
				sendLabel.setBounds(10, 10, 80, 16);
				sendPanel.add(sendLabel);
				
				JLabel stLabel = new JLabel("10:23");
				stLabel.setForeground(new Color(211, 211, 211));
				stLabel.setFont(new Font("Arial", Font.PLAIN, 12));
				stLabel.setBounds(90, 17, 51, 16);
				sendPanel.add(stLabel);
				start = start - 40;
				if(newContact == true) {
				return;	
				}
			}
			sendPanel = new JPanel();
			sendPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
			sendPanel.setBackground(new Color(106, 90, 205));
			sendPanel.setBounds(167, start, 111, 36);
			recentMessagedpanel.add(sendPanel);
			sendPanel.setLayout(null);
			
			sendLabel = new JLabel("Hey");
			sendLabel.setForeground(Color.WHITE);
			sendLabel.setFont(new Font("Arial", Font.PLAIN, 15));
			sendLabel.setBounds(10, 10, 40, 16);
			sendPanel.add(sendLabel);
			
			JLabel stLabel = new JLabel("10:23");
			stLabel.setForeground(new Color(211, 211, 211));
			stLabel.setFont(new Font("Arial", Font.PLAIN, 12));
			stLabel.setBounds(60, 17, 51, 16);
			sendPanel.add(stLabel);
			

			recievePanel = new JPanel();
			recievePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
			recievePanel.setBackground(new Color(119, 136, 153));
			recievePanel.setBounds(12, start - 50, 111, 36);
			recentMessagedpanel.add(recievePanel);
			recievePanel.setLayout(null);
			
			JLabel recieveLabel = new JLabel("Hey");
			recieveLabel.setForeground(new Color(255, 255, 255));
			recieveLabel.setFont(new Font("Arial", Font.PLAIN, 15));
			recieveLabel.setBounds(10, 10, 40, 16);
			recievePanel.add(recieveLabel);
			
			JLabel rtimeLabel = new JLabel("10:23");
			rtimeLabel.setForeground(new Color(192, 192, 192));
			rtimeLabel.setFont(new Font("Arial", Font.PLAIN, 12));
			rtimeLabel.setBounds(62, 17, 51, 16);
			recievePanel.add(rtimeLabel);
			
			
	
		
	}
	
    private static final long serialVersionUID = 1L;

    JPanel test = new JPanel();
    private JTextField messageTextField;
    private JTextField textField;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        test.setBounds(0, 0, panelWidth, contentPaneH);
        test.setBackground(new Color(238, 39, 91, 200));
        add(test);
    }
}