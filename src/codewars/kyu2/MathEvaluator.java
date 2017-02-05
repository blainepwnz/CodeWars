package codewars.kyu2;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Created by Andrew on 01.02.2017.
 */
public class MathEvaluator {
    public double calculate(String expression) {
        String result = null;
        try {
            ScriptEngineManager mgr = new ScriptEngineManager();
            ScriptEngine engine = mgr.getEngineByName("JavaScript");
            result =engine.eval(expression).toString();
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        return Double.valueOf(result);
    }

}
