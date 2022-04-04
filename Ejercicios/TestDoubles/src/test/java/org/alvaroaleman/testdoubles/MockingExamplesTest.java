package org.alvaroaleman.testdoubles;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MockingExamplesTest {

  //stub
  private class ExampleClass1 {
    private boolean AcceptingAuthorize(String username, String password){
      return true;
    }
  }

  @Test
  public void test() {
    ExampleClass1 example = Mockito.mock(ExampleClass1.class) ;

    assertNotNull(example) ;
  }
}
