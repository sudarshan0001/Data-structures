class Tries{
    static class Node{
                Node[] children;
                boolean endOfWord;
        
                public Node(){
                    children = new Node[26];
                    for(int i=0;i<26;i++){
                        children[i] = null;
                    }
                    endOfWord = false;
                }
            }
        
            static Node root = new Node();
        
        
            //Building trie data structure using iteration
            public static void insert(String key){
                Node curr = root;
        
                for(int i=0;i<key.length();i++){
                    int idx = key.charAt(i)-'a';
                    if(curr.children[idx] == null){
                        curr.children[idx] = new Node();
                    }
                    if(i == key.length()-1){
                        curr.children[idx].endOfWord = true;
                    }
                    curr = curr.children[idx];
                }
            }

            //Building trie using recusion
            public static void insertRe(Node root,String key){
                if(key.length() == 0){
                    root.endOfWord = true;
                    return;
                }

                int idx = key.charAt(0)-'a';

                Node child = root.children[idx];
                if(child == null){
                    child = new Node();
                    root.children[idx] = child;
                }

                insertRe(child,key.substring(1));
            }
        
            //Search a string using iteration
            public static boolean search(String key){
                Node curr = root;
                for(int i=0;i<key.length();i++){
                    int idx = key.charAt(i) - 'a';
                    if(curr.children[idx] == null){
                        return false;
                    }
                    if(i == key.length()-1 && curr.children[idx].endOfWord == false){
                        return false;
                    }
                    curr = curr.children[idx];
                }
                return true;
            }

            //search using recursion
            public static boolean searchRe(Node root, String key){
                if(key.length() == 0 ){
                    return root.endOfWord;
                }

                int idx = key.charAt(0)-'a';
                Node child = root.children[idx];
                if(child == null){
                    return false;
                }

                return searchRe(child,key.substring(1));
            }

            //word break problem
            public static boolean wordBreak(String key){
                int len = key.length();
                if(len == 0){
                    return true;
                }
                for(int i=1;i<=key.length();i++){
                    if(searchRe(root,key.substring(0,i)) && wordBreak(key.substring(i))){
                        return true;
                    }
                }
                return false;
            }

            //prefix or word starts with ***
            public static boolean startsWith(Node root, String key){
                if(key.length() == 0){
                    return true;
                }

                int idx = key.charAt(0)-'a';
                Node child = root.children[idx];
                if(child == null){
                    return false;
                }
                child = root.children[idx];

                return startsWith(child,key.substring(1));
            }

            //count number of nodes in the trie
            public static int countNodes(Node root){
                if(root == null){
                    return 0;
                }

                int count = 0;
                for(int i=0;i<26;i++){
                    if(root.children[i] != null){
                        count += countNodes(root.children[i]);
                    }
                }
                return count+1;
            }


            //longest word with all prefixes 

            public static String ans = "";

            public static void longestWord(Node root,StringBuilder temp){
                if(root == null){
                    return;
                }

                for(int i=0;i<26;i++){
                    if(root.children[i] != null && root.children[i].endOfWord == true){
                        temp.append((char)(i+'a'));
                        if(temp.length()>ans.length()){
                            ans = temp.toString();
                        }
                        longestWord(root.children[i], temp);
                        temp.deleteCharAt(temp.length()-1);
                    } 
                }
            }
        
            public static void main(String[] args){
        
                // String[] words = {"i","like","samsung","sam","mobile"};
        
                // for(int i=0;i<words.length;i++){
                //     insertRe(root,words[i]);
                // }
        
                //System.out.println(searchRe(root,"like"));
                // String key = "ilikesung";

                // System.out.println(wordBreak(key));

                // System.out.println(startsWith(root, "sami"));

                // String word = "apple";
                // for(int i=0;i<word.length();i++){
                //     insert(word.substring(i));
                // }

                // System.out.println("number of unique substrings: "+countNodes(root));
                
                String[] words = {"ju","k","ja","jp","jpp","u","jpa","ja","j","jph","jps","p"};

                for(int i=0;i<words.length;i++){
                    insert(words[i]);
                }

                // StringBuilder temp = new StringBuilder("");
                longestWord(root,new StringBuilder(""));

                System.out.println(ans);

            }
}