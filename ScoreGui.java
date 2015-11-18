

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
/**
 *The class is based on the student class and main method,extended to application
 *The class is mostly composed of javaFx  
 *The class is used to calculate grades(GPA) for students
 *@author Yibing
 *Date 12/14/2015
 *
 */
public class ScoreGui extends Application {
private static final int SIZE=4;
private int count=0;
private static double [][]assignments=new double[SIZE][2];
private TextField nameTextfield=new TextField();
private TextField txf2=new TextField();
private TextField txf3=new TextField();
private Button btn=new Button("Enter numbers");
private	Button btn2=new Button("Calculate");
private	Label label1 =new Label("Name");
private	Label label2 =new Label("Score");
private	Label label3 =new Label("Weighted percentage");

public static void main(String []args){
		launch(args);
		/**
		 * The program uses start method to set primary Stage
		 *Creates the frame and take input from users
		 *@param name
		 *@param score
		 *@param weight
		 *@param assignments[][]
		 *@return numbers.toString(which is a sorted Array)
		 */
	}
	
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Score GUI");//set Tittle
		btn.setOnAction(new EventHandler<ActionEvent>(){
			String name="";
			double score=0;
			double weight;//define name,score,weight
			@Override
			public void handle(ActionEvent arg0) {		
			if (count<4){score =Double.parseDouble(txf2.getText());	
			weight =Double.parseDouble(txf3.getText());
			assignments[count][0]=score;	
			assignments[count][1]=weight;
			count++;}//loop to prompt for name, grades, and weighted percentage from users 
			if (count>=4){
			btn.setText("Now press calculate button please");	
			}//once done, remind users to press calculate button
			}	
		});
		btn2.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				Student student =new Student(nameTextfield.getText(),assignments);//set assignments array as a new array 
				student.getGpa();//calculate GPA
				System.out.print(student.toString());//print
				
			}
			
		});
		
		GridPane grid= new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setVgap(10);
		grid.setHgap(10);
		grid.add(label1, 0, 0);
		grid.add(label2, 0, 1);
		grid.add(label3, 0, 2);
		grid.add(nameTextfield, 1, 0);
		grid.add(txf2, 1, 1);
		grid.add(txf3, 1, 2);
		grid.add(btn,1,3);
		grid.add(btn2, 1, 4);
		Scene scene =new Scene(grid,500,500);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
