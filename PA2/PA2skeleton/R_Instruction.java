
public class R_Instruction extends Instruction {
	private String Rm;
	private String shamt;
	private String Rn;
	private String Rd;

	public R_Instruction(String name, String remainingBinary) {
		super(name);
		// NEED TO FIX AND TEST THESE
		Rm = remainingBinary.substring(11, 16);
		shamt = remainingBinary.substring(11, 16);
		Rn = remainingBinary.substring(11, 16);
		Rd = remainingBinary.substring(11, 16);
	}

	@Override
	public void printInstruction() {
		// TODO Auto-generated method stub
		
	}

}
