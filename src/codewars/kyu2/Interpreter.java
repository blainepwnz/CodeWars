package codewars.kyu2;

import javafx.util.Pair;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Andrew on 05.02.2017.
 */
public class Interpreter {
    private static final String PARAM = "param0";
    private HashMap<Character, String> variableValueMap = new HashMap<>();
    private HashMap<String, Pair<Integer, String>> functionValueMap = new HashMap<>();

    public Double input(String input) {
        if (isFunctionDeclaration(input)) {
            saveFunction(input);
        }
        String noSpaceInput = input.replaceAll(" ", "");
        if (noSpaceInput.isEmpty()) {
            return null;
        } else if (isInvalid(input)) {
            throw new RuntimeException();
        }
        return calculateVariableInRecursion(noSpaceInput);
    }

    private void saveFunction(String input) {
        String[] declarationBodyArray = input.split("=>");
        String[] declarationArray = declarationBodyArray[0].trim().split(" ");
        String functionBody = declarationBodyArray[1].replaceAll(" ", "");
        String name = declarationArray[1];
        for (int i = declarationArray.length - 2; i < declarationArray.length; i++) {
            if (functionBody.contains(declarationArray[i]))
                functionBody = functionBody.replaceAll(declarationArray[i], PARAM + (i - 2));
            else
                throw new RuntimeException();
        }
        if (containsLetters(functionBody.replaceAll(PARAM, "")))
            throw new RuntimeException();
        functionValueMap.put(name, new Pair<>(declarationArray.length - 2, functionBody));
    }

    private double calculateVariableInRecursion(String expression) {
        if (isExpressionNoVariables(expression)) {
            return calculate(expression);
        } else if (matchesVariable(expression)) {
            Character variable = expression.charAt(0);
            Double result = calculateVariableInRecursion(expression.substring(2));
            variableValueMap.put(variable, String.valueOf(result));
            return result;
        } else if (isInParenthesis(expression)) {
            return calculateVariableInRecursion(expression.substring(1, expression.length() - 1));
        } else if (expression.contains("=")) {
            Matcher nearbyParenthesisMatcher = getNearbyParenthesis(expression);
            nearbyParenthesisMatcher.find();
            int startingIndex = nearbyParenthesisMatcher.start();
            int endingIndex = nearbyParenthesisMatcher.end();
            return calculateVariableInRecursion(expression.substring(0, startingIndex) + calculateVariableInRecursion(expression.substring(startingIndex, endingIndex)) + expression.substring(endingIndex));
        } else {
            for (Character character : variableValueMap.keySet()) {
                expression = expression.replaceAll(String.valueOf(character), variableValueMap.get(character));
            }
            return calculate(expression);
        }
    }


    private double calculateFunctionInRecursion(String expression) {
        return 0d;
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

    private boolean isFunctionDeclaration(String input) {
        return Pattern.compile("^fn [A-Za-z_]{1,}.+(\\=\\>)").matcher(input).find();
    }

    private boolean containsLetters(String input) {
        return Pattern.compile("[A-Za-z_]").matcher(input).find();
    }



}
