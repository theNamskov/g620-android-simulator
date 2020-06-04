import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.border.LineBorder;

public class ContactsApp extends AppDefault {
	private String[] contactNames = { "Ahornam", "Nii", "Titus", "Francisca", "Ella", "Adjoa" };
	private String[] contactNumber = { "0545712836", "0545712836", "0545712836", "0545712836", "0545712836",
			"0545712836" };
	int sizer = 0;
	int starter = 0;
	int a = 0;
	JPanel[] singConPanel = new JPanel[20];
	JLabel[] singContactLabel = new JLabel[20];
	Random random = new Random();
	JPanel contactsPanel = new JPanel();
	JPanel searchPanel = new JPanel();
	JLabel contactsLab = new JLabel();
	JLabel contactsLabel = new JLabel();
	JLabel recentLab = new JLabel();
	JLabel recentLabel = new JLabel();

	public ContactsApp() {
		setLayout(null);
		// MAIN SEARCH PANEL
		searchPanel = new JPanel();
		searchPanel.setBackground(new Color(33, 55, 77));
		searchPanel.setBounds(0, 0, 290, 127);
		add(searchPanel);
		searchPanel.setLayout(null);

		// MAIN CONTACTS PANEL
		contactsPanel = new JPanel();
		contactsPanel.setBackground(new Color(33, 55, 77));
		contactsPanel.setBounds(0, 124, 290, 386);
		add(contactsPanel);
		contactsPanel.setLayout(null);

		defHome();
		defSearch();
		showContacts(false, "");

	}

	// SHOW ALL CONTACTS FUNCTION
	public void showContacts(boolean search, String Name) {

		if (search == false) {
			sizer = 10;
			for (a = 0; a < 6; a++) {
				singConPanel[a] = new JPanel();
				singConPanel[a].setBackground(new Color(33, 55, 77));
				singConPanel[a].setBorder(new LineBorder(new Color(33, 55, 77)));
				singConPanel[a].setBounds(10, sizer, 270, 35);
				contactsPanel.add(singConPanel[a]);
				singConPanel[a].setLayout(null);

				singContactLabel[a] = new JLabel("  " + contactNames[a]);
				singContactLabel[a].addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						JLabel src = (JLabel) arg0.getSource();
						String Name = src.getText();
						showSingContact(Name);
					}

					@Override
					public void mouseEntered(MouseEvent e) {

					}

					@Override
					public void mouseExited(MouseEvent e) {
					}
				});

