package ArregloListaArreglosEjercicios;

import java.applet.Applet;
import java.awt.event.*;
import java.awt.*;
import MyLibrary.Bibliotec;

public class BibliotecaUI extends Applet implements ActionListener,MouseListener{
	
	private Bibliotec bibliotec = new Bibliotec();
	private String displayPath = "";
	
	private Button[] buttons = new Button[19];
	private String[] buttonNames = {"Display All Users","Display All Books","Create New User","Add Book","Ok","Home","Change","Delete","Search","Search User","Search Book","Search User Id","Search User Name","Search User Age","Search User DateCreated","Search Book Id","Search Book Name","Search Book Author","Search Book Pages"};
	
	private TextField[] fields = new TextField[7];
	private String userNameValue = "",emailValue = "",bookNameValue = "",bookAuthorValue = "";
	private int ageValue = 0,bookPagesValue = 0;
	
	private Label[] labels = new Label[7];
	private String[] labelNames = {"Name","Age","Email","Book Name","Author Name","Pages","Search"};
	
	private boolean createStatus = false;
	private int indexUI;
	private int yPosition;
	private String changeStatus = "";
	
	private int searchIdValue;
	
	private void setHome() {
		
		reset();
		hideAllFields();
		
		for(int i = 4; i < buttons.length; i++) {
			
			buttons[i].setVisible(false);
			
		}
		
		buttons[0].setVisible(true);
		buttons[1].setVisible(true);
		buttons[2].setVisible(true);
		buttons[3].setVisible(true);
		buttons[8].setVisible(true);
		
	}
	
	private void reset() {
		
		userNameValue = "";
		emailValue = "";
		bookNameValue = "";
		bookAuthorValue = "";
		ageValue = 0;
		bookPagesValue = 0;
		createStatus = false;
		
		for(int i = 0; i < fields.length; i++) {
			
			fields[i].setText("");
			
		}
		
	}
	
	private void hideAllFields() {
		
		for(int i = 0;i < fields.length; i++) {
			
			fields[i].setVisible(false);
			labels[i].setVisible(false);
			
		}
		
	}
	
	public void init() {
		
		setSize(1365,650);
		
		
		for(int i = 0; i < fields.length; i++) {
			
			labels[i] = new Label(labelNames[i]);
			add(labels[i]);
			labels[i].setVisible(false);
			
			fields[i] = new TextField(25);
			fields[i].addActionListener(this);
			add(fields[i]);
			
			
		}
				
		for(int i = 0; i < buttons.length; i++) {
		
			buttons[i] = new Button(buttonNames[i]);
			buttons[i].addActionListener(this);
			add(buttons[i]);
						
		}
		
		
		setHome();
		
		displayPath = "home";
		
		addMouseListener(this);
		
	}
	
