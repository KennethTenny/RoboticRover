import java.util.Scanner;

public class RoboticRovers 
{

	public static void main(String[] args) 
	{
		Scanner scan=new Scanner(System.in);
		
		int cornerX = scan.nextInt();		// Scanning the upper-right coordinates of the plateau
		int cornerY = scan.nextInt();
		
		//System.out.println(cornerX + " " + cornerY);
			
		
		while (scan.hasNext())			// Scan the inputs continuously until the inputs have next line.
		{

			int inputX = scan.nextInt();		// Scanning the first Input's position and rover's orientation
			int inputY = scan.nextInt();
			char orientation = scan.next().charAt(0);
			
			String instructions=scan.next();
			
			Boolean InputsCorrect=true;
			
			if(!(inputX>=0 && inputX<=cornerX))				// Checking the validity of inputs
				{
					System.out.println("Invalid InputX!");
					InputsCorrect=false;
				}
			
			if(!(inputY>=0 && inputY<=cornerY))
			{
				System.out.println("Invalid InputY!");
				InputsCorrect=false;
			}
			
			if(!(orientation=='N' || orientation=='S' || orientation=='W' || orientation=='E'))
			{
				System.out.println("Invalid Orientation!");
				InputsCorrect=false;
			}
			
			
			
			if(!InputsCorrect)								// If the inputs are incorrect, skip that particular test input
			{
				continue;
			}
			
			for(int i=0; i<instructions.length(); i++)			// Reading the instructions one by one.
			{
				if(instructions.charAt(i)=='L')					// If the instruction is Left
				{
					
					if(orientation=='N')						// Changing the orientations according to the instruction
						orientation='W';
					else if(orientation=='W')
						orientation='S';
					else if(orientation=='S')
						orientation='E';
					else if(orientation=='E')
						orientation='N';
					
				}
				
				else if(instructions.charAt(i)=='R')			// If the instruction is Right
				{
					
					if(orientation=='N')						// Changing the orientations according to the instruction
						orientation='E';
					else if(orientation=='E')
						orientation='S';
					else if(orientation=='S')
						orientation='W';
					else if(orientation=='W')
						orientation='N';
					
					
				}
				else if(instructions.charAt(i)=='M')			// If the instruction is move forward
				{
					if(orientation=='N')						// Changing the position according to the orientation instruction
					{
						if(inputY+1 <= cornerY)
						{
							inputY=inputY+1;
						}
						else
						{
							System.out.println("Cannot move in that direction for Instruction " + instructions.charAt(i));		// If it is not possible to move in that direction
							InputsCorrect=false;
							break;
						}
					}
					else if(orientation=='E')
					{
						if(inputX+1 <= cornerX)
						{
							inputX=inputX+1;
						}
						else
						{
							System.out.println("Cannot move in that direction for Instruction " + instructions.charAt(i));
							InputsCorrect=false;
							break;
						}
					}
					else if(orientation=='S')
					{
						if(inputY-1 >= 0)
						{
							inputY=inputY-1;
						}
						else
						{
							System.out.println("Cannot move in that direction for Instruction " + instructions.charAt(i));
							InputsCorrect=false;
							break;
						}
					}
					else if(orientation=='W')
					{
						if(inputX-1 >= 0)
						{
							inputX=inputX-1;
						}
						else
						{
							System.out.println("Cannot move in that direction for Instruction " + instructions.charAt(i));
							InputsCorrect=false;
							break;
						}
					}
					
					
				}
				else
				{
					System.out.println("Wrong Input entered: " + instructions.charAt(i));	//If the Instruction is anything other than L,R or M.
					InputsCorrect=false;
					break;
				}
			}
			
			if(!InputsCorrect)						// Checking the credibility of inputs.
			{
				continue;
			}
			
			System.out.println(inputX + " " + inputY + " " + orientation);		// Outputting the final position of rover after executing those instructions.
			//System.out.println(inputX+ " " + inputY + " " + instructions + " " + orientation);
			
		}
	
		scan.close();
	}

}
