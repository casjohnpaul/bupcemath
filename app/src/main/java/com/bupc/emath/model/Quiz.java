package com.bupc.emath.model;

/**
 * Created by casjohnpaul on 2/13/2018.
 */

public class Quiz {

    public static final int NORMAL = 1;
    public static final int IMAGE = 2;

    private String quesiton;
    private String option1, option2, option3, option4;

    private int quesionImg;
    private int optionImg1, optionImg2, optionImg3, optionImg4;

    private String answer;
    private int answerImg;

    private int categoryType;

    private int explanation;
    private String explanationStr;

    private Quiz(Builder builder) {
        setQuesiton(builder.quesiton);
        setOption1(builder.option1);
        setOption2(builder.option2);
        setOption3(builder.option3);
        setOption4(builder.option4);
        setQuesionImg(builder.quesionImg);
        setOptionImg1(builder.optionImg1);
        setOptionImg2(builder.optionImg2);
        setOptionImg3(builder.optionImg3);
        setOptionImg4(builder.optionImg4);
        setAnswer(builder.answer);
        setAnswerImg(builder.answerImg);
        setCategoryType(builder.categoryType);
        setExplanation(builder.explanation);
        setExplanationStr(builder.explanationStr);
    }


    public String getQuesiton() {
        return quesiton;
    }

    public void setQuesiton(String quesiton) {
        this.quesiton = quesiton;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public int getOptionImg1() {
        return optionImg1;
    }

    public void setOptionImg1(int optionImg1) {
        this.optionImg1 = optionImg1;
    }

    public int getOptionImg2() {
        return optionImg2;
    }

    public void setOptionImg2(int optionImg2) {
        this.optionImg2 = optionImg2;
    }

    public int getOptionImg3() {
        return optionImg3;
    }

    public void setOptionImg3(int optionImg3) {
        this.optionImg3 = optionImg3;
    }

    public int getOptionImg4() {
        return optionImg4;
    }

    public void setOptionImg4(int optionImg4) {
        this.optionImg4 = optionImg4;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getAnswerImg() {
        return answerImg;
    }

    public void setAnswerImg(int answerImg) {
        this.answerImg = answerImg;
    }

    public int getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(int categoryType) {
        this.categoryType = categoryType;
    }

    public int getQuesionImg() {
        return quesionImg;
    }

    public void setQuesionImg(int quesionImg) {
        this.quesionImg = quesionImg;
    }

    public int getExplanation() {
        return explanation;
    }

    public void setExplanation(int explanation) {
        this.explanation = explanation;
    }

    public String getExplanationStr() {
        return explanationStr;
    }

    public void setExplanationStr(String explanationStr) {
        this.explanationStr = explanationStr;
    }


    public static final class Builder {
        private String quesiton;
        private String option1;
        private String option2;
        private String option3;
        private String option4;
        private int quesionImg;
        private int optionImg1;
        private int optionImg2;
        private int optionImg3;
        private int optionImg4;
        private String answer;
        private int answerImg;
        private int categoryType;
        private int explanation;
        private String explanationStr;

        public Builder() {
        }

        public Builder quesiton(String val) {
            quesiton = val;
            return this;
        }

        public Builder option1(String val) {
            option1 = val;
            return this;
        }

        public Builder option2(String val) {
            option2 = val;
            return this;
        }

        public Builder option3(String val) {
            option3 = val;
            return this;
        }

        public Builder option4(String val) {
            option4 = val;
            return this;
        }

        public Builder quesionImg(int val) {
            quesionImg = val;
            return this;
        }

        public Builder optionImg1(int val) {
            optionImg1 = val;
            return this;
        }

        public Builder optionImg2(int val) {
            optionImg2 = val;
            return this;
        }

        public Builder optionImg3(int val) {
            optionImg3 = val;
            return this;
        }

        public Builder optionImg4(int val) {
            optionImg4 = val;
            return this;
        }

        public Builder answer(String val) {
            answer = val;
            return this;
        }

        public Builder answerImg(int val) {
            answerImg = val;
            return this;
        }

        public Builder categoryType(int val) {
            categoryType = val;
            return this;
        }

        public Builder explanation(int val) {
            explanation = val;
            return this;
        }

        public Builder explanationStr(String val) {
            explanationStr = val;
            return this;
        }

        public Quiz build() {
            return new Quiz(this);
        }
    }
}
