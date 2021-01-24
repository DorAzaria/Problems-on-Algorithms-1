package LittleProblems;

public class nodeData {
   // static class program{
        String name;
        int lengthInt;
        int freq;

        public nodeData(String name, int length, int freq){
            this.name=name;
            this.freq=freq;
            this.lengthInt =length;
        }
        @Override
        public String toString(){
            return "name = "+name+" length = "+ lengthInt +" freq = "+freq;
        }
    }

