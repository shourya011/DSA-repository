class Solution {
    public int totalNumbers(int[] digits) {
        ArrayList<int[]> list = new ArrayList<>();

        for (int i = 0; i < digits.length; i++) {
            for (int j = i + 1; j < digits.length; j++) {
                for (int k = j + 1; k < digits.length; k++) {
                    int[] temp = {
                        digits[i],
                        digits[j],
                        digits[k]
                    };

                    list.add(temp);
                }
            }
        }

        int size = list.size();

        for (int i = 0; i < size; i++) {
            int[] a = list.get(i).clone();

            int temp = a[1];
            a[1] = a[2];
            a[2] = temp;

            list.add(a);
        }

        size = list.size();

        for (int i = 0; i < size; i++) {
            int[] a = list.get(i).clone();

            int temp = a[0];
            a[0] = a[2];
            a[2] = temp;

            list.add(a);
        }

        size = list.size();

        for (int i = 0; i < size; i++) {
            int[] a = list.get(i).clone();

            int temp = a[0];
            a[0] = a[1];
            a[1] = temp;

            list.add(a);
        }

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < list.size(); i++) {
            int[] a = list.get(i);

            if (a[0] != 0 && a[2] % 2 == 0) {
                int number = a[0] * 100
                           + a[1] * 10
                           + a[2];

                set.add(number);
            }
        }

        return set.size();
    }
}


//3483. Unique 3-Digit Even Numbers