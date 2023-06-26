import java.util.*;

public class ArrayCombinations {

    // Function to find the Combinations of doubled target and merged array
    public static int[][] findCombinationsDouble(int[] nums, int doubleTarget) {
        List<int[]> combinations = new ArrayList<>();

        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                for (int k = j + 1; k < nums.length - 1; k++) {
                    for (int l = k + 1; l < nums.length; l++) {
                        if (nums[i] + nums[j] + nums[k] + nums[l] == doubleTarget) {
                            int[] quadruplet = { nums[i], nums[j], nums[k], nums[l] };
                            combinations.add(quadruplet);
                        }
                    }
                }
            }
        }

        return combinations.toArray(new int[0][4]);
    }

    // Function to find the Combinations
    public static int[][] findCombinations(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        List<int[]> combinations = new ArrayList<>();

        for (int num : nums) {
            int complement = target - num;
            if (map.containsKey(complement)) {
                int[] pair = { num, complement };
                combinations.add(pair);
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return combinations.toArray(new int[0][2]);
    }

    // Function to merge Array
    public static int[] mergeArray(int[][] combinations) {
        List<Integer> mergedList = new ArrayList<>();
        for (int[] pair : combinations) {
            mergedList.addAll(Arrays.asList(pair[0], pair[1]));
        }
        Collections.sort(mergedList);

        int[] mergedArray = new int[mergedList.size()];
        for (int i = 0; i < mergedArray.length; i++) {
            mergedArray[i] = mergedList.get(i);
        }
        return mergedArray;
    }

    // Function to print 2D Array
    public static void printArray(int[][] array) {
        System.out.print("[ ");
        for (int j = 0; j < array.length; j++) {
            int[] row = array[j];
            System.out.print("[");
            for (int i = 0; i < row.length; i++) {
                if (i == row.length - 1) {
                    System.out.print(row[i] + "");
                } else {
                    System.out.print(row[i] + ",");
                }
            }
            if (j == array.length - 1) {
                System.out.print("]");
            } else {
                System.out.print("], ");
            }
        }
        System.out.println(" ]");
    }

    // Function to print Single Array
    public static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                System.out.print(array[i] + "");
            } else {
                System.out.print(array[i] + ", ");
            }
        }
        System.out.println("]");
    }

    // Main function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // int[] nums = { 1, 3, 2, 2, -4, -6, -2, 8 };
        // int target = 4;
        System.out.println("Enter the size of the array:");
        int n = sc.nextInt();
        int nums[] = new int[n];
        System.out.println("Enter the elements of the array with space between them:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println("Enter the Target Value:");
        int target = sc.nextInt();

        // finding the combinationns and printing
        int[][] combinations = findCombinations(nums, target);
        System.out.print("First Combination for \"" + target + "\" : ");
        printArray(combinations);

        // merging the first target's 2D array into single and printing
        int[] mergedArray = mergeArray(combinations);
        System.out.print("Merge Into a single Array : ");
        printArray(mergedArray);

        // finding the combinations for doubled target and printing
        int doubleTarget = target * 2;
        int[][] doubleCombinations = findCombinationsDouble(mergedArray, doubleTarget);
        System.out.print("Second Combination for \"" + doubleTarget + "\" : ");
        printArray(doubleCombinations);
    }
}
