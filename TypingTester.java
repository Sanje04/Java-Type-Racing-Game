 /* Grade 11 ISU Project
 * Name: Sanje Divakaran
 * Purpose: Type Racing Game
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
public class TypingTester {
	
	//Fonts that can be used for J Frame
	static Font font1 = new Font("SansSerif", Font.BOLD, 20);
	static Font font2 = new Font("JAF Facit",Font.BOLD,0);
	
	//Empty Border
	static EmptyBorder border1 = new EmptyBorder(0, 0, 0, 0);
	
	//The words that will be used for the program for Random Words
	static JLabel word1,word2,word3,word4,word11,word21,word31,word41;
	
	static JLabel correct,error,wpm;
	
	//Words that will be used for the Paragraph Game
	static JLabel sent1,sent2;
	static JTextArea textp;
	
	
	//Variables
	//wordno used to represent what word the user is currently on
	//corrects and errors show the amount of words the user typed correctly or incorrectly
	//t is the time 
	
	static int gameSelect = 1, difficulty = 1;
	
	
	static int wordno = 0, corrects = 0, errors = 0, timeopt = 30, timepast = 0;
	static int parano=0;
	
	static int cwpm = 0;
	
	static String[] testWords = new String[4];
	
	//static int wpmCounter = (corrects / timepast) * 60;

	static String[] words = {"Raisin", "Tape", "Watch", "Face", "Pencil", "Good", "Damage", "Back",
			
	          "Evited", "Vitals", "lookum", "Coyote", "logjam", "baruch", "Foully", "prowar", "Dowery",
	          "Livery", "cabman", "bratty", "Walras", "amends", "lochus", "Coyish", "devest", "Tuareg", 
	          "Shrunk", "minion", "cannon", "Muslim", "bomber", "kermit", "Gorger", "napalm", "Hanger", 
	          
	          "Trust", "total", "siege", "Waist", "outer", "south", "Opera", "tooth", "Study",
	          "Whole", "stake", "climb", "North", "stamp", "brown", "Shine", "wrong", "Proof",
	          "Large", "abbey", "guest", "Snarl", "space", "steak", "Blank", "limit", "Major",
	          
	          "Pace", "bank", "boat", "Neck", "bald", "line", "Mill", "wing", "Well",
	          "Ally", "lamb", "boom", "Soup", "flag", "cute", "Pity", "cook", "Cell",
	          "Shop", "make", "home", "Rice", "cash", "bite", "Help", "oven", "Fork",
	          
	          "Pig", "tie", "sea", "Fan", "bay", "die", "Way", "cry", "Era",
	          "End", "leg", "fur", "Fox", "old", "dip", "Oil", "lie", "Hip"};

	static String[] paragraphs = {
			"Baseball has been the national pastime in the United States since the middle of the 1800s.",
			"Each period has had a unique flavour, and it is sometimes useful to read about a period",
			"from the perspective of the time in which it took place. The following comes from",
			"\"Spalding's Baseball Guide and Official League Book for 1889,\" written in that same year;",
			"the language has not been edited to reflect modern expressions or word usage.",
			"The Joint Rules Committee and their work",
			"The work accomplished by the Joint Rules Committee of the National League and the American Association",
			"at their meeting in New York in November, 1888, ranks with the best on record in the revision",
			" of the playing rules of the game, and the successful results achieved in improving the code",
			" were largely due to the marked efficiency evinced by the chairman of the Committee, Mr. Chas. H. Byrne,",
			"the president of the Brooklyn Club, who was indefatigable in doing the large amount of revisory work",
			"which was thrown upon the committee. In the face of a very noisy and sensational demand for radical changes",
			"in the rules governing the game, the committee, as a whole, manifested a wise conservatism in several respects,",
			"which cannot help but be of material assistance in advancing the welfare of the game at large.",
			"In the first place, by reducing the powers of the attack nearer to an equality with those of the defense",
			"which result was accomplished when they reduced the number of called balls from five to four",
			"they not only adopted a rule which will moderate the dangerous speed in delivering the ball to the bat,",
			"but they thereby afforded the batsman an additional chance for more effective work at the bat.",
			"This latter point, too, has been aided by reducing the number of outs the batsman has hitherto been unfairly subjected to.",
			"The rule which puts batsmen out on catches of foul balls, which, since the game originated,",
			"has been an unfair rule of play, has seen its best day; and this year the entering wedge to its ultimate",
			"disappearance has been driven in, with the practical result of the repeal of the foul tip catch.",
			"This improvement, too, is in the line of aiding the batting side,",
			"as it gets rid of one of the numerous ways of putting the batsman out."
	};
	
	static Random rand=new Random();
	
    public static void main(String args[]) {

        //Creating the Frame
        JFrame TyperMain = new JFrame("Hyper Typer - Main Menu");
        TyperMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TyperMain.setSize(1000, 730);

        //Creating the panel at bottom and adding components
        JPanel TyperPanel = new JPanel(); 
        EmptyBorder border1 = new EmptyBorder(0, 0, 0, 0);
        TyperPanel.setLayout(new BoxLayout(TyperPanel, BoxLayout.Y_AXIS));
        
        //The title that will present at the top
        JLabel title=new JLabel("Hyper Typer");
        title.setFont (title.getFont ().deriveFont (100.0f));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setForeground(Color.BLACK);
        TyperPanel.add(title);       
        
		JLabel space1=new JLabel(" ");
		space1.setBorder(border1);
		space1.setFont (space1.getFont ().deriveFont (250.0f));
		space1.setAlignmentX(Component.CENTER_ALIGNMENT);
		TyperPanel.add(space1);
		
        //Start Game button
        JButton start= new JButton("START GAME");
        TyperPanel.add(start);
        start.setBackground(Color.WHITE);
        start.setAlignmentX(Component.CENTER_ALIGNMENT);
        start.setFont (font2.deriveFont (35.0f));
        
        //Rules button
        JButton rules= new JButton("READ RULES");
        TyperPanel.add(rules);
        rules.setBackground(Color.WHITE);
        rules.setAlignmentX(Component.CENTER_ALIGNMENT);
        rules.setFont (font2.deriveFont (35.0f));
        
        //Exit Button
        JButton exit= new JButton("EXIT");
        TyperPanel.add(exit);
        exit.setBackground(Color.WHITE);
        exit.setAlignmentX(Component.CENTER_ALIGNMENT);
        exit.setFont (font2.deriveFont (35.0f));
        

        //Adding Components to the frame.
        TyperMain.add(TyperPanel);
        TyperMain.setLocationRelativeTo(null);
        TyperMain.setVisible(true);
       
        //If the user selects the game option
       start.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				TyperMain.setVisible(false);
				Options();
				
				
				
			}
			
		});
       
       //If the user selects the rules option
       rules.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				TyperMain.setVisible(false);
				Rules();
				
				
				
			}
			
		});
       
       //If the user wants to exit the game
       exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				TyperMain.setVisible(false);
				System.exit(0);
		
			}
			
		});
    }
    
    public static void Rules(){
    	//Setting the frame
    	JFrame RulesFrame = new JFrame("Hyper Typer - Rules");
    	RulesFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	RulesFrame.setSize(1000, 730);

        //Creating the panel at bottom and adding components
        JPanel RulesPanel = new JPanel(); 
        RulesPanel.setLayout(new BoxLayout(RulesPanel, BoxLayout.Y_AXIS));
		
		JLabel space1=new JLabel(" ");
		space1.setBorder(border1);
		space1.setFont (space1.getFont ().deriveFont (150.0f));
		space1.setAlignmentX(Component.CENTER_ALIGNMENT);
        RulesPanel.add(space1);
		
        //Rules for the game
		JLabel rule1=new JLabel("1. Welcome to Hyper Typer, Game made by Sanje");
		rule1.setFont (font2.deriveFont (25.0f));
        RulesPanel.add(rule1);
        rule1.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JLabel space2=new JLabel(" ");
		space2.setBorder(border1);
		space2.setFont (font2.deriveFont (10.0f));
        RulesPanel.add(space2);
        
		JLabel rule2=new JLabel("2. You'll only be given 60 seconds to type as many words as you can");
		rule2.setFont (font2.deriveFont (25.0f));
        RulesPanel.add(rule2);
        rule2.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JLabel space3=new JLabel(" ");
		space3.setBorder(border1);
		space3.setFont (space3.getFont ().deriveFont (10.0f));
        RulesPanel.add(space3);
		
        JLabel rule3=new JLabel("3. Every word you type, make sure you hit enter. Please be sure that it's case sensetive");
		rule3.setFont (font2.deriveFont (20.0f));
        RulesPanel.add(rule3);
        rule3.setAlignmentX(Component.CENTER_ALIGNMENT);   
        
        JLabel space4=new JLabel(" ");
		space4.setBorder(border1);
		space4.setFont (space4.getFont ().deriveFont (10.0f));
        RulesPanel.add(space4);
        
        JLabel rule4=new JLabel("4. Points will be awarded if you spell the word correctly.");
		rule4.setFont (font2.deriveFont (25.0f));
        RulesPanel.add(rule4);
        rule4.setAlignmentX(Component.CENTER_ALIGNMENT); 
        
        JLabel space5=new JLabel(" ");
		space5.setBorder(border1);
		space5.setFont (space5.getFont ().deriveFont (10.0f));
        RulesPanel.add(space5);
        
        JLabel rule5=new JLabel("5. Tickets earned will be based on the typing speed.");
		rule5.setFont (font2.deriveFont (25.0f));
        RulesPanel.add(rule5);
        rule5.setAlignmentX(Component.CENTER_ALIGNMENT); 
        
        JLabel space6=new JLabel(" ");
		space6.setBorder(border1);
		space6.setFont (space6.getFont ().deriveFont (100.0f));
        RulesPanel.add(space6);
        
        //Buttons that will present which will allow the user to begin the game or exit
        JButton menu= new JButton("Return to Main Menu");
        RulesPanel.add(menu);
        menu.setAlignmentX(Component.CENTER_ALIGNMENT);
        menu.setFont (font2.deriveFont (35.0f));
        
        

        //Adding Components to the frame.
       RulesFrame.add(RulesPanel);
       RulesFrame.setLocationRelativeTo(null);
       RulesFrame.setVisible(true);
       
       menu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				RulesFrame.setVisible(false);
				main(null);
				
				
				
				
			}
			
		});
    
    	
    }

    public static void Options(){
    	//Setting the frame
    	JFrame OptionFrame = new JFrame("Hyper Typer - Option Screen");
    	OptionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	OptionFrame.setSize(1000, 730);
    	
    	//Creating the panel at bottom and adding components
        JPanel OptionPanel = new JPanel(); 
        OptionPanel.setLayout(null);
    	
        //Title
        JLabel title=new JLabel("Select Your Options and Click Confirm when Ready");
        title.setFont (title.getFont ().deriveFont (35.0f));
        title.setLocation(80,10);
        title.setSize(1000,150);
        title.setForeground(Color.BLACK);
        OptionPanel.add(title);  
        
        //Time Label
    	JLabel timeLabel=new JLabel("Time");
    	timeLabel.setLocation(150,200);
    	timeLabel.setSize(100, 100);
    	timeLabel.setFont (font2.deriveFont (25.0f));
    	timeLabel.setForeground(Color.BLACK);
    	OptionPanel.add(timeLabel);
        
        //User selects the time option
        JComboBox<String> timeOption = new JComboBox<String>();
        // add items to the combo box
        timeOption.addItem("30 Seconds");
        timeOption.addItem("60 Seconds");
        timeOption.addItem("90 Seconds");
        timeOption.setLocation(100,300);
        timeOption.setSize(200,50);
        timeOption.setFont (font2.deriveFont (25.0f));
        OptionPanel.add(timeOption);  
        
        timeOption.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JComboBox<?> to = (JComboBox<?>)e.getSource();
                int timechoice = to.getSelectedIndex();
                if (timechoice==0) {
                	timeopt=30;
                	
                }
                else if (timechoice==1) {
                	timeopt=60;
                	;
                }
                else if (timechoice==2) {
                	timeopt=90;
                	
                }
            }
        });
        
        JButton timeButton = new JButton("Time Button");
        timeButton.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		
        	}
        	
        });
        
        //Game Mode Label
    	JLabel gameLabel=new JLabel("Game Mode");
    	gameLabel.setLocation(420,200);
    	gameLabel.setSize(200, 100);
    	gameLabel.setFont (font2.deriveFont (25.0f));
    	gameLabel.setForeground(Color.BLACK);
    	OptionPanel.add(gameLabel);
        
        //User selects the game option
        JComboBox<String> gameOption = new JComboBox<String>();
        // add items to the combo box
        gameOption.addItem("Random Words");
        gameOption.addItem("Paragraph");
        gameOption.setLocation(390,300);
        gameOption.setSize(220,50);
        gameOption.setFont (font2.deriveFont (25.0f));
        OptionPanel.add(gameOption); 
        
        gameOption.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JComboBox<?> to = (JComboBox<?>)e.getSource();
                int gamechoice = to.getSelectedIndex();
                if (gamechoice==0) {
                	gameSelect=1;
                	
                }
                else if (gamechoice==1) {
                	gameSelect=2;
                	
                }        
            }
        });
        
        //Difficulty Label
    	JLabel diffLabel=new JLabel("Difficulty");
    	diffLabel.setLocation(740,200);
    	diffLabel.setSize(300, 100);
    	diffLabel.setFont (font2.deriveFont (25.0f));
    	diffLabel.setForeground(Color.BLACK);
    	OptionPanel.add(diffLabel);
        
        //User selects the time option
        JComboBox<String> diffOption = new JComboBox<String>();
        // add items to the combo box
        diffOption.addItem("Normal Mode");
        diffOption.addItem("Easy Mode");
        diffOption.setLocation(700,300);
        diffOption.setSize(200,50);
        diffOption.setFont (font2.deriveFont (25.0f));
        OptionPanel.add(diffOption); 
        
        diffOption.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JComboBox<?> to = (JComboBox<?>)e.getSource();
                int diffchoice = to.getSelectedIndex();
                if (diffchoice==0) {
                	difficulty=1;
                	
                }
                else if (diffchoice==1) {
                	difficulty=2;
                	
                }              
            }
        });
        
        //Difficulty Label
    	JLabel easyMode=new JLabel("*Selecting Easy Mode allows you to type the word without worrying about case sensetivity");
    	easyMode.setLocation(35,600);
    	easyMode.setSize(1000, 100);
    	easyMode.setFont (font2.deriveFont (18.0f));
    	easyMode.setForeground(Color.BLACK);
    	OptionPanel.add(easyMode);
        
        //Buttons that will present which will allow the user to begin the game or exit
        JButton begin= new JButton("Confirm");
        OptionPanel.add(begin);
        begin.setLocation(400,500);
        begin.setSize(200,50);
        begin.setForeground(Color.BLACK);
        begin.setFont (font2.deriveFont (25.0f));
        
        
        //Return to Main Menu
        JButton menu= new JButton("Main Menu");
        OptionPanel.add(menu);
        menu.setLocation(400,550);
        menu.setSize(200,50);
        menu.setForeground(Color.BLACK);
        menu.setFont (font2.deriveFont (25.0f));
        
        
    	//Adding Components to the frame.
    	OptionFrame.add(OptionPanel);
    	OptionFrame.setLocationRelativeTo(null);
        OptionFrame.setVisible(true);
        
        //If the user confirms the option, it brings them to the game
        begin.addActionListener(new ActionListener(){
 			public void actionPerformed(ActionEvent e) {
 				OptionFrame.setVisible(false);
 				if (gameSelect==1) {
                	RandomGame();
                	
                }
                else if (gameSelect==2) {
                	ParaGame();
                	
                }
    
 			}
        
        });
        
        
        //If the user confirms the option, it brings them to the main menu
        menu.addActionListener(new ActionListener(){
 			public void actionPerformed(ActionEvent e) {
 				OptionFrame.setVisible(false);
 				main(null);
 				timeopt=30;
 				gameSelect=1;
 				difficulty=1;
 				    
 			}
        
        });
    
    }
    	
    public static void RandomGame () {
    	//Variables
    	//the words that will be used with the program
        
    	JFrame GameFrame = new JFrame("Hyper Typer - Game");
    	GameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	GameFrame.setSize(1000, 730);
    	
    	//Creating the panel at bottom and adding components
        JPanel GamePanel = new JPanel(); 
        GamePanel.setLayout(null);
    	
        //Title at the top of the game
        JLabel title=new JLabel("Hyper Typer");
        title.setFont (title.getFont ().deriveFont (75.0f));
        title.setLocation(275,10);
        title.setSize(1000,150);
        title.setForeground(Color.BLACK);
    	GamePanel.add(title);
        
        JLabel space1=new JLabel(" ");
		space1.setBorder(border1);
		space1.setFont (space1.getFont ().deriveFont (150.0f));
		space1.setAlignmentX(Component.CENTER_ALIGNMENT);
		GamePanel.add(space1);
		
		
		//1st Word
    	word1=new JLabel("");
    	word1.setLocation(150,220);
    	word1.setSize(300, 100);
    	word1.setFont (font2.deriveFont (25.0f));
    	GamePanel.add(word1);
    	
    	//2nd Word
    	word2=new JLabel("");
    	word2.setLocation(350,220);
    	word2.setSize(300, 100);
    	word2.setFont (font2.deriveFont (25.0f));
    	GamePanel.add(word2);
    	
    	//3rd Word
    	word3=new JLabel("");
    	word3.setLocation(550,220);
    	word3.setSize(300, 100);
    	word3.setFont (font2.deriveFont (25.0f));
    	GamePanel.add(word3);
    	
    	//4th Word
    	word4=new JLabel("");
    	word4.setLocation(750,220);
    	word4.setSize(300, 100);
    	word4.setFont (font2.deriveFont (25.0f));
    	GamePanel.add(word4);
    	
		
		// Backups
		//1st Word
    	word11=new JLabel("");
    	word11.setLocation(150,150);
    	word11.setSize(100, 100);
    	word11.setFont (font2.deriveFont (25.0f));
    	GamePanel.add(word11);
    	
    	//2nd Word
    	word21=new JLabel("");
    	word21.setLocation(350,150);
    	word21.setSize(300, 100);
    	word21.setFont (font2.deriveFont (25.0f));
    	GamePanel.add(word21);
    	
    	//3rd Word
    	word31=new JLabel("");
    	word31.setLocation(550,150);
    	word31.setSize(300, 100);
    	word31.setFont (font2.deriveFont (25.0f));
    	GamePanel.add(word31);
    	
    	//4th Word
    	word41=new JLabel("");
    	word41.setLocation(750,150);
    	word41.setSize(300, 100);
    	word41.setFont (font2.deriveFont (25.0f));
    	GamePanel.add(word41);
    	
    	
    	getRandomTestWords();
    	setLabels();
    	
    	//Text
    	JTextField text = new JTextField(1);
    	text.setLocation(290,400);
    	text.setFont(font1);
    	text.setSize(400, 50);
    	GamePanel.add(text);
    	
    	//Time
    	JLabel time=new JLabel("Time: " + timeopt + " secs");
    	time.setLocation(75,500);
    	time.setSize(300, 100);
    	time.setFont (font2.deriveFont (25.0f));
    	GamePanel.add(time);
    	
    	//WPM
    	wpm=new JLabel("Current WPM: " + 0);
    	wpm.setLocation(75,550);
    	wpm.setSize(300, 100);
    	wpm.setFont (font2.deriveFont (25.0f));
    	GamePanel.add(wpm);
    	
    	//Errors
    	error=new JLabel("Errors: " + errors);
    	error.setLocation(750,500);
    	error.setSize(300, 100);
    	error.setFont (font2.deriveFont (25.0f));
    	GamePanel.add(error);
    	
    	//Correct Words
    	correct=new JLabel("Correct: " + corrects);
    	correct.setLocation(750,550);
    	correct.setSize(300, 100);
    	correct.setFont (font2.deriveFont (25.0f));
    	GamePanel.add(correct);
		
		//Adding Components to the frame.
		GameFrame.add(GamePanel);
	    GameFrame.setLocationRelativeTo(null);
	    GameFrame.setVisible(true);
		
	    //Timer options
	    Timer timer = new Timer("Timer");
	    
	    
	    //Timer for the game
	    TimerTask repeatedTask = new TimerTask() {
	        public void run() {
	        	timeopt--;
	        	timepast++;
	            time.setText("Time: " + timeopt + " secs");
	            //wpm.setText("Current WPM: " + wpmCounter);
	            
	            if (timeopt==0) {
	            	timer.cancel();
	            	text.setEnabled(false);
	            	try {
						TimeUnit.SECONDS.sleep(2);
						
					} catch (InterruptedException e) {
						e.printStackTrace();
						
					}
	            	
	            	End();
	            }
	        }
	    };
	     
	    long delay  = 1000L;
	    long period = 1000L;
	    timer.scheduleAtFixedRate(repeatedTask, delay, period);
	    
	    
		// add listeners
	    text.addActionListener( new ActionListener() {

            public void actionPerformed(ActionEvent e){

                String typedWord = text.getText();
                String word = testWords[wordno];
                
                //If the user types the word up correctly
                if (typedWord.equalsIgnoreCase(word)==true) {
                	
                	if (difficulty==1) {
                		
                		if (typedWord.equals(word)==true) {
                			setButtonColor(wordno, Color.GREEN);
                        	corrects++;
                        	correct.setText("Corrects: " + corrects);
                        	
                		} else {
                			setButtonColor(wordno, Color.RED);
                        	errors++;
                        	error.setText("Errors: " + errors);
                		}
                					
                	}
                	
                	else if (difficulty==2) {
                		setButtonColor(wordno, Color.GREEN);
                    	corrects++;
                    	correct.setText("Corrects: " + corrects);
                	}
                	                	
                	                	
                //If the user types up the word incorrectly
                } else {
                	setButtonColor(wordno, Color.RED);
                	errors++;
                	error.setText("Errors: " + errors);
                }

                //System.out.println(corrects + " -- " + timepast + " == " + ((corrects * 60 ) / timepast));
                cwpm=(corrects * 60) / timepast;
            	wpm.setText("Current WPM: " + cwpm);
            	
                text.setText("");
                
                //Change label colors
                wordno++;
                if (wordno==4) {
                	
                	wordno = 0;
                	// get new set of test words
                	// populate the lables
                	copyLabels();
                	getRandomTestWords();
                	setLabels();
            		
                } else {
                    setButtonColor(wordno, Color.CYAN);                	
                }
                                
                
        }});
	    	    
					
	}
				   
    public static void ParaGame() {
    	//Variables
    	//the words that will be used with the program
        
    	JFrame GameFrame = new JFrame("Hyper Typer - Game");
    	GameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	GameFrame.setSize(1000, 730);
    	
    	//Creating the panel at bottom and adding components
        JPanel GamePanel = new JPanel(); 
        GamePanel.setLayout(null);
    	
        //Title at the top of the game
        //JLabel title=new JLabel("Hyper Typer");
        JLabel title = new JLabel("<html><font color=blue>Hyper</font> <font color=yellow>Typer</font></html>");
        title.setFont (title.getFont().deriveFont (75.0f));
        title.setLocation(275,10);
        title.setSize(1000,150);
        title.setForeground(Color.BLACK);
    	GamePanel.add(title);
        
        JLabel space1=new JLabel(" ");
		space1.setBorder(border1);
		space1.setFont (space1.getFont ().deriveFont (150.0f));
		space1.setAlignmentX(Component.CENTER_ALIGNMENT);
		GamePanel.add(space1);
		
		//"Baseball has been the national pastime in the United States since the middle of the 1800s."
		
		
		//Backup
		sent2=new JLabel("");
		sent2.setLocation(80,200);
		sent2.setSize(1000, 100);
		sent2.setFont (font2.deriveFont (20.0f));
    	GamePanel.add(sent2);
    	
		//1st Word
    	sent1=new JLabel(paragraphs[parano]);
    	sent1.setLocation(80,270);
    	sent1.setSize(1000, 100);
    	sent1.setFont (font2.deriveFont (20.0f));
    	GamePanel.add(sent1);
    	
    	    	    	    	
    	//Text
    	textp = new JTextArea(4, 100);
    	textp.setLocation(80,400);
    	textp.setFont(font1);
    	textp.setSize(1000, 120);
    	GamePanel.add(textp);
    	
    	//Time
    	JLabel time=new JLabel("Time: " + timeopt + " secs");
    	time.setLocation(75,500);
    	time.setSize(300, 100);
    	time.setFont (font2.deriveFont (25.0f));
    	GamePanel.add(time);
    	
    	//WPM
    	wpm=new JLabel("Current WPM: " + 0);
    	wpm.setLocation(75,550);
    	wpm.setSize(300, 100);
    	wpm.setFont (font2.deriveFont (25.0f));
    	GamePanel.add(wpm);
    	
    	//Errors
    	error=new JLabel("Errors: " + errors);
    	error.setLocation(750,500);
    	error.setSize(300, 100);
    	error.setFont (font2.deriveFont (25.0f));
    	GamePanel.add(error);
    	
    	//Correct Words
    	correct=new JLabel("Correct: " + corrects);
    	correct.setLocation(750,550);
    	correct.setSize(300, 100);
    	correct.setFont (font2.deriveFont (25.0f));
    	GamePanel.add(correct);
		
		//Adding Components to the frame.
		GameFrame.add(GamePanel);
	    GameFrame.setLocationRelativeTo(null);
	    GameFrame.setVisible(true);
		
	    //Timer options
	    Timer timer = new Timer("Timer");
	    
	    
	    //Timer for the game
	    TimerTask repeatedTask = new TimerTask() {
	        public void run() {
	        	timeopt--;
	        	timepast++;
	            time.setText("Time: " + timeopt + " secs");
	            //wpm.setText("Current WPM: " + wpmCounter);
	            
	            if (timeopt==0) {
	            	timer.cancel();
	            	textp.setEnabled(false);
	            	compareParas(true);
	            	try {
						TimeUnit.SECONDS.sleep(2);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
	            	
	            	End();
	            }
	        }
	    };
	     
	    long delay  = 1000L;
	    long period = 1000L;
	    timer.scheduleAtFixedRate(repeatedTask, delay, period);
	    
	    
		// add listeners
	    textp.addKeyListener(new KeyListener() {
	    	@Override
	        public void keyPressed(KeyEvent e){
	            if (e.getKeyCode() == KeyEvent.VK_ENTER){
	            	
	                compareParas(false);
	                textp.setText(null);
	                
	                if (++parano > paragraphs.length) {
	                	// no more paragraphs left to display
	                	timer.cancel();
		            	textp.setEnabled(false);
	                } else {
	                	sent1.setText(paragraphs[parano]);
	                }
	            } else if (e.getKeyCode() == KeyEvent.VK_SPACE){ 
	            	//System.out.println("Space....");
	            	showCurrentWord();
	            }
	        }

	        @Override
	        public void keyTyped(KeyEvent e) {
	        }

	        @Override
	        public void keyReleased(KeyEvent e) {
	        }       
        });
    }
   
    
    private static void setButtonColor(int buttonno, Color color) {
        //Gives the word a colour based on if the user types the word correctly
    	if (buttonno==0) word1.setForeground(color);
        if (buttonno==1) word2.setForeground(color);
        if (buttonno==2) word3.setForeground(color);
        if (buttonno==3) word4.setForeground(color);
        //if (buttonno==4) word5.setForeground(color);
        //if (buttonno==5) word6.setForeground(color);
        //if (buttonno==6) word7.setForeground(color);
        //if (buttonno==7) word8.setForeground(color);

    }
    
    private static void setLabels() {
    	//
    	word1.setText(testWords[0]);
    	word1.setForeground(Color.CYAN);
    	word2.setText(testWords[1]);
    	word2.setForeground(Color.BLACK);
    	word3.setText(testWords[2]);
    	word3.setForeground(Color.BLACK);
    	word4.setText(testWords[3]);
    	word4.setForeground(Color.BLACK);
    	
    }
    
    private static void copyLabels() {
    	word11.setText(testWords[0]);
    	word11.setForeground(word1.getForeground());
    	word21.setText(testWords[1]);
    	word21.setForeground(word2.getForeground());
    	word31.setText(testWords[2]);
    	word31.setForeground(word3.getForeground());
    	word41.setText(testWords[3]);
    	word41.setForeground(word4.getForeground());
    	
    }

    
    
    private static void showCurrentWord() {
    	String typedParagraph = textp.getText();
        String paragraph = paragraphs[parano];
        
        StringBuilder sbText =  new StringBuilder(); 
        sbText.append("<html>");
        
        String[] typedWords = typedParagraph.split(" ");
        String[] paras = paragraph.split(" ");
        int typedWords_count = typedWords.length;
        int paraWords_count = paras.length;
        
        int l =0;
        if (typedWords.length<paras.length) {
        	l = typedWords.length;
        } else {
        	l = paras.length;
        }
        
        for (int i=0; i<l; i++) {
        	if (paras[i].equals(typedWords[i])) {
        		sbText.append("<font color=green>"+ paras[i] + "</font> ");
        	} else {
        		sbText.append("<font color=red>"+ paras[i] + "</font> ");
        	}
        }
        sbText.append("<font color=blue>"+ paras[l] + "</font> ");

        for (int i=l+1; i<paras.length; i++) {
        	sbText.append("<font color=black>"+ paras[i] + "</font> ");
        }
        
        sbText.append("</html>");
        
        sent1.setText(sbText.toString());
    }
    
    private static void compareParas(boolean timeElapsed) {
    	String typedParagraph = textp.getText();
        String paragraph = paragraphs[parano];
        
        StringBuilder sbText =  new StringBuilder(); 
        sbText.append("<html>");
        
        String[] typedWords = typedParagraph.split(" ");
        String[] paras = paragraph.split(" ");
        
        //int l = (typedWords.length<paras.length)?typedWords.length:paras.length;
        int l =0;
        if (typedWords.length<paras.length) {
        	l = typedWords.length;
        	if (timeElapsed==false) {
        		errors += paras.length - typedWords.length;
        	}
        } else {
        	l = paras.length;
        }
        
        
        for (int i=0; i<l; i++) {
        	if (paras[i].equals(typedWords[i])) {
        		corrects++;
        		sbText.append("<font color=green>"+ paras[i] + "</font> ");
        	} else {
        		errors++;
        		sbText.append("<font color=red>"+ paras[i] + "</font> ");
        	}
        }
        sbText.append("</html>");

        correct.setText("Corrects: " + corrects);
        
    	error.setText("Errors: " + errors);
    	
    	cwpm=(corrects * 60) / timepast;
    	wpm.setText("Current WPM: " + cwpm);
        
    	sent2.setText(sbText.toString());
    	
    	
    }
    
    
    private static void getRandomTestWords() {
        testWords = new String[4];
        int c = 0;
        //generate test words
        for (int i=0; i<4; i++) {
        	c = rand.nextInt(105);
        	testWords[i] = words[c];
        }

    }
      
    
    public static void End(){
    	//Creating the Frame
        JFrame endFrame = new JFrame("Hyper Typer - End Game");
        endFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        endFrame.setSize(1000,730);

        //Creating the panel at bottom and adding components
        JPanel endPanel = new JPanel(); 
        EmptyBorder border1 = new EmptyBorder(0, 0, 0, 0);
        endPanel.setLayout(new BoxLayout(endPanel, BoxLayout.Y_AXIS));
		
        //First Space
		JLabel space1=new JLabel(" ");
		space1.setBorder(border1);
		space1.setFont (space1.getFont ().deriveFont (125.0f));
		endPanel.add(space1);
		
		//The WPM that the user has achieved
		JLabel label1=new JLabel("WPM Score: " + cwpm);
        label1.setFont (font2.deriveFont (40.0f));
        endPanel.add(label1);
		label1.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JLabel space2=new JLabel(" ");
		space2.setBorder(border1);
		space2.setFont (space2.getFont ().deriveFont (20.0f));
		endPanel.add(space2);
		
		//The amount of errors that have occured when the user was typing
		JLabel label2=new JLabel("Amount of Errors: " + errors);
		label2.setFont (font2.deriveFont (40.0f));
		endPanel.add(label2);
        label2.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JLabel space3=new JLabel(" ");
		space3.setBorder(border1);
		space3.setFont (space3.getFont ().deriveFont (20.0f));
		endPanel.add(space3);
		
		//The total amount of tickets earned
		JLabel label3=new JLabel("Amount of Tickets Earned: " + (cwpm + 35));
		label3.setFont (font2.deriveFont (40.0f));
		endPanel.add(label3);
		label3.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JLabel space4=new JLabel(" ");
        space4.setBorder(border1);
        space4.setFont (space4.getFont ().deriveFont (50.0f));
		endPanel.add(space4);
		
        //Button created to allow the user to return to the game menu
        JButton playAgain= new JButton("Play Again");
        endPanel.add(playAgain);
        playAgain.setAlignmentX(Component.CENTER_ALIGNMENT);
        playAgain.setFont (font2.deriveFont (40.0f));
        
        //Button created to allow the user to return to the main menu
        JButton exit= new JButton("Return to Game Menu");
        endPanel.add(exit);
        exit.setAlignmentX(Component.CENTER_ALIGNMENT);
        exit.setFont (font2.deriveFont (40.0f));
        

        //Adding Components to the frame.
        endFrame.add(endPanel);
        endFrame.setLocationRelativeTo(null);
        endFrame.setVisible(true);
        playAgain.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				endFrame.setVisible(false);
				Options();			
			}
			
		});
        
        //Selecting this option allows the user to exit the program
        exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				endFrame.setVisible(false);
				main(null);			
			}
			
        });
    
    }
}