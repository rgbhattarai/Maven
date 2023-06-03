package Teste.com;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnerMethods implements ITestListener{

	// This belongs to ITestListner and will execute before starting of the test Set/batch
	public void onStart(ITestContext arg) {
		System.out.println("Starts Test execution..."+arg.getName());
	}
	// This belongs to ITestListner and will execute AFTER starting of the test Set/batch	
    public void onFinish(ITestContext arg) {					
    	System.out.println("Finish Test execution..."+arg.getName());			
        		
    }
 // This belongs to ITestListner and will execute before the main test starts i.e @Test
    public void onTestStart(ITestResult arg0) {					
    	System.out.println("Start Test..."+arg0.getName());				
        		
    }
 // This belongs to ITestListner and will execute when Test is Skipped
    public void onTestSkipped(ITestResult arg0) {					
    	System.out.println("Skipped Test..."+arg0.getName());					
      }
 // This belongs to ITestListner and will execute when Test is passed 
    public void onTestSuccess(ITestResult arg0) {					
    	System.out.println("Passed Test..."+arg0.getName());			
        		
    }
    // This belongs to ITestListner and will execute when a Test is failed
  	
    public void onTestFailure(ITestResult arg0) {					
    	System.out.println("Failed Test..."+arg0.getName());			
        		
    }
   // Not so Important 	
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {					
        // TODO Auto-generated method stub				
        		
    }	
}
