package gui;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class GUI extends Application {
	public static void main(String []args){
		launch(args);
	}
	
	@Override 
	public void start(Stage stage){
		
		stage.setResizable(false);
		stage.setTitle("Brian's Calculator");
		
		TextField screen = new TextField();
		
		Button add = new Button("+");
		add.prefWidth(25);
		add.prefHeight(25);
		add.setTranslateX(212);
		add.setTranslateY(185);
		
		Button sub = new Button("-");
		sub.prefWidth(30);
		sub.prefHeight(30);
		sub.setTranslateX(212);
		sub.setTranslateY(130);
		
		Button multiply = new Button("*");
		
		multiply.prefWidth(30);
		multiply.prefHeight(30);
		multiply.setTranslateX(212);
		multiply.setTranslateY(130);
		
		Button divide = new Button("/");
		Button equals = new Button("=");
		equals.prefWidth(30);
		equals.prefHeight(100);
		equals.setTranslateX(212);
		equals.setTranslateY(250);
		
		Group root = new Group(screen, add, sub, multiply, divide, equals);
		
		Scene scene = new Scene(root , 250, 300);
		
		
		stage.setScene(scene);
		stage.show();
	}
}