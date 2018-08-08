package arrays;

/**
 * http://www.careercup.com/question?id=5741006670528512
 * 
 * we keep an index (for next element to be updated in Array) and flag
 * (fillPositive) 
 * 
 * if(fillPositive) then 
 * 	we will fill the element at index with nextPositive number 
 * else
 *  we will fill the element at index with nextNegative number
 * 
 * @author rkandur
 *
 */
public class AlternatePositiveNegativeNumbers {

	 public static Integer nextPositive(Integer[] input, Integer index) {
        for (int i = index; i < input.length; ++i) {
            if (input[i] > 0) {
                return i;
            }
        }
        return -1;
    }

    public static Integer nextNegative(Integer[] input, Integer index) {
        for (int i = index; i < input.length; ++i) {
            if (input[i] < 0) {
                return i;
            }
        }
        return -1;
    }

    public static void rotateElements(Integer[] input, Integer index1, Integer index2) {
        if (index1 >= index2) {
            return;
        }
        Integer temp = input[index2];
        for (int i = index2; i > index1; --i) {
            input[i] = input[i - 1];
        }
        input[index1] = temp;
    }

    public static void modifyArray(Integer[] input) {

        if (input == null || input.length <= 1) {
            return;
        }

        boolean isPositive = true;

        Integer pi = nextPositive(input, 0);
        Integer ni = nextNegative(input, 0);
        Integer index = 0;

        for (; pi >= 0 && pi < input.length && ni >= 0 && ni < input.length && index < input.length; ) {
            if (isPositive) {
                rotateElements(input, index, pi);
                ni = nextNegative(input, index + 1);
                pi = nextPositive(input, index + 1);
            } else {
                rotateElements(input, index, ni);
                ni = nextNegative(input, index + 1);
                pi = nextPositive(input, index + 1);
            }
            index++;
            isPositive = !isPositive;
        }

        StringJoiner joiner = new StringJoiner(" ");
        for (int i = 0; i < input.length; i++) {
            joiner.add(String.valueOf(input[i]));
        }
        System.out.println(joiner.toString());

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numOfInputs = in.nextInt();
        Integer[] input = new Integer[numOfInputs];
        for (int i = 0; i < numOfInputs; i++) {
            input[i] = in.nextInt();
        }
        modifyArray(input);
    }

}
