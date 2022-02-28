public class decoder {
    static String cypher = "LHGVIUDVJDKVQBRMQNROUCRW";

    public static String cipher(String msg, int shift){
        String s = "";
        int len = msg.length();
        for(int x = 0; x < len; x++){
            char c = (char)(msg.charAt(x) + shift);
            if (c > 'Z')
                s += (char)(msg.charAt(x) - (26-shift));
            else if (c < 'A')
                s += (char)(msg.charAt(x) - (26+shift));
            else
                s += (char)(msg.charAt(x) + shift);
        }
        return s;
    }

    public static int getCharValue(char c){
        int temp = (int)c;
        int temp_integer = 64; //for upper case
        return temp-temp_integer;
    }

    public static String rotateByValue(String input, int mod){
        String output = "";

        char[] ch  = input.toCharArray();
        for(char c : ch){
            output += cipher(String.valueOf(c), getCharValue(c) + mod);
        }

        return output;
    }

    public static String rotateByPosition(String input, int indexStart){
        String output = "";

        char[] ch  = input.toCharArray();
        int position = 0;
        for(char c : ch){
            output += cipher(String.valueOf(c), position + indexStart);
            position++;
        }

        return output;
    }

    public static String rotateByPositionValue(String input){
        String output = "";

        char[] ch  = input.toCharArray();
        int[] values = new int[ch.length];

        int position = 0;
        for(char c : ch){
            values[position] = getCharValue(c);
            position++;
        }

        position = 0;
        for(char c : ch){
            output += cipher(String.valueOf(c), values[position]);
            position++;
        }

        return output;
    }

    public static String rotateByPositionValueCascade(String input){
        String output = "";

        char[] ch  = input.toCharArray();
        int[] values = new int[ch.length];

        int position = 0;
        for(char c : ch){
            values[position] = getCharValue(c);
            position++;
        }

        position = 0;
        for(char c : ch){
            if(getCharValue(ch[position]) >= 24)
                output += cipher(String.valueOf(c), getCharValue(ch[getCharValue(ch[position])-24]));
            else
                output += cipher(String.valueOf(c), getCharValue(ch[getCharValue(ch[position])]));
            position++;
        }

        return output;
    }

    public static String rotateByPositionValueOneForward(String input){
        String output = "";

        char[] ch  = input.toCharArray();
        int[] values = new int[ch.length];

        int position = 0;
        for(char c : ch){
            values[position] = getCharValue(c);
            position++;
        }

        position = 0;
        for(char c : ch){
            if (position == values.length -1)
                output += cipher(String.valueOf(c), values[0]);
            else
                output += cipher(String.valueOf(c), values[position+1]);
            position++;
        }

        return output;
    }

    public static String rotateByDepression(String input){
        String output = "";

        char[] ch  = input.toCharArray();
        int[] values = new int[ch.length];

        int position = 0;
        for(char c : ch){
            values[position] = getCharValue(c);
            position++;
        }

        position = 0;
        for(char c : ch){
            int shiftLocation = getCharValue(c);
            if (shiftLocation > values.length-1){
                shiftLocation -= values.length;
            }
            output += cipher(String.valueOf(c), values[getCharValue(ch[shiftLocation])]);
            position++;
        }

        return output;
    }

    public static void main(String[] args) {
        System.out.println(rotateByValue(cypher, -1));
        System.out.println(rotateByValue(cypher, 0));
        System.out.println(rotateByValue(cypher, 1));
        System.out.println(rotateByPosition(cypher, 0));
        System.out.println(rotateByPosition(cypher, 1));
        System.out.println(rotateByPositionValue(cypher));
        System.out.println(rotateByPositionValueCascade(cypher));
        System.out.println(rotateByPositionValueOneForward(cypher));
        System.out.println(rotateByDepression(cypher));
    }
}
