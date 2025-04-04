import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class Calculator {
    public double Evaluate(String expression) throws ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
        Object result = engine.eval(expression);
        return Double.parseDouble(result.toString());
    }
}
