package com.example.demo.ide;

import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;

public class assistant  {

	private JFrame frame;
	private JPanel form;
	private JPanel line;
	private JTextField username;
	private JLabel lblNewLabel;
	private JTextField email;
	private JTextField password;
	private JTable table;
	private JButton save;
	private String[] head=new String[] {
			"ID","USERNAME", "EMAIL", "PASSWORD"
		};
	private UserRepository userDao;
	private JPanel panel;
	public assistant(UserRepository userDao) {
		System.setProperty( "java.awt.headless", "false" );
		this.userDao=userDao;
	//	List<User> users=userDao.findAll().toArray();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 423);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		JPanel pBody=new JPanel();
		frame.getContentPane().add(pBody);
		frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		pBody.setLayout(new GridLayout(0, 1, 0, 10));
		
		form = new JPanel();
		pBody.add(form);
		form.setLayout(new GridLayout(0, 1, 0, 0));
		
		line = new JPanel();
		form.add(line);
		line.setLayout(new GridLayout(0, 2, 0, 0));
		
		lblNewLabel = new JLabel("USERNAME ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		line.add(lblNewLabel);
		
		username = new JTextField();
		line.add(username);
		username.setColumns(10);
		
		JPanel line_1 = new JPanel();
		form.add(line_1);
		line_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblEmail = new JLabel("EMAIL ");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		line_1.add(lblEmail);
		
		email = new JTextField();
		email.setColumns(10);
		line_1.add(email);
		
		JPanel line_2 = new JPanel();
		form.add(line_2);
		line_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblPassword = new JLabel("PASSWORD ");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		line_2.add(lblPassword);
		
		password = new JTextField();
		password.setColumns(10);
		line_2.add(password);
		
		save = new JButton("SAVE");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User u=new User(null,username.getText(),email.getText(),password.getText());
				userDao.save(u);
				table.setModel(getModel());
				}
		});
		form.add(save);
		
		JScrollPane scrollPane = new JScrollPane();
		pBody.add(scrollPane);
		
		table = new JTable();
		table.setModel(getModel());
		scrollPane.setViewportView(table);
pBody.repaint();
pBody.revalidate();
	}
	private myTableModel getModel() {
		List<User> us=userDao.findAll();
		return new myTableModel(head,us);
	}


	
}

