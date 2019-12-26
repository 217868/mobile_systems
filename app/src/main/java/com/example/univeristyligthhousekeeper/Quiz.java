package com.example.univeristyligthhousekeeper;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Vector;

public class Quiz {

    private int numberOfQuestions;
    private int numberOfCategories;
    private String filename;
    private Vector<Question> questions = new Vector<>();
    private int[] userAnswers;
    private String[] namesOfCategories;

    //CONSTURCOTR
    public Quiz(String file) {
        this.filename = file;
        ReadFile();
    }

    public void ReadFile() {
        int i = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;

            while ((line = reader.readLine()) != null) {
                if(i==0)
                    this.numberOfQuestions = Integer.parseInt(line);
                else if(i == 1) {
                    this.numberOfCategories = Integer.parseInt(line);
                    i++;
                    break;
                }
                i++;
            }
            userAnswers = new int [numberOfQuestions];
            namesOfCategories = new String[numberOfCategories];
            while ((line = reader.readLine()) != null) {
                if(i > 1 && i < (2+numberOfCategories))
                {
                    namesOfCategories[i-2] = line;
                }
                else if(i > (1 + numberOfCategories) && i < (2 + numberOfCategories + numberOfQuestions))
                {
                    Question question = new Question(line);
                    questions.add(question);
                }
                else
                {
                    int answers [] [] = new int[5][numberOfCategories];
                    for(int j = 0; j < numberOfCategories; j++)
                    {
                        for(int k = 0; k < 5; k++)
                        {
                            answers[j][k] =  Integer.parseInt(String.valueOf(line.charAt(j*6 + k)));
                        }
                    }
                    Answers answers1 = new Answers(answers);
                    questions.get(i - 2 - numberOfCategories - numberOfQuestions).setAnswers(answers1);
                }
                i++;
            }
            reader.close();
        } catch (Exception e) {
            System.err.format("Exception occurred trying to read '%s'.", filename);
            e.printStackTrace();
        }
    }

    public void SetUserAnswer(int question_id, int value)
    {
        userAnswers[question_id] = value;
    }

    public Question GetQuestion(int question_id) { return questions.get(question_id); }

    public int getNumberOfQuestions() { return numberOfQuestions; }

    public int getNumberOfCategories() { return numberOfCategories; }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String calcualtePoints()
    {
        int results [] = new int[numberOfCategories];

        for(int i = 0; i < numberOfCategories; i++) {
            int sum = 0;
            for (int j = 0; j < numberOfQuestions; j++) {
                sum = sum + questions.get(j).getAnswers().getAnswer(userAnswers[j], i);
            }
            results[i] = sum;
        }

        int max = Arrays.stream(results).max().getAsInt();
        for(int i = 0 ; i < numberOfCategories ; i++)
        {
           if(results[i] == max) return namesOfCategories[i];
        }
        return null;
    }

}