	public void paint(Graphics g) {
		
		if(displayPath == "home") {
			
			g.setColor(Color.blue);
			g.drawString("Welcome to the System,please select one opction",50,100);
			
		}else if(displayPath == "displayBooks") {
			
			bibliotec.displayBooks(g);
			
		}else if(displayPath == "displayUsers") {
			
			bibliotec.displayUsers(g);
			
		}else if(displayPath == "createUser") {
			
			g.setColor(Color.blue);
			g.drawString("Please fill the Information and click OK",50,100);
			
			g.setColor(Color.black);
			
			if(userNameValue != "")
				g.drawString("User Name: " + userNameValue,50,100 + 15 * 2);
			
			if(ageValue != 0)
				g.drawString("User Age: " + ageValue,50,100 + 15 * 3);
			
			if(emailValue != "")
				g.drawString("User Email: " + emailValue,50,100 + 15 * 4);
				
			if(createStatus) {
				
				g.setColor(Color.green);
				g.drawString("User has been successfuly created!!!",50,100 + 15 * 6);
				reset();
				
			}
			
		}else if(displayPath == "addBook") {
			
			g.setColor(Color.blue);
			g.drawString("Please fill the Information and click OK",50,100);
			
			g.setColor(Color.black);
			
			if(bookNameValue != "")
				g.drawString("Book Name: " + bookNameValue,50,100 + 15 * 2);
			
			if(bookAuthorValue != "")
				g.drawString("Author Name: " + bookAuthorValue,50,100 + 15 * 3);
			
			if(bookPagesValue != 0)
				g.drawString("Pages: " + bookPagesValue,50,100 + 15 * 4);
				
			if(createStatus) {
				
				g.setColor(Color.green);
				g.drawString("The Book has been successfuly added!!!",50,100 + 15 * 6);
				reset();
				
			}
			
		}else if(displayPath == "testDataFlow") {
			
			g.setColor(Color.black);
			g.drawString("yPosition: " + yPosition,50,50);
			g.drawString("indexUI: " + indexUI,50,50 + 15);
			
		}else if(displayPath == "searchUserId") {
			
			bibliotec.searchUserId(g,Integer.parseInt(fields[6].getText()));
			
		}else if(displayPath == "searchUserName") {
			
			bibliotec.searchUserName(g,fields[6].getText());
			
		}else if(displayPath == "searchUserAge") {
			
			bibliotec.searchUserAge(g,Integer.parseInt(fields[6].getText()));
			
		}else if(displayPath == "searchUserDateCreated") {
			
			bibliotec.searchUserDateCreated(g,fields[6].getText());
			
		}else if(displayPath == "searchBookId") {
			
			bibliotec.searchBookId(g,Integer.parseInt(fields[6].getText()));
			
		}else if(displayPath == "searchBookName") {
			
			bibliotec.searchBookName(g,fields[6].getText());
			
		}else if(displayPath == "searchBookAuthor") {
			
			bibliotec.searchBookAuthor(g,fields[6].getText());
			
		}else if(displayPath == "searchBookPages") {
			
			bibliotec.searchBookPages(g,Integer.parseInt(fields[6].getText()));
			
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(displayPath == "displayUsers" || displayPath == "displayBooks") {
			
			
		
			yPosition = e.getY();
			indexUI = bibliotec.getIndex(yPosition);
			bibliotec.setIndexSelected(indexUI);			
			
			// displayPath = "testDataFlow";
		
		}
		
		repaint();
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == buttons[0]) {
			
			// display all users button
			
			buttons[6].setVisible(true);
			buttons[7].setVisible(true);
			displayPath = "displayUsers";
			
		}else if(e.getSource() == buttons[1]) {
			
			// display all books button
			
			buttons[6].setVisible(true);
			buttons[7].setVisible(true);
			displayPath = "displayBooks";
			
		}else if(e.getSource() == buttons[2]) {
			
			// create new user
			
			buttons[0].setVisible(false);
			buttons[1].setVisible(false);
			buttons[2].setVisible(false);
			buttons[3].setVisible(false);
			buttons[6].setVisible(false);
			buttons[7].setVisible(false);
			buttons[8].setVisible(false);
			
			labels[0].setVisible(true);
			fields[0].setVisible(true);
			//fields[0].setText("User Name");
			
			labels[1].setVisible(true);
			fields[1].setVisible(true);
			//fields[1].setText("User Age");
			
			labels[2].setVisible(true);
			fields[2].setVisible(true);	
			//fields[2].setText("User Email Address");
			
			buttons[4].setVisible(true);
			buttons[5].setVisible(true);
			
			displayPath = "createUser";
			
		}else if(e.getSource() == buttons[3]) {
			
			//add book
			
			buttons[0].setVisible(false);
			buttons[1].setVisible(false);
			buttons[2].setVisible(false);
			buttons[3].setVisible(false);
			buttons[6].setVisible(false);
			buttons[7].setVisible(false);
			buttons[8].setVisible(false);
			
			labels[3].setVisible(true);
			fields[3].setVisible(true);
			//fields[3].setText("Book Name");
			
			labels[4].setVisible(true);
			fields[4].setVisible(true);
			//fields[4].setText("Book Author Name");
			
			labels[5].setVisible(true);
			fields[5].setVisible(true);	
			//fields[5].setText("Book Pages");
			
			buttons[4].setVisible(true);
			buttons[5].setVisible(true);
						
			displayPath = "addBook";
			
		}else if(e.getSource() == buttons[4]) {
			
			// ok button 
			
			if(displayPath == "createUser") {
				
				try {
				
					bibliotec.createNewUser(userNameValue,ageValue,emailValue);
					createStatus = true;
				
				}catch(Exception ex) {
					
					createStatus = false;
					
				}
				
			}else if(displayPath == "addBook") {
				
				try {
					
					bibliotec.addBook(bookNameValue,bookAuthorValue,bookPagesValue);
					createStatus = true;
				
				}catch(Exception ex) {
					
					createStatus = false;
					
				}
				
			}
			
		}else if(e.getSource() == buttons[5]) {
			
			// home button 
			
			setHome();
			
			displayPath = "home";
			
		}else if(e.getSource() == buttons[6]) {
			
			// change button
			
			if(displayPath == "displayUsers") {
				
				// create new user
				
				buttons[0].setVisible(false);
				buttons[1].setVisible(false);
				buttons[2].setVisible(false);
				buttons[3].setVisible(false);
				buttons[6].setVisible(false);
				buttons[7].setVisible(false);
				
				
				labels[0].setVisible(true);
				fields[0].setVisible(true);
				//fields[0].setText("User Name");
				
				labels[1].setVisible(true);
				fields[1].setVisible(true);
				//fields[1].setText("User Age");
				
				labels[2].setVisible(true);
				fields[2].setVisible(true);	
				//fields[2].setText("User Email Address");
				
				buttons[4].setVisible(true);
				buttons[5].setVisible(true);
				
				//fields[0] =  
				
				//bibliotec.changeUser(indexUI);
				
			}else if(displayPath == "displayBooks") {
				
				//change book
				
				buttons[0].setVisible(false);
				buttons[1].setVisible(false);
				buttons[2].setVisible(false);
				buttons[3].setVisible(false);
				buttons[6].setVisible(false);
				buttons[7].setVisible(false);
				
				
				labels[3].setVisible(true);
				fields[3].setVisible(true);
				//fields[3].setText("Book Name");
				
				labels[4].setVisible(true);
				fields[4].setVisible(true);
				//fields[4].setText("Book Author Name");
				
				labels[5].setVisible(true);
				fields[5].setVisible(true);	
				//fields[5].setText("Book Pages");
				
				buttons[4].setVisible(true);
				buttons[5].setVisible(true);
				
				bibliotec.changeBook(indexUI);
				
			}
			
		}else if(e.getSource() == buttons[7]) {
			
			// erase button
			
			if(displayPath == "displayUsers") {
				
				bibliotec.eraseUser(indexUI);
				
			}else if(displayPath == "displayBooks") {
				
				bibliotec.eraseBook(indexUI);
				
			}
			
		}else if(e.getSource() == buttons[8]) {
			
			// search button
			
			fields[6].setVisible(false);
			
			buttons[0].setVisible(false);
			buttons[1].setVisible(false);
			buttons[2].setVisible(false);
			buttons[3].setVisible(false);
			buttons[4].setVisible(false);
			buttons[5].setVisible(true);
			buttons[6].setVisible(false);
			buttons[7].setVisible(false);
			buttons[8].setVisible(false);
			buttons[11].setVisible(false);
			buttons[12].setVisible(false);
			buttons[13].setVisible(false);
			buttons[14].setVisible(false);
			buttons[15].setVisible(false);
			buttons[16].setVisible(false);
			buttons[17].setVisible(false);
			buttons[18].setVisible(false);
			
			buttons[9].setVisible(true);
			buttons[10].setVisible(true);
			
			displayPath = "search";
			
			
		}else if(e.getSource() == buttons[9]) {
			
			// search user
			
			fields[6].setVisible(true);
			
			buttons[5].setVisible(true);
			buttons[8].setVisible(true);
			buttons[9].setVisible(false);
			buttons[10].setVisible(false);
			buttons[11].setVisible(true);
			buttons[12].setVisible(true);
			buttons[13].setVisible(true);
			buttons[14].setVisible(true);
			
		}else if(e.getSource() == buttons[10]) {
			
			// search book
			
			fields[6].setVisible(true);
			
			buttons[5].setVisible(true);
			buttons[8].setVisible(true);
			buttons[9].setVisible(false);
			buttons[10].setVisible(false);
			buttons[15].setVisible(true);
			buttons[16].setVisible(true);
			buttons[17].setVisible(true);
			buttons[18].setVisible(true);
			
		}else if(e.getSource() == buttons[11]) {
			
			// search user by id
			
			displayPath = "searchUserId";
			
		}else if(e.getSource() == buttons[12]) {
			
			// search user by name
			
			displayPath = "searchUserName";
			
		}else if(e.getSource() == buttons[13]) {
			
			// search user by age
			
			displayPath = "searchUserAge";
			
		}else if(e.getSource() == buttons[14]) {
			
			// search user by dateCreated
			
			displayPath = "searchUserDateCreated";
			
		}else if(e.getSource() == buttons[15]) {
			
			// search book by id
			
			displayPath = "searchBookId";
			
		}else if(e.getSource() == buttons[16]) {
			
			// search book by name
			
			displayPath = "searchBookName";
			
		}else if(e.getSource() == buttons[17]) {
			
			// search book by author
			
			displayPath = "searchBookAuthor";
			
		}else if(e.getSource() == buttons[18]) {
			
			// search book by pages
			
			displayPath = "searchBookPages";
			
		}
		
		else if(e.getSource() == fields[0]) {
			
			// user name field
			
			userNameValue = fields[0].getText();
			
		}else if(e.getSource() == fields[1]) {
			
			// age field
			
			ageValue = Integer.parseInt(fields[1].getText());
			
		}else if(e.getSource() == fields[2]) {
			
			// email address field
			
			emailValue = fields[2].getText();
			
		}else if(e.getSource() == fields[3]) {
			
			// book name field
			
			bookNameValue = fields[3].getText();
			
		}else if(e.getSource() == fields[4]) {
			
			// book author field
			
			bookAuthorValue = fields[4].getText();
			
		}else if(e.getSource() == fields[5]) {
			
			// book pages field
			
			bookPagesValue = Integer.parseInt(fields[5].getText());
			
		}
		
		repaint();
		
	}
	
	

}
