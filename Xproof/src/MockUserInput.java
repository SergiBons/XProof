import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class MockUserInput {
	public void MockUserLRData() {
	    System.setIn(new ByteArrayInputStream("User1\nPASSWD1\n".getBytes()));
	}
	public void MockUserLRDataWrong() {
	    System.setIn(new ByteArrayInputStream("User1\nPASSWD1\n".getBytes()));
	}
	public void MockUserSelectData() {
		System.setIn(new ByteArrayInputStream("L\n".getBytes()));
	}
	
}
