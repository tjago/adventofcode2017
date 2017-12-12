import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day8 {
    private Map<String, Integer> registers = new HashMap();

    public static void main(String[] args) throws Exception {
        new Day8().run();
    }

    private void run() throws Exception {

        int maxValueAtEnd;
        int maxAtEval = Integer.MIN_VALUE;

        for (String textInstruction : getStringArraysOutOfFile("res/Day8registers.txt")) {

            String instructionSplited[] = textInstruction.split("\\s+");
            String registryKey = instructionSplited[0];
            String operation = instructionSplited[1];
            Integer val = Integer.parseInt(instructionSplited[2]);

            Day8.Condition condition = new Day8.Condition(textInstruction.split("if ")[1]);
            if (condition.evaluateCondition()) {
                Integer newValue = increaseRegister(registryKey, val, operation.equals("inc") ? true : false);
                if (newValue > maxAtEval) {
                    maxAtEval = newValue;
                }
            }
        }
        maxValueAtEnd = gerRegistersMaxValue();
        System.out.println("max: " + maxValueAtEnd);
        System.out.println("maxAtEvalTime: " + maxAtEval);
    }

    private int gerRegistersMaxValue() {
        Integer maxValue = Integer.MIN_VALUE;
        for(Map.Entry<String, Integer> entry : registers.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
            }
        }
        return maxValue;
    }

    public List<String> getStringArraysOutOfFile(String filename) throws IOException {
        List<String> passwordsPassphrases = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(filename));
        try {
            String line = br.readLine();

            while (line != null) {
                passwordsPassphrases.add(line);
                line = br.readLine();
            }
        } finally {
            br.close();
        }
        return passwordsPassphrases;
    }

    class Condition {
        private String condType;
        private String registryKey;
        private Integer condValue;

        Condition(String conditionText) {
            String conditionsSplited[] = conditionText.split("\\s+");
            this.registryKey = conditionsSplited[0];
            this.condType = conditionsSplited[1];
            this.condValue = Integer.parseInt(conditionsSplited[2]);
        }

        boolean evaluateCondition() throws Exception {
            Integer registryValue = registers.get(this.registryKey);

            if (null == registryValue) {
                registers.put(this.registryKey, 0);
                registryValue = 0;
            }

            switch (this.condType) {
                case "==":
                    if (registryValue.equals(this.condValue)) return true;
                    break;
                case ">=":
                    if (registryValue >= this.condValue) return true;
                    break;
                case "<=":
                    if (registryValue <= this.condValue) return true;
                    break;
                case "!=":
                    if (!registryValue.equals(this.condValue)) return true;
                    break;
                case "<":
                    if (registryValue < this.condValue) return true;
                    break;
                case ">":
                    if (registryValue > this.condValue) return true;
                    break;
                default:
                    throw new Exception("Unknown condition: " + condType);

            }
            return false;
        }
    }

    int increaseRegister(String registerName, int val, boolean isIncrese) {
        if (null == registers.get(registerName)) {
            int newValue = isIncrese ? val : (-1) * val;
            registers.put(registerName, newValue);
        } else {
            int updatedValue = registers.get(registerName) + (isIncrese ? val : (-1) * val);
            registers.put(registerName, updatedValue);
        }
        return registers.get(registerName);
    }
}
