package codewars.kyu2;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Andrew on 05.02.2017.
 */
public class Interpreter {
    private HashMap<Character, String> variableValueMap = new HashMap<>();

    public Double input(String input) {
        String noSpaceInput = input.replaceAll(" ", "");
        if (noSpaceInput.isEmpty()) {
            return null;
        } else if (isInvalid(input)) {
            throw new RuntimeException();
        }
        return calculateInRecursion(noSpaceInput);

    }

    private double calculateInRecursion(String expression) {
        if (isExpressionNoVariables(expression)) {
            return calculate(expression);
        } else if (matchesVariable(expression)) {
            Character variable = expression.charAt(0);
            Double result = calculateInRecursion(expression.substring(2));
            variableValueMap.put(variable, String.valueOf(result));
            return result;
        } else if (isInParenthesis(expression)) {
            return calculateInRecursion(expression.substring(1, expression.length() - 1));
        } else if(expression.contains("=")){
            Matcher nearbyParenthesisMatcher = getNearbyParenthesis(expression);
            nearbyParenthesisMatcher.find();
            int startingIndex = nearbyParenthesisMatcher.start();
            int endingIndex = nearbyParenthesisMatcher.end();
            return calculateInRecursion(expression.substring(0,startingIndex)+calculateInRecursion(expression.substring(startingIndex,endingIndex))+expression.substring(endingIndex));
        } else {
            for (Character character : variableValueMap.keySet()) {
                expression = expression.replaceAll(String.valueOf(character), variableValueMap.get(character));
            }
            return calculate(expression);
        }
    }


    private double calculate(String expression) {
        String result = null;
        try {
            ScriptEngineManager mgr = new ScriptEngineManager();
            ScriptEngine engine = mgr.getEngineByName("JavaScript");
            result = engine.eval(expression).toString();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return Double.valueOf(result);
    }

    private boolean matchesVariable(String input) {
        Pattern pattern = Pattern.compile("^[A-Za-z_]{1}[=]{1}.+");
        return pattern.matcher(input).find();
    }

    private boolean isExpressionNoVariables(String input) {
        return Pattern.compile("^[\\d\\+\\-\\*\\%\\/\\(\\)]+$").matcher(input).find();
    }

    private boolean isInParenthesis(String input) {
        return Pattern.compile("^[\\(].+[\\)]$").matcher(input).find();
    }

    private boolean isInvalid(String input) {
        return Pattern.compile("[\\d\\_]+ [\\d\\_]+").matcher(input).find();
    }

    private Matcher getNearbyParenthesis(String input) {
        return Pattern.compile("[\\(]{1}[^(]+[\\)]{1}").matcher(input);
    }

}
