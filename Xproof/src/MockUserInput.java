import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class MockUserInput {
	public void MockUserLRData() {
	    System.setIn(new ByteArrayInputStream("User1\nPASSWD1\n".getBytes()));
	}
	public void MockUserLWData() {
	    System.setIn(new ByteArrayInputStream("Usernt\nPASSWDnt\n".getBytes()));
	}
	public void MockUserSelectData() {
		System.setIn(new ByteArrayInputStream("L\n".getBytes()));
	}
	
	public void MockUserSelectDataMinus() {
		System.setIn(new ByteArrayInputStream("l\n".getBytes()));
	}
	
	public void MockUserSelectDataReg() {
		System.setIn(new ByteArrayInputStream("r\n".getBytes()));
	}
	
	public void MockUserLogReg(int i) {
		switch (i) {
			case 1:
				System.setIn(new ByteArrayInputStream("r\nUsernew\nPASSWDN\nl\nUsernew\nPASSWDN\n".getBytes()));
				break;
			case 2:
				System.setIn(new ByteArrayInputStream("r\nU\nPASSWDN\nr\nUsernew\nPASSWDN\nl\nUsernew\nPASSWDN\n".getBytes()));
				break;
			case 3:
				System.setIn(new ByteArrayInputStream("L\nUser1\nPASSWD1\n".getBytes()));
				break;
			case 4:
				System.setIn(new ByteArrayInputStream("l\nUsernt\nPASSWDnt\nL\nUser1\nPASSWD1\n".getBytes()));
				break;
			}
		}
	public void MockUserSelect(String sel) {
		System.setIn(new ByteArrayInputStream((sel+"\n").getBytes()));
	}
	public void MockUserFull() {
		System.setIn(new ByteArrayInputStream(("l\nUser1\nPASSWD1\n0\n").getBytes()));
	}
	public void MockUserFull1() {
		System.setIn(new ByteArrayInputStream(("l\nUser1\nPASSWD1\n1\nl\nUser1\nPASSWD1\n0\n").getBytes()));
	}
	public void MockUserFull2() {
		System.setIn(new ByteArrayInputStream(("l\nUser1\nPASSWD1\n2\n0\n").getBytes()));
	}
	public void MockUserFull3() {
		System.setIn(new ByteArrayInputStream(("\n").getBytes()));
	}
}
