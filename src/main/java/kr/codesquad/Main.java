package kr.codesquad;

public class Main {
    public static void main(String[] args) {
        String a = "123";
        String b = a;
        String c = new String(b);

        if(a==b){
            System.out.println("a, b같은 객체");
        }
        if(a==c){
            System.out.println("a, c같은 객체");
        }
        if(b==c){
            System.out.println("b,c 같은 객체");
        }
        if(a.equals(c)){
            System.out.println("a,c같음");
        }
    }
}