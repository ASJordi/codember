package dev.asjordi.solutions23.ch02;

public class MiniCompiler {

    private int value;
    private final StringBuilder log;
    private final String operations;

    public MiniCompiler(String operations) {
        this.operations = operations;
        this.log = new StringBuilder();
        this.value = 0;
    }

    public String execute(){
        for (char op : this.operations.toCharArray()){
            if (op == '#') increaseValue();
            else if (op == '@') decreaseValue();
            else if (op == '*') multiplyValue();
            else if (op == '&') printCurrentValue();
        }

        return this.log.toString();
    }

    private void increaseValue(){
        this.value++;
    }

    private void decreaseValue(){
        this.value--;
    }

    private void multiplyValue(){
        this.value *= this.value;
    }

    private void printCurrentValue(){
        this.log.append(this.value);
    }
}
