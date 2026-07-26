class Solution {
    public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {
        int i=0;
        int j=0;
        List<List<Integer>> list = new ArrayList<>();
        while(i<series1.length && j<series2.length){
            List<Integer> sublist = new ArrayList<>();
            int t1 = series1[i][0];
            int t2 = series2[j][0];
            int v1 = series1[i][1];
            int v2 = series2[j][1];
            if(t1==t2){
                sublist.add(t1);
                sublist.add(v1 + v2);
                i++;
                j++;
            }
            else if(t1<t2){
                sublist.add(t1);
                sublist.add(v1 + v2);
                i++;
            }
            else if(t1>t2){
                sublist.add(t2);
                sublist.add(v1 + v2);
                j++;
            }
            list.add(sublist);
        }
        while(i<series1.length){
            List<Integer> sublist = new ArrayList<>();
            int curr1 = series1[i][1];
            sublist.add(series1[i][0]);
            sublist.add(curr1);
            i++;
            list.add(sublist);
        }
        while(j<series2.length){
            List<Integer> sublist = new ArrayList<>();
            int curr2 = series2[j][1];
            sublist.add(series2[j][0]);
            sublist.add(curr2);
            j++;
            list.add(sublist);
        }
        return list;
        
    }
}