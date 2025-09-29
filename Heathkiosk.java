import java.util.Scanner;
import java.util.Random;
public class HealthKiosk {
    public static void main(String[] args) {

        Scanner input= new Scanner(System.in);

        System.out.println("Welcome on the app of the health center");

        System.out.println("Enter service code (P/L/T/C):");

        String Single_letter =input.nextLine();

        String  Structure="a";
        double weight=0;
        double height=0;
        double bmi= weight/(height*height);
        double metric= Math.round(bmi*10)/10.0;

        switch (Single_letter.toUpperCase()) {
            case "P":
                System.out.println("Go to: Pharmacy Desk");
                Structure="PHARMACY";
                break;
            case "L":
                System.out.println("Go to: Lab Desk");
                Structure="LAB";
                break;
            case "T":
                System.out.println("Go to: Triage Desk");
                Structure="TRIAGE";
                System.out.println("Enter the health metric: 1 for BMI, 2 for Dosage round-up, 3 for simple trig helper :");
                int choice=input.nextInt();
                
                switch (choice) {
                    case 1:
                        System.out.println("Enter the weight (kg) and the height (meters) :");
                        weight=input.nextDouble();
                        height=input.nextDouble();
                        String Category;
                        System.out.println("bmi :"+ metric);
                        if(metric<18.5){
                        Category="Underweight";

                        }
                        else if (metric>=18.5 || metric<24.9){
                            Category="Normal";

                        }
                        else if(metric>=25 || metric <29.9){
                            Category="Overweight";

                        }
                        else if(metric>=30){
                            Category="Obese";
                        }
                        break;
                        
                    case 2:
                        System.out.println( "enter the required dosage (mg) :");
                        double dosage=input.nextDouble();
                        double tablets=dosage/250;
                        int Tablets =(int)Math.ceil(tablets);
                        System.out.println("The number of tablets required is "+Tablets);
                        break;
                    case 3:
                        System.out.println("Enter an angle (degrees) : ");
                        double degrees=input.nextDouble();
                        double radian=Math.toRadians(degrees);
                        double cos=Math.cos(radian);
                        double sin= Math.sin(radian);
                        System.out.println("The sinus of"+degrees+" is "+Math.round(sin*1000)/1000.0);
                        System.out.println("The cosinus of"+degrees+" is "+Math.round(cos*1000)/1000.0);

                    default:
                        System.out.println("This option is not available");
                        break;
                }
                break;
            case "C":
                System.out.println("Go to: Counseling Desk");
                Structure="COUNSELING";
                break;
            default:
                System.out.println("Invalid service code");
                break;

        }
        
        
        Random rnd = new Random();
        String chars="ABCDEFGHIJKLMNOPQRSTUVXYZ";
        char c = chars.charAt(rnd.nextInt(chars.length()));

        int min=3;
        int max =9;
        int first =rnd.nextInt(max - min + 1) + min;
        int second=rnd.nextInt(max - min + 1) + min;
        int third=rnd.nextInt(max - min + 1) + min;
        int fourth=rnd.nextInt(max - min + 1) + min;

        String C=Character.toString(c);
        String FIRST=Integer.toString(first);
        String SECOND=Integer.toString(second);
        String THIRD=Integer.toString(third);
        String FOURTH=Integer.toString(fourth);


        String ID= C+FIRST+SECOND+THIRD+FOURTH;

        if (ID.length()!=5){
            System.out.println(" Invalid length.");
        }
        char beginning =ID.charAt(0);
        if (!Character.isLetter(beginning)) {
            System.out.println(" Invalid: first char must be a letter");
        }
        char c1 = ID.charAt(1); 
        char c2 = ID.charAt(2);
        char c3 = ID.charAt(3); 
        char c4 = ID.charAt(4); 

        if (!Character.isDigit(c1)||!Character.isDigit(c2)||!Character.isDigit(c3)||!Character.isDigit(c4)){
            System.out.println("Invalid: last 4 must be digits");

        }
        else{
            System.out.println("ID OK");
        }

        System.out.println("Please enter first name: ");
        String name= input.nextLine();

        char base=name.toUpperCase().charAt(0);

        char shifted= (char)('A'+(base-'A'+2)%26);

        String LastTwo1=Character.toString(c3);
        String LastTwo2=Character.toString(c4);
        String New_shifted=Character.toString(shifted);
        String New_metric=Double.toString(metric);

        String FinalFormat=New_shifted+LastTwo1+LastTwo2+"-"+New_metric;
        System.out.println("Display Code :"+FinalFormat);

        
        switch (Single_letter.toUpperCase()) {
            case "P","L","C":
                System.out.println(Structure+"|"+ID+"|"+FinalFormat);
                break;
            case "T":
                System.out.println(Structure+"|"+ID+"|"+bmi+"|"+FinalFormat);
                break;
            
        }

    }
    
}
