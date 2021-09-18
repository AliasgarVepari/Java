public class StringCalculator
{

    private final String delimiter = ",|/n|//[***]/n1";

    public int Add(String numbers) throws Exception
    {
        String[] input = numbers.split(delimiter);
        if (isEmpty(numbers))
        {
            return 0;
        }
        if(numbers.length()==1)
        {

            return stringToInt(numbers);
        }
        else
        {
            return sum(input);
        }

    }

    private int sum(String[] input) throws Exception
    {
        negativeException(input);
        int sum = 0;
        for(String i:input)
        {
            if(stringToInt(i)>1000)
            {
                continue;
            }
            sum += stringToInt(i);
        }

        return sum;
    }

    private void negativeException(String[] input ) throws Exception
    {
        Boolean flag = null;
        if(input.length>1)
        {
            flag=true;
        }
        if(stringToInt(input[0])<0 && stringToInt(input[1])<0 && flag==true)
        {
            throw new Exception ("negatives not allowed:"+input[0]+","+input[1]);
        }
        for(String i:input)
        {


            if(stringToInt(i)<0)
            {
                throw new Exception ("negatives not allowed");
            }

        }


    }

    private int stringToInt(String numbers)
    {
        return Integer.parseInt(numbers);
    }

    private boolean isEmpty(String numbers)
    {
        return numbers.isEmpty();
    }



}

