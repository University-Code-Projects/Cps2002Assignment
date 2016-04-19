/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assignmnet;
import static java.lang.System.exit;
import java.util.Scanner;
/**
 *
 * @author jonathan
 */
public class main {
    public static Library libr;
    public static void main(String[] args){
        System.out.print("Test");
        Scanner in = new Scanner(System.in);
        
        int input =0;
        int value;
        
        while(input != 11){
            System.out.println("Enter an option: ");
            System.out.println("1. Initialise the Library");
            System.out.println("2. Insert a User");
            System.out.println("3. Remove a user");
            System.out.println("4. Insert a Book");
            System.out.println("5. Remove a Book");
            System.out.println("6. Search for a Book");
            System.out.println("7. Loan a book the a specific user");
            System.out.println("8. Return a Book");
            System.out.println("9. Edit a users details");
            System.out.println("10. Print Details List");
            System.out.println("11. Exit");            
            input = in.nextInt();
            switch(input){
                case 1:{
                    System.out.println("Initializing list");
                    libr = new Library();
                    break;
                }
                
                case 2:{
                    
                    break;
                }
                
                case 3:{
                    
                    break;
                }
                case 4:{
                                       
                    break;
                }
                case 5:{
                    
                    break;
                }
                case 6:{
                    break;
                }
                
                case 7:{
                    break;
                }
                
                case 8:{
                    break;
                }
                case 9:{
                    break;
                }
                case 10:{
                    break;
                }

                case 11:{
                    
                    break;
                }
                default: 
                    System.out.println("Invalid entry");
                    break;
                
            }
        }
    }
}
