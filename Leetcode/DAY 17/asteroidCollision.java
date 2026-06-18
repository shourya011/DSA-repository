class asteroidCollision{
public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> ans = new Stack<>();
        for(int i=0;i<asteroids.length;i++){
            if(!ans.isEmpty()){
                if(ans.peek()<0){
                    ans.push(asteroids[i]);
                }
                else{
                    if(asteroids[i]>0){
                        ans.push(asteroids[i]);
                    }
                    else{
                        int value = asteroids[i] * -1;
                        int top = 0;
                        boolean destroyed = false;
                        if(ans.peek()<0)
                            top = ans.peek() * 1;
                        else{
                            top = ans.peek();
                        }
                        while (!ans.isEmpty() && ans.peek() > 0 && asteroids[i] < 0) {
                            if (ans.peek() < -asteroids[i]) {
                                ans.pop();
                            }
                            else if (ans.peek() == -asteroids[i]) {
                                ans.pop();
                                destroyed = true;
                                break;
                            }
                            else {
                                destroyed = true;
                                break;
                            }
                        }
                        if(destroyed==false)
                            ans.push(asteroids[i]);
                    }
                }
            }
            else{
                ans.push(asteroids[i]);
            }
        }
        int[] arr = new int[ans.size()];
        int i = ans.size()-1;
        while(!ans.isEmpty()){
            arr[i--] = ans.pop();
        }
        return arr;
    }
}