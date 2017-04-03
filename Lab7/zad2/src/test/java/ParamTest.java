
import org.jbehave.core.annotations.*;
import static org.junit.Assert.*;

public class ParamTest 
{
    private NWD test;

    @AfterScenario(uponOutcome=AfterScenario.Outcome.SUCCESS, uponType=ScenarioType.EXAMPLE)
    public void afterSuccessfulScenario() {
    	System.out.println("Success.");
    }
         
    @AfterScenario(uponOutcome=AfterScenario.Outcome.FAILURE, uponType=ScenarioType.EXAMPLE)
    public void afterFailedScenario() {
    	System.out.println("Fail.");
    }
    
    @Given("Create New NWD")
    public void givenCreateNewNWD(){
        test = new NWD();
    }
    
    @When("nwd <num1> i <num2>")
    @Aliases(values={"consolenwd <num1> i <num2>",
    		"notnwd <num1> i <num2>"})
    public void whenNwd4And2(@Named("num1") int num1,@Named("num2") int num2){
        test.a = num1;
        test.b = num2;
    }

    @Then("equal <num3>")
    public void thenEqual(@Named("num3") int num3){
        assertEquals(num3,test.nwd());
    }

    @Then("notequal <num3>")
    public void thenNotEqual(@Named("num3") int num3){
        assertNotEquals(num3,test.nwd());
    }

    @Then("consoleequal <num3>")
    public void thenconsoleNotEqual(@Named("num3") int num3){
        assertEquals(num3,test.nwd());
    }
    
    private int apple = 0;
    private int tomato2 = 0;
    @When("the {apple|tomato} is $tomato")
    public void theItemPriceIs(int tomato) {
        apple = tomato;
        tomato2 = tomato;
    }
    
    @Given("the 30")
    public void giventhe30(){
    	assertEquals(30,apple + tomato2);
    }
    
}
