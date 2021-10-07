/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab8question;

import edu.tarleton.logging.Logger;
import java.io.IOException;
import static java.lang.Math.abs;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


/**
 *
 * @author sethp
 */
public class Main {
    public static void main(String[] args) throws IOException {
            Path path = Paths.get("questions.txt");
            Charset cs = Charset.forName("UTF-8");
            List<String> lines = Files.readAllLines(path, cs);
            List<Question> questions = new ArrayList();
            for(String line : lines){
                String []s = line.split(";");
                Question question = new Question(s[0],s[1]);
                questions.add(question);
            }
            
            Random rand = new Random();
            int randNum = abs(rand.nextInt()%questions.size());
            System.out.println(questions.get(randNum).getQuestion());
            Scanner sc = new Scanner(System.in);
            String ans = sc.nextLine();
            if(ans.equals(questions.get(randNum).getAnswer())){
                System.out.println("correct");
            }else{
                System.out.printf("The answer is %s",questions.get(randNum).getAnswer());
            }
            Logger log = new Logger("log.txt");
            log.log("Program ran");
            log.close();
    }
}
