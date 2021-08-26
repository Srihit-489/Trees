class Solution {
    public boolean isValidSerialization(String preorder) {
        LinkedList<String> mylist = new LinkedList<>();
        String[] nums = preorder.split(",");
        for(String str : nums){
            mylist.add(str);
        }
        return isValid(mylist);
    }
    
    public boolean isValid(LinkedList<String> mylist){
        String hash = "#";
        if(mylist.size()  == 1){
           // return mylist.get(0).equals('#');
            return mylist.get(0).equals(hash);
        }else if(mylist.size() < 3){
            return false;
        }else{
            int initial = mylist.size();
            int i = 0;
            int count = 1;
            while(i+2 < mylist.size()){
                if(!mylist.get(i).equals("#")){
                    String num1 = mylist.get(i+1);
                    String num2 = mylist.get(i+2);
                    if(! num1.equals(hash) || !num2.equals(hash)){
                        i++;
                        continue;
                    }
                   // System.out.println("I am inside ");
                    mylist.remove(i);
                    mylist.remove(i);
                    i = 0;
                }else{
                    
                    i++;
                }
            }
            
            if(initial == mylist.size())
                return false;
            return mylist.size() == 1 && mylist.get(0).equals(hash);
        }
    }
}
