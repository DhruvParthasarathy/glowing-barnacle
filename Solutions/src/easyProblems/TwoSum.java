package easyProblems;


import java.util.Scanner;
public class TwoSum {

	/**
	 * NEEDS TO BE RETRIED
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);


		
		boolean flag = true;
		while(flag) 
		{	
			
	    int[] nums = new int[10000];
		int[] arr = new int[2]; // [0,0]
		int n,target,i,j;

		
		System.out.println("\nPlease select the action \n "
				+ "1 - Finding index of numbers that add up to the target \n 2 - To exit the program");	
			if(sc.hasNextInt()) {
			int menu_input=sc.nextInt();
				switch(menu_input) {
					case 1 :
					{
						sc.nextLine();
						System.out.print("How many numbers in the array? ");
						n = sc.nextInt();
						sc.nextLine();
						while(n<2)
						{
							System.out.print("Kindly enter a number greater than 2 : "); 
							n = sc.nextInt(); 
						}
						while(n>10000)
						{
							System.out.println("You cannot enter more than 10000 elements");	
							n = sc.nextInt();
						}
						System.out.print("Enter the elements of the array :");	
						for(i=0;i<n;i++)
						{
							nums[i]=sc.nextInt();						
						}
						System.out.print("Please enter the target value you are looking for: ");
						target = sc.nextInt();
						
						//function call to find target 
						for( i=0; i<n; i++){
						    for( j=i+1; j<n; j++){
								if(nums[j]==target-nums[i]){
								    arr[0]= i;
								    arr[1]= j;
								    break;
								}
						    }
						    
						    if(arr[0] != arr[1]) {
						    	break;
						    }
						}
						if(arr[0] ==  arr[1]) {
							System.out.printf("There are no such elements in the array\n");
						}
						else {
							System.out.printf("The elemnts are in the positions %s and %s",arr[0],arr[1],"\n");
						}
						
					break;
					}
					case 2:
					{
						flag=false;
						System.out.printf("\nExiting program. Good bye! \n \n");
						break;
					}
					default:
						break;
					
				}
			}
			else {
				System.out.println("ERROR: Non integer value found: " + sc.next() + "\n");
			}

			

		}
		sc.close();
	      
	}

}

