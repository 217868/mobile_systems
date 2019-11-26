package com.example.univeristyligthhousekeeper;

import java.util.Vector;

public class Quiz {

    private Vector<Question> questions = new Vector<>();
    private int [] userAnswers = new int[13];

    private final int ARTANSWERS = 0;
    private final int CHEMICANSWERS = 0;
    private final int BIOLOGICANSWERS = 0;
    private final int ITELECTRICANSWERS = 0;
    private final int MECHANICALANSWERS = 0;
    private final int MANAGMENTLOGISTICANSWERS = 0;

    public void AddToVector(Question question)
    {
        questions.add(question);
    }

    public Question getQuestion(int id) {
        return questions.get(id);
    }

    public void UserAnswer(int question_id, int value)
    {
        userAnswers[question_id] = value;
    }

    public int calculateArtPoints()
    {
        int sum = 0;
        for(int i=0; i <15; i++)
        {
            sum = sum +questions.get(i).getAnswers().getAnswer(userAnswers[i], ARTANSWERS);
        }
        return sum;
    }

    public int calculateChemicPoints()
    {
        int sum = 0;
        for(int i=0; i <15; i++)
        {
            sum = sum +questions.get(i).getAnswers().getAnswer(userAnswers[i], CHEMICANSWERS);
        }
        return sum;
    }
    public int calculateBiologicPoints()
    {
        int sum = 0;
        for(int i=0; i <15; i++)
        {
            sum = sum +questions.get(i).getAnswers().getAnswer(userAnswers[i], BIOLOGICANSWERS);
        }
        return sum;
    }
    public int calculateITElectricPoints()
    {
        int sum = 0;
        for(int i=0; i <15; i++)
        {
            sum = sum +questions.get(i).getAnswers().getAnswer(userAnswers[i], ITELECTRICANSWERS);
        }
        return sum;
    }
    public int calculateMechanicalPoints()
    {
        int sum = 0;
        for(int i=0; i <15; i++)
        {
            sum = sum +questions.get(i).getAnswers().getAnswer(userAnswers[i], MECHANICALANSWERS);
        }
        return sum;
    }
    public int calculateManagmentLocisticPoints()
    {
        int sum = 0;
        for(int i=0; i <15; i++)
        {
            sum = sum + questions.get(i).getAnswers().getAnswer(userAnswers[i], MANAGMENTLOGISTICANSWERS);
        }
        return sum;
    }
}
