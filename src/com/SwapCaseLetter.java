public class SwapCaseLetter {

    public static void main(String[] args) {
        //Input: HackerRank.com presents "Pythonist 2."
        //Output: hACKERrANK.COM PRESENTS "pYTHONIST 2."

        String value = "HackerRank.com presents Pythonist 2.";
        StringBuilder br = new StringBuilder();
        for (int i = 0; i < value.length(); i++) {
            int c = value.charAt(i);
            // System.out.println(c + " :" + value.charAt(i));
            if (c >= 65 && c <= 90) // from A to Z capital
            {
                br.append(String.valueOf(value.charAt(i)).toLowerCase());
            } else if (c >= 97 && c <= 122) // from a to z small
            {
                br.append(String.valueOf(value.charAt(i)).toUpperCase());
            } else {
                br.append(value.charAt(i));
            }

            //   System.out.println("value=" + br);
        }
        System.out.println(br);
    }
}