				int imgNum = random.nextInt(4) + 1;
				singContactLabel[a].setIcon(
						new ImageIcon(ContactsApp.class.getResource("/asset/img/icon/conImg" + imgNum + ".png")));
				singContactLabel[a].setFont(new Font("Arial", Font.PLAIN, 19));
				singContactLabel[a].setForeground(new Color(192, 192, 192));
				singContactLabel[a].setBounds(20, 0, 250, 35);
				singConPanel[a].add(singContactLabel[a]);
				sizer += 37;

			}
		}
		if (search == true) {
			sizer = 10;
			for (a = 0; a < 6; a++) {
				if (Name.equals(contactNames[a])) {
					singConPanel[a] = new JPanel();
					singConPanel[a].setBackground(new Color(33, 55, 77));
					singConPanel[a].setBorder(new LineBorder(new Color(33, 55, 77)));
					singConPanel[a].setBounds(10, sizer, 270, 35);
					contactsPanel.add(singConPanel[a]);
					singConPanel[a].setLayout(null);

					singContactLabel[a] = new JLabel("  " + contactNames[a]);
					singContactLabel[a].addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							JLabel src = (JLabel) arg0.getSource();
							String Name = src.getText();
							showSingContact(Name);
						}
						// @Override
						// public void mouseEntered(MouseEvent e) {

						// }
						// @Override
						// public void mouseExited(MouseEvent e) {
						// }
					});

					int imgNum = random.nextInt(4) + 1;
					singContactLabel[a].setIcon(
							new ImageIcon(ContactsApp.class.getResource("/asset/img/icon/conImg" + imgNum + ".png")));
					singContactLabel[a].setFont(new Font("Arial", Font.PLAIN, 19));
					singContactLabel[a].setForeground(new Color(192, 192, 192));
					singContactLabel[a].setBounds(20, 0, 250, 35);
					singConPanel[a].add(singContactLabel[a]);
					sizer += 37;
					return;
				}

			}
			singConPanel[a] = new JPanel();
			singConPanel[a].setBackground(new Color(33, 55, 77));
			singConPanel[a].setBorder(new LineBorder(new Color(33, 55, 77)));
			singConPanel[a].setBounds(10, sizer, 270, 35);
			contactsPanel.add(singConPanel[a]);
			singConPanel[a].setLayout(null);
			singContactLabel[a] = new JLabel("Not Found");
			singContactLabel[a].setFont(new Font("Arial", Font.PLAIN, 19));
			singContactLabel[a].setForeground(new Color(192, 192, 192));
			singContactLabel[a].setBounds(20, 0, 250, 35);
			singConPanel[a].add(singContactLabel[a]);

		}
	}

	// SHOW SINGLE CONTACTS FUNCTION
	public void showSingContact(String Name) {
		contactsPanel.removeAll();
		contactsPanel.revalidate();
		contactsPanel.repaint();
		JLabel imgLab = new JLabel("New label");
		imgLab.setIcon(new ImageIcon(ContactsApp.class.getResource("/asset/img/icon/sinContact.png")));
		imgLab.setBounds(80, 15, 100, 100);
		contactsPanel.add(imgLab);

		JLabel nameLab = new JLabel("Name :");
		nameLab.setForeground(Color.LIGHT_GRAY);
		nameLab.setFont(new Font("Lato", Font.PLAIN, 20));
		nameLab.setBounds(10, 140, 70, 40);
		contactsPanel.add(nameLab);

		JLabel telLab = new JLabel("Tel     :");
		telLab.setForeground(Color.LIGHT_GRAY);
		telLab.setFont(new Font("Lato", Font.PLAIN, 20));
		telLab.setBounds(10, 185, 70, 40);
		contactsPanel.add(telLab);

		JLabel namlabIns = new JLabel(Name);
		namlabIns.setForeground(Color.LIGHT_GRAY);
		namlabIns.setFont(new Font("Lato", Font.PLAIN, 20));
		namlabIns.setBounds(90, 140, 188, 40);
		contactsPanel.add(namlabIns);

		JLabel telLabIns = new JLabel(contactNumber[4]);
		telLabIns.setForeground(Color.LIGHT_GRAY);
		telLabIns.setFont(new Font("Lato", Font.PLAIN, 20));
		telLabIns.setBounds(83, 185, 182, 40);
		contactsPanel.add(telLabIns);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2
				.setIcon(new ImageIcon(ContactsApp.class.getResource("/asset/img/icon/icons8-new-message-34 (3).png")));
		lblNewLabel_2.setBounds(23, 281, 34, 34);
		contactsPanel.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("New label");
		lblNewLabel_2_1.setIcon(new ImageIcon(ContactsApp.class.getResource("/asset/img/icon/call-icon.png")));
		lblNewLabel_2_1.setBounds(89, 281, 34, 34);
		contactsPanel.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("New label");
		lblNewLabel_2_1_1
				.setIcon(new ImageIcon(ContactsApp.class.getResource("/asset/img/icon/icons8-edit-34 (1).png")));
		lblNewLabel_2_1_1.setBounds(157, 281, 34, 34);
		contactsPanel.add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_2_1_2 = new JLabel("New label");
		lblNewLabel_2_1_2
				.setIcon(new ImageIcon(ContactsApp.class.getResource("/asset/img/icon/icons8-delete-bin-34.png")));
		lblNewLabel_2_1_2.setBounds(221, 281, 34, 34);
		contactsPanel.add(lblNewLabel_2_1_2);
	}

	// DEFAULT HOME FUNCTION
	public void defHome() {
		JPanel recentAndContactsPanel = new JPanel();
		recentAndContactsPanel.setBackground(new Color(33, 55, 77));
		recentAndContactsPanel.setBounds(0, 510, 290, 60);
		add(recentAndContactsPanel);
		recentAndContactsPanel.setLayout(null);

		recentLabel = new JLabel("New label");
		recentLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				contactsLab.setForeground(Color.LIGHT_GRAY);
				contactsLabel.setIcon(new ImageIcon(ContactsApp.class.getResource("/asset/img/icon/allContact1.png")));

				recentLabel.setIcon(new ImageIcon(ContactsApp.class.getResource("/asset/img/icon/recent2.png")));
				recentLab.setForeground(new Color(123, 104, 238));

				recents();
			}
		});
		recentLabel.setIcon(new ImageIcon(ContactsApp.class.getResource("/asset/img/icon/recent1.png")));
		recentLabel.setBounds(40, 0, 34, 34);
		recentAndContactsPanel.add(recentLabel);

		recentLab = new JLabel(" Recents");
		recentLab.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				contactsLab.setForeground(Color.LIGHT_GRAY);
				contactsLabel.setIcon(new ImageIcon(ContactsApp.class.getResource("/asset/img/icon/allContact1.png")));

				recentLabel.setIcon(new ImageIcon(ContactsApp.class.getResource("/asset/img/icon/recent2.png")));
				recentLab.setForeground(new Color(123, 104, 238));
				recents();
			}
		});

		recentLab.setHorizontalAlignment(SwingConstants.CENTER);
		recentLab.setForeground(Color.LIGHT_GRAY);
		recentLab.setBounds(22, 34, 60, 23);
		recentAndContactsPanel.add(recentLab);

		contactsLabel = new JLabel("New label");
		contactsLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				contactsPanel.removeAll();
				contactsPanel.revalidate();
				contactsPanel.repaint();
				showContacts(false, "");
				defSearch();
				contactsLab.setForeground(new Color(123, 104, 238));
				contactsLabel.setIcon(new ImageIcon(ContactsApp.class.getResource("/asset/img/icon/allContact2.png")));

				recentLabel.setIcon(new ImageIcon(ContactsApp.class.getResource("/asset/img/icon/recent1.png")));
				recentLab.setForeground(Color.LIGHT_GRAY);
			}
		});
		contactsLabel.setIcon(new ImageIcon(ContactsApp.class.getResource("/asset/img/icon/allContact2.png")));
		contactsLabel.setBounds(200, 0, 34, 34);
		recentAndContactsPanel.add(contactsLabel);

		contactsLab = new JLabel(" Contacts");
		contactsLab.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				contactsPanel.removeAll();
				contactsPanel.revalidate();
				contactsPanel.repaint();
				showContacts(false, "");
				defSearch();
				contactsLab.setForeground(new Color(123, 104, 238));
				contactsLabel.setIcon(new ImageIcon(ContactsApp.class.getResource("/asset/img/icon/allContact2.png")));

				recentLabel.setIcon(new ImageIcon(ContactsApp.class.getResource("/asset/img/icon/recent1.png")));
				recentLab.setForeground(Color.LIGHT_GRAY);
			}
		});
		contactsLab.setHorizontalAlignment(SwingConstants.CENTER);
		contactsLab.setForeground(new Color(123, 104, 238));
		contactsLab.setBounds(185, 37, 60, 23);
		recentAndContactsPanel.add(contactsLab);
	}

	// DEFAULT SEARCH FUNCTION
	public void defSearch() {
		searchPanel.removeAll();
		searchPanel.revalidate();
		searchPanel.repaint();

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(192, 192, 192), 2, true));
		panel.setBackground(new Color(33, 55, 77));
		panel.setBounds(10, 26, 234, 35);
		searchPanel.add(panel);
		panel.setLayout(null);

		textField = new JTextField();
		textField.setForeground(Color.LIGHT_GRAY);
		textField.setBounds(0, 0, 233, 34);
		textField.setBackground(new Color(33, 55, 77));
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Name = textField.getText();
				contactsPanel.removeAll();
				contactsPanel.revalidate();
				contactsPanel.repaint();
				showContacts(true, Name);
			}
		});
		lblNewLabel.setBounds(253, 26, 34, 34);
		searchPanel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(ContactsApp.class.getResource("/asset/img/icon/icons8-search-32.png")));

		JLabel addNewContactLabel = new JLabel("    +Add new contact");
		addNewContactLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}
		});
		addNewContactLabel.setHorizontalAlignment(SwingConstants.CENTER);
		addNewContactLabel.setIcon(new ImageIcon(ContactsApp.class.getResource("/asset/img/icon/baddContact.png")));
		addNewContactLabel.setForeground(new Color(123, 104, 238));
		addNewContactLabel.setBounds(20, 81, 213, 30);
		searchPanel.add(addNewContactLabel);

	}

	// NOW DEALING WITH RECENT CONTACTS

	public void recents() {
		contactsPanel.removeAll();
		contactsPanel.revalidate();
		contactsPanel.repaint();

		searchPanel.removeAll();
		searchPanel.revalidate();
		searchPanel.repaint();

		JPanel allpanel = new JPanel();
		allpanel.setBackground(new Color(123, 104, 238));
		allpanel.setBounds(80, 30, 50, 30);
		searchPanel.add(allpanel);
		allpanel.setLayout(null);

		JLabel allLab = new JLabel("ALL\r\n");

		allLab.setForeground(Color.DARK_GRAY);
		allLab.setHorizontalAlignment(SwingConstants.CENTER);
		allLab.setFont(new Font("Lato", Font.PLAIN, 13));
		allLab.setBounds(0, 0, 50, 30);
		allpanel.add(allLab);

		JPanel misedPanel = new JPanel();
		misedPanel.setBackground(Color.LIGHT_GRAY);
		misedPanel.setBounds(130, 30, 50, 30);
		searchPanel.add(misedPanel);
		misedPanel.setLayout(null);

		JLabel Missedlab = new JLabel("MISSED\r\n\r\n");
		Missedlab.setForeground(Color.DARK_GRAY);
		Missedlab.setHorizontalAlignment(SwingConstants.CENTER);
		Missedlab.setFont(new Font("Lato", Font.PLAIN, 13));
		Missedlab.setBounds(0, 0, 50, 30);
		misedPanel.add(Missedlab);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 120, 270, 2);
		searchPanel.add(separator);

		JLabel TimeLabel = new JLabel("Today");
		TimeLabel.setForeground(Color.LIGHT_GRAY);
		TimeLabel.setFont(new Font("Lato", Font.PLAIN, 15));
		TimeLabel.setBounds(15, 92, 104, 30);
		searchPanel.add(TimeLabel);

		allLab.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				allpanel.setBackground(new Color(123, 104, 238));
				misedPanel.setBackground(Color.LIGHT_GRAY);
				allRecentCalls();

			}
		});
		Missedlab.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				misedPanel.setBackground(new Color(123, 104, 238));
				allpanel.setBackground(Color.LIGHT_GRAY);

				AllMissed();
			}
		});

		allRecentCalls();
	}

	public void allRecentCalls() {

		contactsPanel.removeAll();
		contactsPanel.revalidate();
		contactsPanel.repaint();

		JLabel missedImg = new JLabel("New label");
		missedImg.setIcon(new ImageIcon(ContactsApp.class.getResource("/asset/img/icon/conImg3.png")));
		missedImg.setBounds(15, 20, 34, 34);
		contactsPanel.add(missedImg);

		JLabel lblNewLabel_1 = new JLabel("Ahornam");
		lblNewLabel_1.setFont(new Font("Lato", Font.PLAIN, 17));
		lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1.setBounds(60, 10, 175, 24);
		contactsPanel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("  10:16");
		lblNewLabel_1_1.setIcon(new ImageIcon(ContactsApp.class.getResource("/asset/img/icon/missedcall.png")));
		lblNewLabel_1_1.setBackground(Color.RED);
		lblNewLabel_1_1.setForeground(Color.RED);
		lblNewLabel_1_1.setFont(new Font("Lato", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(61, 37, 163, 24);
		contactsPanel.add(lblNewLabel_1_1);

		JLabel missedImg_1 = new JLabel("New label");
		missedImg_1.setIcon(new ImageIcon(ContactsApp.class.getResource("/asset/img/icon/conImg1.png")));
		missedImg_1.setBounds(15, 84, 34, 34);
		contactsPanel.add(missedImg_1);

		JLabel lblNewLabel_1_2 = new JLabel("Nii");
		lblNewLabel_1_2.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1_2.setFont(new Font("Lato", Font.PLAIN, 17));
		lblNewLabel_1_2.setBounds(60, 74, 175, 24);
		contactsPanel.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_1_1 = new JLabel("  10:45\r\n");
		lblNewLabel_1_1_1.setIcon(new ImageIcon(ContactsApp.class.getResource("/asset/img/icon/incall.png")));
		lblNewLabel_1_1_1.setForeground(new Color(0, 128, 0));
		lblNewLabel_1_1_1.setFont(new Font("Lato", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBackground(Color.RED);
		lblNewLabel_1_1_1.setBounds(60, 98, 163, 24);
		contactsPanel.add(lblNewLabel_1_1_1);

		JLabel missedImg_1_1 = new JLabel("New label");
		missedImg_1_1.setIcon(new ImageIcon(ContactsApp.class.getResource("/asset/img/icon/conImg4.png")));
		missedImg_1_1.setBounds(15, 141, 34, 34);
		contactsPanel.add(missedImg_1_1);

		JLabel lblNewLabel_1_3 = new JLabel("Ahornam");
		lblNewLabel_1_3.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1_3.setFont(new Font("Lato", Font.PLAIN, 17));
		lblNewLabel_1_3.setBounds(60, 132, 175, 24);
		contactsPanel.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("  11:45\r\n");
		lblNewLabel_1_1_1_1.setIcon(new ImageIcon(ContactsApp.class.getResource("/asset/img/icon/callout.png")));
		lblNewLabel_1_1_1_1.setForeground(new Color(100, 149, 237));
		lblNewLabel_1_1_1_1.setFont(new Font("Lato", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1.setBackground(Color.RED);
		lblNewLabel_1_1_1_1.setBounds(61, 160, 163, 24);
		contactsPanel.add(lblNewLabel_1_1_1_1);

	}

	public void AllMissed() {

		contactsPanel.removeAll();
		contactsPanel.revalidate();
		contactsPanel.repaint();

		JLabel missedImg = new JLabel("New label");
		missedImg.setIcon(new ImageIcon(ContactsApp.class.getResource("/asset/img/icon/conImg3.png")));
		missedImg.setBounds(15, 20, 34, 34);
		contactsPanel.add(missedImg);

		JLabel lblNewLabel_1 = new JLabel("Ahornam");
		lblNewLabel_1.setFont(new Font("Lato", Font.PLAIN, 17));
		lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1.setBounds(60, 10, 175, 24);
		contactsPanel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("  10:16");
		lblNewLabel_1_1.setIcon(new ImageIcon(ContactsApp.class.getResource("/asset/img/icon/missedcall.png")));
		lblNewLabel_1_1.setBackground(Color.RED);
		lblNewLabel_1_1.setForeground(Color.RED);
		lblNewLabel_1_1.setFont(new Font("Lato", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(61, 37, 163, 24);
		contactsPanel.add(lblNewLabel_1_1);

	}

	private static final long serialVersionUID = 1L;

	JPanel test = new JPanel();
	private JTextField textField;

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		test.setBounds(0, 0, panelWidth, contentPaneH);
		test.setBackground(new Color(38, 129, 61, 200));
		add(test);
	}
}