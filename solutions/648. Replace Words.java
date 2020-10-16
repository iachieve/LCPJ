class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] words = sentence.split(" ");
        Map<String, Boolean> prefixes = new HashMap<>();
        for(String dic : dictionary) prefixes.put(dic, true);
        
        for(int wi = 0; wi < words.length; wi++){
            String word = words[wi];
            for(int i = 0; i < word.length(); i++){
                String part = word.substring(0, i);
                if(prefixes.get(part) != null){
                    words[wi] = part;
                    break;
                }
            }
        }
        return String.join(" ", words);
    }
}
​
​
// class Solution {
//     Node root=new Node();
//     public String replaceWords(List<String> dictionary, String sentence) {
//         String str[]=sentence.split(" ");
//         for(String s:dictionary)
//         {
//             addWord(s);
//         }
//         for(int i=0;i<str.length;i++)
//         {
//             String res=search(str[i]);
//             if(res!=null)
//               str[i]=res;
