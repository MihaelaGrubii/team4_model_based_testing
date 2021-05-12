package coffee.test;

import com.coffee.AddRecipe4;
import org.graalvm.polyglot.PolyglotException;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.test.Result;
import org.graphwalker.java.test.TestExecutionException;
import org.junit.Test;

import javax.script.Bindings;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class TestExecutor {

//    private Object AddRecipe4;
//
//    @Test
//    public void runTest() throws Exception {
//        execute(TestAddRecipeeHappyPath.class);
//    }
//
//    private void execute(Class<? extends ExecutionContext> test) throws IOException {
//        org.graphwalker.java.test.TestExecutor executor = new org.graphwalker.java.test.TestExecutor(test);
//        ScriptEngine engine = new ScriptEngineManager().getEngineByName("graal.js");
//        Bindings bindings = engine.createBindings();
//        bindings.put("polyglot.js.allowAllAccess", true);
//        bindings.put("e_Start()", coffee.test.TestAddRecipeeHappyPath.class);
//        engine.setBindings(bindings, ScriptContext.ENGINE_SCOPE);
//        Date startTime = new Date();
//        Result result = executor.execute(true);
//        executor.reportResults(new File("target/reports"), startTime, System.getProperties());
//        if (result.hasErrors()) {
//            throw new TestExecutionException();
//        }
//    }
}
